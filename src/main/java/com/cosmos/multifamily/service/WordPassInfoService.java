package com.cosmos.multifamily.service;

import com.cosmos.multifamily.domain.dto.WordInfoResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by youngman on 2019-01-01.
 */
@Transactional
public interface WordPassInfoService {

    WordInfoResponseDto getWordPassInfoDtoBySelectLevelAndUserid(String selectLevel, String userid);

    Map<String, String> setWordPassInfo(String userid, String wordname);
}
