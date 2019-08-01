package com.tsv.diz.repository;

import com.tsv.diz.model.SavedAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SavedAdRepository extends JpaRepository<SavedAd, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM saved_ad WHERE user_id = ?1", nativeQuery = true)
    List<SavedAd> findSavedAdsByUserId(Long id);

}
