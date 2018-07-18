package com.m2p.web.api.customManager;

public class EventCreateManager {
	private int id_task;
	private String description;
	private String id_employee;
	private int id_role_assigned;
	private String id_employee_assigned;
	private int id_machine;
	private int id_line;
	
	public int getId_task() {
		return id_task;
	}
	public void setId_task(int id_task) {
		this.id_task = id_task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId_employee() {
		return id_employee;
	}
	public void setId_employee(String id_employee) {
		this.id_employee = id_employee;
	}
	public int getId_role_assigned() {
		return id_role_assigned;
	}
	public void setId_role_assigned(int id_role_assigned) {
		this.id_role_assigned = id_role_assigned;
	}
	public String getId_employee_assigned() {
		return id_employee_assigned;
	}
	public void setId_employee_assigned(String id_employee_assigned) {
		this.id_employee_assigned = id_employee_assigned;
	}
	public int getId_machine() {
		return id_machine;
	}
	public void setId_machine(int id_machine) {
		this.id_machine = id_machine;
	}
	public int getId_line() {
		return id_line;
	}
	public void setId_line(int id_line) {
		this.id_line = id_line;
	}
}