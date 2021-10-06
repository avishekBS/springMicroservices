package com.codeolate.employee.api.exception.handler;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codeolate.employee.api.entity.ResponseErrorMessage;
import com.codeolate.employee.api.exception.EmployeeNotFoundException;

@ControllerAdvice  //for all controllers else mention the controllers
public class EmployeeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ResponseErrorMessage> sendEmployeeNotFoundResponse(Exception ex, WebRequest request) {
		ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<>(responseErrorMessage, HttpStatus.NOT_FOUND);
	}
	/*
	@ExceptionHandler(EmployeeNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
    */
}
