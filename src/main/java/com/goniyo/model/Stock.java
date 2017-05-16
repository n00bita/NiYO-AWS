package com.goniyo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stock {
	

	public Stock(String name, String symbol, Float price) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.price = price;
	}
	public Stock(){}
	

	@Column(name="STOCK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id private int stockId;
	private String name;
	private String symbol;
	private Float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

}
