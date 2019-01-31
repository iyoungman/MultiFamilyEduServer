package com.cosmos.multifamily.repository;

import com.cosmos.multifamily.domain.entity.WordPassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by YoungMan on 2019-01-01.
 */

public interface WordPassInfoRepository extends JpaRepository<WordPassInfo, Long> {

    @Query(value = "select word.wordname from WordPassInfo wordPassInfo, Word word where wordPassInfo.word = word.wordname and  word.wordlevel = :selectLevel and wordPassInfo.user = :userid")
    List<String> getWordPassInfoBySelectLevelAndUserId(@Param("selectLevel") String selectLevel, @Param("userId") String userId);
}
