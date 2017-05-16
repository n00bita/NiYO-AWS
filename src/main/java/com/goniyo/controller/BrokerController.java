package com.goniyo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goniyo.model.Broker;
import com.goniyo.model.BuyRequest;
import com.goniyo.model.Ownership;
import com.goniyo.model.Transfers;
import com.goniyo.repository.BrokerRepository;
import com.goniyo.repository.BuyRequestRepository;
import com.goniyo.repository.OwnershipRepository;
import com.goniyo.repository.StockRepository;
import com.goniyo.repository.TransfersRepository;


@RestController
public class BrokerController {

	@Autowired
	private BrokerRepository brokerRepository;
	
	@Autowired
	private OwnershipRepository ownershipRepository;
	
	@Autowired
	private BuyRequestRepository buyRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private TransfersRepository transfersRepository;
	
	@RequestMapping(method=RequestMethod.POST,value="/brokers")
	public void addBroker(@RequestBody Broker broker){
	brokerRepository.save(broker);
	}
	

	@RequestMapping("/brokers/{id}/sell")
	public List<BuyRequest> getSell(@PathVariable Integer id){
		List<Ownership> owner=ownershipRepository.findByBrokerId(id);
		List<Integer> ownedstocks = owner.stream().map(x -> x.getStockId()).collect(Collectors.toList());
		ArrayList<BuyRequest> buyRequest = new ArrayList<BuyRequest>();
		buyRepository.findAll().forEach(x -> 
		{if(ownedstocks.contains(x.getStockId()))
			buyRequest.add(x);
		});
		return buyRequest;
	}
	

	@RequestMapping(method=RequestMethod.POST,value="/brokers/{id}")
	public void addRequest(@RequestBody BuyRequest buy){
	buyRepository.save(buy);
	}
	
	@RequestMapping(value="/brokers/{sellerid}/{buyerrequestid}")
	public void doSell(@PathVariable("sellerid") Integer sellerId ,@PathVariable("buyerrequestid") Integer buyreqId){
		BuyRequest buyer = buyRepository.findByBuyId(buyreqId);
		//Update Stock Price
		stockRepository.setUserInfoById(buyer.getBidPrice(), buyer.getStockId());
		//Update Amount Owned
	    	
		     //Check If he has any
		List<Ownership> owner=ownershipRepository.findByBrokerId(buyer.getBuyerId());
		List<Integer> ownedstocks = owner.stream().map(x -> x.getStockId()).collect(Collectors.toList());
		if(ownedstocks.contains(buyer.getStockId()))
		ownershipRepository.incQuantityByBrokerId(buyer.getStockId(),buyer.getBuyerId());
		else
			ownershipRepository.save(new Ownership(buyer.getStockId(),1,buyer.getBuyerId()));
		ownershipRepository.decQuantityByBrokerId(buyer.getStockId(),sellerId);
		//Delete it from the active requests.
		buyRepository.deleteByBuyId(buyreqId);
		//Add it to completed transactions
		transfersRepository.save(new Transfers(buyer.getBuyerId(),sellerId,buyer.getStockId(),buyer.getBidPrice(),buyer.getDate(),1));
	}
	
	
	
	@RequestMapping("/brokers")
	public List<Broker> getAllBrokers(){
	ArrayList<Broker> brokers = new ArrayList<Broker>();
	brokerRepository.findAll().forEach(brokers::add);
	return brokers;
	}
	
	@RequestMapping("/brokers/{id}")
	public Broker getBroker(@PathVariable Integer id){
		return brokerRepository.findOne(id);
	}
	
	
	
	
}
