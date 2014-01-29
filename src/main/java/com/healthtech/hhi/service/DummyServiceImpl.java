package com.healthtech.hhi.service;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.Terser;

import com.healthtech.hhi.entity.IncomingMessage;
import com.healthtech.hhi.entity.MessageType;
import com.healthtech.hhi.entity.MuleMessage;

@Service
public class DummyServiceImpl implements DummyService {
	
	private IncomingMessage incomingMessage;
	private PipeParser pipeParser = new PipeParser();
	private Message message;
	
	private static final Logger logger = LoggerFactory.getLogger(DummyServiceImpl.class);
	
	public DummyServiceImpl() {
		super();
	}
	
	
	//	This method transforms an incoming JSON into an object (IncomingMessage class)
	//	and sets STATUS CODE for response:

	@Override
	public int convertJsonToIncomingMessage(String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();	
		try {
			incomingMessage = objectMapper.readValue(jsonString, IncomingMessage.class);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(incomingMessage.toString());
		return incomingMessage.getStatusCode();
	}
	
	
	@Override
	public String getMuleResponse(String putUserIdToService, String putPasswordToService, 
												String putOrganizationIRMSToService, String putMessageDataToService){
		MuleMessage muleMessage = new MuleMessage();
		muleMessage.setUserId(putUserIdToService);
		muleMessage.setPassword(putPasswordToService);
		muleMessage.setOrganizationIRMS(putOrganizationIRMSToService);
		muleMessage.setMessageData(putMessageDataToService);
		
		//	REMOVE:
		logger.info("UserId : " + muleMessage.getUserId());
		logger.info("Password : " + muleMessage.getPassword());
		logger.info("OrganizationIRMS : " + muleMessage.getOrganizationIRMS());
		logger.info("MessageData : " + muleMessage.getMessageData());
		
		if (incomingMessage.getMessageType() == MessageType.TEXT) {							//	returns specific text reply
			logger.info("Case : TEXT");
			return getTextReply(muleMessage);
			
		} else if (incomingMessage.getMessageType() == MessageType.MIRROR) {				//	returns .xml reply
			logger.info("Case : MIRROR");
			return getMirrorReply(muleMessage);
			
		} else if (incomingMessage.getMessageType() == MessageType.EXTENDED) {				//	returns case TEXT + case MIRROR
			logger.info("Case : EXTENDED");
			return (getTextReply(muleMessage) + "\n" + "\n" + getMirrorReply(muleMessage));
		}
		return null;
	}
	
	private String getTextReply(MuleMessage muleMessage){
		StringBuffer stringBuffer= new StringBuffer();
		try {
			message = pipeParser.parse(muleMessage.getMessageData());
			Terser terser = new Terser(message);
			logger.info( terser.get("MSH-4") + "|" + terser.get("MSH-5") );
			logger.info(message.encode());
			stringBuffer.append(terser.get("MSH-4"));
			stringBuffer.append("|");
			stringBuffer.append(terser.get("MSH-5"));
		} catch (HL7Exception e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
	
	private String getMirrorReply(MuleMessage muleMessage){
		String hl7MessageToXML = null;
		try {
			message = pipeParser.parse(muleMessage.getMessageData());
			XMLParser xmlParser = new DefaultXMLParser();
	        hl7MessageToXML = xmlParser.encode(message);
		} catch (HL7Exception e) {
			e.printStackTrace();
		}        
        System.out.println(hl7MessageToXML);	            
        return hl7MessageToXML;
	}

}
