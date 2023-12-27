package com.hotelRating.ratingService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelRating.ratingService.models.Rating;
import com.hotelRating.ratingService.servicesImpl.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingService;
	
	//get all ratings
	@GetMapping(value="/")
	public ResponseEntity<List<Rating>> getAllRatings(){
		try {
			List<Rating> ratings = this.ratingService.getAllRatings();
			if(ratings!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(ratings);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	//get single rating by id
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable("ratingId") String ratingId){
		try {
			Rating rating = this.ratingService.getRatingById(ratingId);
			if(rating!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(rating);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	//add a rating
	@PostMapping("/")
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
		try {
			Rating ratingadded = this.ratingService.addRating(rating);
			if(ratingadded!=null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(rating);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	//get all ratings by a user
	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable("userId") String userId){
		try {
			List<Rating> ratingsByUser = this.ratingService.getAllRatingsByUser(userId);
			if(ratingsByUser!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(ratingsByUser);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	//get all ratings for a hotel
	@GetMapping("/forhotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsForHotel(@PathVariable("hotelId") String hotelId){
		try {
			List<Rating> ratingsForHotel = this.ratingService.getAllRatingForHotel(hotelId);
			if(ratingsForHotel!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(ratingsForHotel);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
