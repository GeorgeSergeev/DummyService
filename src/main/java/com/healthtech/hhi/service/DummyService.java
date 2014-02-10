package com.healthtech.hhi.service;


public interface DummyService {
	
	public int convertJsonToIncomingMessage(String jsonString);
	
	public String getMuleResponse(String putUserIdToService, String putPasswordToService, String putMessageDataToService);

}