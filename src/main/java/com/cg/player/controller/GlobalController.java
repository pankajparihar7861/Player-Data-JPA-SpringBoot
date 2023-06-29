package com.cg.player.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.player.exception.GlobalException;

@ControllerAdvice
public class GlobalController {

	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<String> exceptionHandler(Exception exception) {
		
		String errorMessage = exception.getMessage();
		
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}