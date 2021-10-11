package com.studentoffer.offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentoffer.offer.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer>{

	@Query(nativeQuery = true, value = "select offer from student_offer where state = upper(?)")
	public String getOfferByState(String state);


}
