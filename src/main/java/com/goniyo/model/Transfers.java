package com.goniyo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfers {
	public Transfers(Integer buyerId, Integer sellerId, Integer stockId,float price, String date, Integer quantity) {
		super();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.stockId = stockId;
		this.price=price;
		this.date = date;
		this.quantity = quantity;
	}
	public Transfers(){}
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	 Integer transferId;
	 Integer buyerId;
	 Integer sellerId;
	 Integer stockId;
	 float price;
	 String date;
	 Integer quantity;
	 
	public Integer getTransferId() {
		return transferId;
	}
	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
