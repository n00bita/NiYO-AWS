package com.goniyo.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.goniyo.model.BuyRequest;

public interface BuyRequestRepository extends CrudRepository<BuyRequest,Integer> {
	
	List<BuyRequest> findByStockId(String stockId);
	BuyRequest findByBuyId(int buyId);
	
	@Transactional
	void deleteByBuyId(int buyId);

}
