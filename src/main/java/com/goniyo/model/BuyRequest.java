package com.goniyo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuyRequest {
public BuyRequest(int buyId,int stockId, float bidPrice, int buyerId, String date) {
		super();
		this.buyId=buyId;
		this.stockId = stockId;
		this.bidPrice = bidPrice;
		this.buyerId = buyerId;
		this.date = date;
	}
public BuyRequest(){}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int buyId;
int stockId;
float bidPrice;
int buyerId;
String date;

public int getStockId() {
	return stockId;
}
public void setStockId(int stockId) {
	this.stockId = stockId;
}
public float getBidPrice() {
	return bidPrice;
}
public void setBidPrice(float bidPrice) {
	this.bidPrice = bidPrice;
}
public int getBuyerId() {
	return buyerId;
}
public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getBuyId() {
	return buyId;
}
public void setBuyId(int buyId) {
	this.buyId = buyId;
}

}
