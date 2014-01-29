package com.healthtech.hhi.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.healthtech.hhi.entity.IncomingMessage;
import com.healthtech.hhi.entity.MessageType;



public class IncomingMessageTest {

	String messageFailStatusCode = "StatusCode from Json test fails";
	String messageFailMessageBody = "MessageBody from Json test fails";
	String messageFailMessageType = "MessageType from Json test fails";

	@Test
	public void testDummy() {		
		IncomingMessageTest test = new IncomingMessageTest();
		String json = "{\n" +
		        "    \"statusCode\": \"200\",\n" +
		        "    \"messageBody\": \"regfuergfoirgefoi\",\n" +
		        "    \"messageType\": \"EXTENDED\"}";		
		IncomingMessage incomingMessage = test.fromJson(json);
		
		int[] expectedStatusCode = new int[]{200};
		int[] actualStatusCode = new int[]{incomingMessage.getStatusCode()};
		assertArrayEquals(messageFailStatusCode, expectedStatusCode, actualStatusCode);
		
		String[] expectedMessageBody = new String[]{"regfuergfoirgefoi"};
		String[] actualMessageBody = new String[]{incomingMessage.getMessageBody()};
		assertArrayEquals(messageFailMessageBody, expectedMessageBody, actualMessageBody);
		
		MessageType[] expectedMessageType = new MessageType[]{MessageType.EXTENDED};
		MessageType[] actualMessageType = new MessageType[]{incomingMessage.getMessageType()};
		assertArrayEquals(messageFailMessageType, expectedMessageType, actualMessageType);
	}

	private IncomingMessage fromJson(String json){
		IncomingMessage incomingMessage = new IncomingMessage();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			incomingMessage = objectMapper.readValue(json, IncomingMessage.class);
			System.out.println(incomingMessage.getMessageBody());
			System.out.println(incomingMessage.getMessageType());
			System.out.println(incomingMessage.getStatusCode());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Java Object created from JSON String.");
		System.out.println("JSON String : " + json);
		System.out.println("Java Object : " + incomingMessage);
		return incomingMessage;
	}

}
