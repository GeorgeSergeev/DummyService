package com.healthtech.hhi.entity;

import java.io.Serializable;



public class IncomingMessage implements Serializable{

	private static final long serialVersionUID = 7532995546058677684L;
	
	int statusCode;
	String messageBody;
	MessageType messageType;
	
	public IncomingMessage() {
		super();
	}
	
	public IncomingMessage(int statusCode, String messageBody, MessageType messageType) {
		super();
		this.statusCode = statusCode;
		this.messageBody = messageBody;
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		return "IncomingMessage [statusCode=" + statusCode + ", messageBody="
				+ messageBody + ", messageType=" + messageType + "]";
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int i) {
		this.statusCode = i;
	}
	
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

}
