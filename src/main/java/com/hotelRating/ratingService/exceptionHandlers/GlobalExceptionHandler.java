package com.hotelRating.ratingService.exceptionHandlers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelRating.ratingService.customExceptions.ResourceNotFoundException;
import com.hotelRating.ratingService.payloads.ApiResponsePayload;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponsePayload> resourceNotFoundExHandler(ResourceNotFoundException ex){
		ApiResponsePayload response = new ApiResponsePayload();
		
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setSuccess(false);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
