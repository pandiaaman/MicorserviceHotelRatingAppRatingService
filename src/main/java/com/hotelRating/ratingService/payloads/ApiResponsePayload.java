package com.hotelRating.ratingService.payloads;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponsePayload {

	private String message;
	private boolean success;
	private HttpStatus status;
}
