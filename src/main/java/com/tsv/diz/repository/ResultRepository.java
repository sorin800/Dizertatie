package com.tsv.diz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsv.diz.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

	/*
	 * @Query(value = "ALTER TABLE result AUTO_INCREMENT=0",nativeQuery= true)
	 * public void resetPrimaryKey();
	 */

	@Transactional
	@Query(value = "SELECT * FROM result WHERE user_id = ?1", nativeQuery = true)
	Result findResultByUserId(Long userId);

	@Transactional
	@Query(value = "SELECT * FROM result WHERE cluster = ?1", nativeQuery = true)
	List<Result> findResultByClusterId(int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE result r set cluster =:clusterValue where r.user_id = :userId", nativeQuery = true)
	void updateUser(@Param("clusterValue") int clusterValue , @Param("userId") Long userId);

}
