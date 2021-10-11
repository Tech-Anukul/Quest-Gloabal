package com.studentoffer.offer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentoffer.offer.entity.Offer;
import com.studentoffer.offer.repository.OfferRepository;

@Service
public class OfferService {
	
@Autowired
OfferRepository offerRepository;

public String getOfferByState(String state){
	return offerRepository.getOfferByState(state);
}
	
public List<Offer> saveAll(List<Offer>offers){
	return offerRepository.saveAll(offers);
}
}
