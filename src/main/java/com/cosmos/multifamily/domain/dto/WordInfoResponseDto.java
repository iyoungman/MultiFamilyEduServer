package com.cosmos.multifamily.domain.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by youngman on 2019-01-01.
 */
@Data
public class WordInfoResponseDto {
    private List<String> wordlist;
    private Map<String, String> wordpassinfo;

    public WordInfoResponseDto(List<String> wordlist, Map<String, String> wordpassinfo) {
        this.wordlist = wordlist;
        this.wordpassinfo = wordpassinfo;
    }
}
