package com.oms.model;

public class Employee {
	public int employee_id;
	public String employee_name;
	public String employee_password;
	public String employee_designation;
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getemployee_password() {
		return employee_password;
	}
	public void setemployee_password(String employee_password) {
		this.employee_password = employee_password;
	}
	public String getEmployee_designation() {
		return employee_designation;
	}
	public void setEmployee_designation(String employee_designation) {
		this.employee_designation = employee_designation;
	}
	
}
