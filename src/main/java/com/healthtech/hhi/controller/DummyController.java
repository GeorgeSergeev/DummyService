package com.healthtech.hhi.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(DummyController.class);

	@RequestMapping(value = "/params", method = RequestMethod.POST)
	public @ResponseBody ModelAndView convertJsonToIncomingMessage(@RequestBody String jsonString, HttpServletResponse response) {
		response.setStatus( dummyService.convertJsonToIncomingMessage(jsonString) );
		logger.info("StatusCode was set to : " + dummyService.convertJsonToIncomingMessage(jsonString));
		return null;
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody String getMuleResponse(HttpServletRequest request){
		
		String putUserIdToService = (request.getParameter("userId"));
		logger.info(putUserIdToService);
		String putPasswordToService = request.getParameter("password");
		logger.info(putPasswordToService);
		String putMessageDataToService = request.getParameter("messageData");
		logger.info(putMessageDataToService);
		
		return dummyService.getMuleResponse(putUserIdToService, putPasswordToService, putMessageDataToService);
	}
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody String ping() {
		return "pong";
	}
	
}


