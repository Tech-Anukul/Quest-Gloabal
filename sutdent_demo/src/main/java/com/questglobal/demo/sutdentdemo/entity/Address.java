package com.questglobal.demo.sutdentdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addId;
	private String house_number;
	private String state;
	private String counrty;

	
	
	public Address() {
		super();
	}
	
	public Address(String hnumber, String state, String counrty) {
		super();
		house_number = hnumber;
		this.state = state;
		this.counrty = counrty;
	}

	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounrty() {
		return counrty;
	}

	public void setCounrty(String counrty) {
		this.counrty = counrty;
	}
}
