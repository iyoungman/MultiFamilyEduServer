package com.cosmos.multifamily.repository;

import com.cosmos.multifamily.domain.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by youngman on 2019-01-01.
 */
public interface WordRepository extends JpaRepository<Word, String> {

    @Query(value = "select word.wordname from Word word where word.wordlevel = :selectLevel")
    List<String> getWordsByWordlevel(@Param("selectLevel") String selectLevel);

    Word findWordByWordname(String wordname);
}
