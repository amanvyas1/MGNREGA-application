package com.mgnrega.bean;

public class ProjectEmpDTO {
	private int projectId;
	private String projectName;
	private int empId;
	private String empName;
	private int wages;
	private int days;
	
	public ProjectEmpDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProjectEmpDTO(int projectId, String projectName, int empId, String empName, int wages,int days) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.empId = empId;
		this.empName = empName;
		this.wages = wages;
		this.days  = days;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "[projectId=" + projectId + " | projectName=" + projectName + " | empId=" + empId
				+ " | empName=" + empName + " | wages=" + wages + " | days=" + days + "]";
	}

	
	
}
