package com.netease.assignment.web.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String defualtExceptionHandler() {

		return "error";
	}
}
