package com.studentoffer.offer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.studentoffer.offer.service.OfferService;

@RestController
public class OfferController {
	
@Autowired
OfferService offerservice;
	
	@GetMapping("/offer/{state}")
	public String getOfferByState(@PathVariable String state){
		return offerservice.getOfferByState(state);
	}
}
