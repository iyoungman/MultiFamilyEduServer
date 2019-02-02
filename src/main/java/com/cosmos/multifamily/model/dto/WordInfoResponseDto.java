package com.cosmos.multifamily.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Getter
@Setter
public class WordInfoResponseDto {
    private List<String> wordList;
    private Map<String, String> wordPassInfo;

    @Builder
    public WordInfoResponseDto(List<String> wordList, Map<String, String> wordPassInfo) {
        this.wordList = wordList;
        this.wordPassInfo = wordPassInfo;
    }
}
