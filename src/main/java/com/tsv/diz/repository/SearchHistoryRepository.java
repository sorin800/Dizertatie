package com.tsv.diz.repository;

import com.tsv.diz.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM search_history WHERE user_id = ?1", nativeQuery = true)
    List<SearchHistory> findSearchHistoryAdsByUserId(Long id);

}
