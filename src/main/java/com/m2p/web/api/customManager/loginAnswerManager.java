package com.m2p.web.api.customManager;

public class loginAnswerManager
{
	private int status;
	private employee body;
	
	public loginAnswerManager(int status, employee body)
	{
		this.status = status;
		this.body = body;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public employee getBody() {
		return body;
	}
	public void setBody(employee body) {
		this.body = body;
	}
}
