package com.hotelRating.ratingService.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelRating.ratingService.customExceptions.ResourceNotFoundException;
import com.hotelRating.ratingService.models.Rating;
import com.hotelRating.ratingService.repositories.RatingRepository;
import com.hotelRating.ratingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public List<Rating> getAllRatings() {
		List<Rating> allRatings = this.ratingRepo.findAll();
		return allRatings;
	}

	@Override
	public Rating getRatingById(String ratingId) {

		Rating rating = this.ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("requested rating not found"));
		return rating;
	}

	@Override
	public Rating addRating(Rating rating) {
		Rating ratingadded = this.ratingRepo.save(rating);
		return ratingadded;
	}

	@Override
	public List<Rating> getAllRatingsByUser(String userId) {
		List<Rating> ratingsByUser = this.ratingRepo.findByUserId(userId);
		return ratingsByUser;
	}

	@Override
	public List<Rating> getAllRatingForHotel(String hotelId) {
		List<Rating> ratingForHotel = this.ratingRepo.findByHotelId(hotelId);
		return ratingForHotel;
	}

	
}
