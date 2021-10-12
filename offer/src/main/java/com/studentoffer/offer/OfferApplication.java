package com.studentoffer.offer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentoffer.offer.entity.Offer;
import com.studentoffer.offer.service.OfferService;

@SpringBootApplication
public class OfferApplication implements CommandLineRunner {
@Autowired
OfferService offerService;
	
	public static void main(String[] args) {
		SpringApplication.run(OfferApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Offer> offers = new ArrayList<>();
		Offer offer = new Offer("MP", "10%");
		offers.add(offer);
		Offer offer1 = new Offer("CG", "20%");
		offers.add(offer1);
		Offer offer2 = new Offer("UP", "50%");
		offers.add(offer2);
		offerService.saveAll(offers);
	}
	
	

}
