package com.hotelRating.ratingService.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotelRating.ratingService.models.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {

	//custom finder methods : MAGIC
	public List<Rating> findByUserId(String userId);
	
	public List<Rating> findByHotelId(String hotelId);
}
