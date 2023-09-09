package com.jsp.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.user.util.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{
     @ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(UserIdNOtFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Id not found for User");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
