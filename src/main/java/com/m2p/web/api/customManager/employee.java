package com.m2p.web.api.customManager;

public class employee
{
	private String id_employee;
	private String role;
	
	public employee(String id_employee, String role)
	{
		this.id_employee = id_employee;
		this.role = role;
	}	
	
	public String getId_employee() {
		return id_employee;
	}
	public void setId_employee(String id_employee) {
		this.id_employee = id_employee;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
