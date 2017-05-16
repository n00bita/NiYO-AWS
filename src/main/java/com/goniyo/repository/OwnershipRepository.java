package com.goniyo.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.goniyo.model.Ownership;

@Transactional
public interface OwnershipRepository extends CrudRepository<Ownership,Integer>{
	
	List<Ownership> findByBrokerId(int brokerId);

	@Modifying
	@Query("update Ownership o set o.quantity = o.quantity + 1 where o.stockId = ?1 and o.brokerId = ?2")
	void incQuantityByBrokerId(Integer stockId,Integer brokerId);
	
	@Modifying
	@Query("update Ownership o set o.quantity = o.quantity - 1 where o.stockId = ?1 and o.brokerId = ?2")
	void decQuantityByBrokerId(Integer stockId,Integer brokerId);
	
	/*
    @Query("SELECT r.id FROM RuleVo r where r.name = :name") 
    List<Long> findIdByName(@Param("name") String name);
    */
	
}