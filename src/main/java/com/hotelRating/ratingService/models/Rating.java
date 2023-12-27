package com.hotelRating.ratingService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("user_ratings") //just like we use @Entity in jpa, we use @Document in mongodb
public class Rating { //directly picked from User service models package

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String comment;
}