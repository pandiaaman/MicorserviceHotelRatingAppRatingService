package com.hotelRating.ratingService.services;

import java.util.List;


import com.hotelRating.ratingService.models.Rating;

public interface RatingService {

	//get all ratings
	public List<Rating> getAllRatings();
	
	//get rating by id
	public Rating getRatingById(String ratingId);
	
	//create a rating
	public Rating addRating(Rating rating);
	
	//all ratings by a user 
	public List<Rating> getAllRatingsByUser(String userId);
	
	//all ratings for a hotel
	public List<Rating> getAllRatingForHotel(String hotelId);
}
