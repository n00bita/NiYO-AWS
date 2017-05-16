package com.goniyo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ownership {
	
public Ownership(int stockId, int quantity, int brokerId) {
		super();
		this.stockId = stockId;
		this.quantity = quantity;
		this.brokerId = brokerId;
	}
public Ownership(){}
@Column(name="STOCK_ID")
int stockId;
int quantity;

@Id
@Column(name="BROKER_ID")
int brokerId;

public int getStockId() {
	return stockId;
}
public void setStockId(int stockId) {
	this.stockId = stockId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getBrokerId() {
	return brokerId;
}
public void setBrokerId(int brokerId) {
	this.brokerId = brokerId;
}

}
