package com.studentoffer.offer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="student_offer")
public class Offer {

	@GeneratedValue
	@Id
	private Integer id;
	private String state;
	private String offer;

	public Offer(String state, String offer) {
		super();
		this.state = state;
		this.offer = offer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

}
