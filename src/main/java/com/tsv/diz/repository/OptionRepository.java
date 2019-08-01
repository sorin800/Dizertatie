package com.tsv.diz.repository;

import com.tsv.diz.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

	@Transactional
	@Query(value = "SELECT user_id,GROUP_CONCAT(scor) FROM option GROUP BY user_id", nativeQuery = true)
	List<Object[]> getOptions();
	
	@Transactional
	@Query(value = "SELECT * FROM option WHERE user_id = ?1", nativeQuery = true)
	List<Option> findOptionByUserId(Long id);

	@Transactional
	@Query(value = "SELECT * FROM option WHERE scor = ?1", nativeQuery = true)
	List<Option> findOptionByScore(double scor);


}
