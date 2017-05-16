package com.goniyo.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Broker {
  	

public Broker(String loginId,String name) {
		super();
		this.loginId = loginId;
		this.name=name;
	}

public Broker(){}

//@Temporal(TemporalType.TIMESTAMP)

@Id
@Column(name="BROKER_ID")
@GeneratedValue(strategy=GenerationType.AUTO)
private int brokerId;
private String loginId;
private String name;


@OneToMany
@JoinColumn(name="BROKER_ID")
private List<Ownership> owner =null;


public int getBrokerId() {
	return brokerId;
}
public void setBrokerId(int brokerId) {
	this.brokerId = brokerId;
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Ownership> getOwner() {
	return owner;
}

public void setOwner(List<Ownership> owner) {
	this.owner = owner;
}


}
