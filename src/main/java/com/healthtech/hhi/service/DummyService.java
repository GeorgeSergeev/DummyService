package com.healthtech.hhi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface DummyService {
	
	public @ResponseBody ModelAndView getJsonAsString(String jsonString, HttpServletResponse response);
	
	public @ResponseBody String getMuleResponse(HttpServletRequest request);

}