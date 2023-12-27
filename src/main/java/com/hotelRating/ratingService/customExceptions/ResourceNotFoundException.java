package com.hotelRating.ratingService.customExceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
		System.out.println("requested resource can not be found in the server exception");
	}
}
