package com.goniyo.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.goniyo.model.Stock;
@Transactional
public interface StockRepository extends CrudRepository<Stock,Integer>{

	
	@Modifying
	@Query("update Stock s set s.price = ?1 where s.stockId = ?2")
	void setUserInfoById(Float newprice,Integer stockId);
}
