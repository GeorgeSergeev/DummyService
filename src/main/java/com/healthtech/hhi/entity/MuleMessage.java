package com.healthtech.hhi.entity;

import java.io.Serializable;

public class MuleMessage implements Serializable{
	
	private String userId;
	private String password;
	private String organizationIRMS;
	private String messageData;
	
	private static final long serialVersionUID = -3006285502800893320L;
	
	public MuleMessage() {
		super();
	}
	
	public MuleMessage(String userId, String password, String organizationIRMS, String messageData) {
		super();
		this.userId = userId;
		this.password = password;
		this.organizationIRMS = organizationIRMS;
		this.messageData = messageData;
	}	

	@Override
	public String toString() {
		return "MuleMessage [userId=" + userId + ", password=" + password
				+ ", organizationIRMS=" + organizationIRMS + ", messageData="
				+ messageData + "]";
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizationIRMS() {
		return organizationIRMS;
	}
	
	public void setOrganizationIRMS(String organizationIRMS) {
		this.organizationIRMS = organizationIRMS;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}	
	
}
