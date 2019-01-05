package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.domain.dto.WordInfoResponseDto;
import com.cosmos.multifamily.domain.entity.Word;
import com.cosmos.multifamily.domain.entity.WordPassInfo;
import com.cosmos.multifamily.repository.WordPassInfoRepository;
import com.cosmos.multifamily.repository.WordRepository;
import com.cosmos.multifamily.service.WordPassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youngman on 2019-01-01.
 */
@Service
public class WordPassInfoServiceImpl implements WordPassInfoService {

    Logger logger = LoggerFactory.getLogger(WordPassInfoServiceImpl.class);
    private final WordPassInfoRepository wordPassInfoRepository;
    private final WordRepository wordRepository;

    public WordPassInfoServiceImpl(WordPassInfoRepository wordPassInfoRepository, WordRepository wordRepository) {
        this.wordPassInfoRepository = wordPassInfoRepository;
        this.wordRepository = wordRepository;
    }

    @Override
    public WordInfoResponseDto getWordPassInfoDtoBySelectLevelAndUserid(String selectLevel, String userid) {
        List<String> words = new ArrayList<>();
        List<String> wordsPass = new ArrayList<>();
        Map wordsPassInfo = new HashMap<String, Boolean>();

        try {
            words = wordRepository.getWordsByWordlevel(selectLevel);
            wordsPass = wordPassInfoRepository.getWordPassInfoBySelectLevelAndUserid(selectLevel, userid);
            wordsPassInfo = convertWordsToWordsPassInfo(words, wordsPass);
        } catch (Exception e) {
            logger.info("error" + e.toString());
        }
        return new WordInfoResponseDto(words, wordsPassInfo);
    }

    private Map<String, String> convertWordsToWordsPassInfo(List<String> words, List<String> wordsPass) {
        Map wordPassInfo = new HashMap<String, String>();
        for (String word : words) {
            if (wordsPass.contains(word)) {
                wordPassInfo.put(word, "합격");
            } else {
                wordPassInfo.put(word, "불합격");
            }
        }
        return wordPassInfo;
    }

    public Map<String, String> setWordPassInfo(String userid, String wordname) {
        Map<String, String> map = new HashMap<>();
        try {
            Word word = wordRepository.findWordByWordname(wordname);
            if(word != null) {
                WordPassInfo wordPassInfo = new WordPassInfo(word, userid);
                wordPassInfoRepository.save(wordPassInfo);
                map.put(wordname, "합격");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            logger.info("error" + e.toString());
        }
        return map;
    }
}
