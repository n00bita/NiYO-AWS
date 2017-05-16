package com.goniyo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goniyo.model.Ownership;
import com.goniyo.model.Stock;
import com.goniyo.model.Transfers;
import com.goniyo.repository.OwnershipRepository;
import com.goniyo.repository.StockRepository;
import com.goniyo.repository.TransfersRepository;

@RestController
public class StockController {

	
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private OwnershipRepository ownershipRepository;
	
	@Autowired
	private TransfersRepository transfersRepository;
	
	@RequestMapping("/stocks")
	public List<Stock> getAllStocks(){
	ArrayList<Stock> stocks = new ArrayList<Stock>();
	stockRepository.findAll().forEach(stocks::add);
	return stocks;
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/admin/create")
	public void addTopic(@RequestBody Stock stock){
	stockRepository.save(stock);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/admin/transfer")
	public void addTopic(@RequestBody Ownership owner){
	ownershipRepository.save(owner);
	}
	
	@RequestMapping("/admin/reports")
	public List<Transfers> showReports(){
	ArrayList<Transfers> transfers = new ArrayList<Transfers>();
	transfersRepository.findAll().forEach(transfers::add);
	return transfers;
	}
	
	
}
