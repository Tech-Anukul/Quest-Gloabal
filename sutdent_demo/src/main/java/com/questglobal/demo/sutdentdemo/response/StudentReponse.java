package com.questglobal.demo.sutdentdemo.response;

import java.util.ArrayList;
import java.util.Collection;

public class StudentReponse {

	private Integer studId;
	private String studClass;
	private String name;
	private String email;
	private Collection<AddressResponse> addresses = new ArrayList<AddressResponse>();
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getStudClass() {
		return studClass;
	}
	public void setStudClass(String studClass) {
		this.studClass = studClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<AddressResponse> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<AddressResponse> addresses) {
		this.addresses = addresses;
	}
	
	
}
