package com.healthtech.hhi.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.healthtech.hhi.service.DummyService;


@Controller
public class DummyController extends HttpServlet {
	
	@Autowired
	private DummyService dummyService;
	
	private static final long serialVersionUID = -1878841261895985520L;

	@RequestMapping(value = "/params", method = RequestMethod.POST)
	public @ResponseBody ModelAndView getJsonAsString(@RequestBody String jsonString, HttpServletResponse response) {
		return dummyService.getJsonAsString(jsonString, response);
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody String getMuleResponse(HttpServletRequest request){
		return dummyService.getMuleResponse(request);
	}
	
}