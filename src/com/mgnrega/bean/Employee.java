package com.mgnrega.bean;

public class Employee {
	private int empId;
	private String empName;
	private int days;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName) {
		super();
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + " | eName=" + empName + " | days=" + days + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String geteName() {
		return empName;
	}

	public void seteName(String eName) {
		this.empName = eName;
	}


	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
}
