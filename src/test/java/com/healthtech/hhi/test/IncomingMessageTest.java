package com.healthtech.hhi.test;

/*import static org.junit.Assert.*;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.healthtech.hhi.entity.IncomingMessage;*/



public class IncomingMessageTest {
	/*
	String messageFailStatusCode = "StatusCode from Json test fails";
	String messageFailMessageBody = "MessageBody from Json test fails";
	String messageFailMessageType = "MessageType from Json test fails";

	@Test
	public void testDummy() {
		
		IncomingMessageTest test = new IncomingMessageTest();
		
		String json = "{\n" +
		        "    \"statusCode\": \"200\",\n" +
		        "    \"messageBody\": \"Oh-la-la\",\n" +
		        "    \"messageType\": 123}";
		
		IncomingMessage incomingMessage = null;
		
		try {
			incomingMessage = test.fromJson(json);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[] expectedStatusCode = new int[]{200};
		int[] actualStatusCode = new int[]{incomingMessage.getStatusCode()};
		assertArrayEquals(messageFailStatusCode, expectedStatusCode, actualStatusCode);
		
		String[] expectedMessageBody = new String[]{"Oh-la-la"};
		String[] actualMessageBody = new String[]{incomingMessage.getMessageBody()};
		assertArrayEquals(messageFailMessageBody, expectedMessageBody, actualMessageBody);
		
		/*int[] expectedMessageType = new int[]{123};	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		MessageType[] actualMessageType = new MessageType[]{incomingMessage.getMessageType()};
		assertArrayEquals(messageFailMessageType, expectedMessageType, actualMessageType);*/
	/*}

	private IncomingMessage fromJson(String json) throws JsonParseException, JsonMappingException, IOException{
		IncomingMessage incomingMessage = new ObjectMapper().readValue(json, IncomingMessage.class);
		System.out.println("Java Object created from JSON String.");
		System.out.println("JSON String : " + json);
		System.out.println("Java Object : " + incomingMessage);
		return incomingMessage;
	}*/

}
