package com.mgnrega.bean;

public class Employee {
	private int empId;
	private String eName;
	private int wage;
	private int days;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String eName, int wage, int days) {
		super();
		this.eName = eName;
		this.wage = wage;
		this.days = days;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", eName=" + eName + ", wage=" + wage + ", days=" + days + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
}
