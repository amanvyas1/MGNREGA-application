package com.mgnrega.bean;

public class Project {
	private int projectId;
	private String projectName;
	private int budget;
	private int dailyWages;
	
	public Project() {
		
	}

	
	
	public Project(String projectName, int budget,int dailyWages) {
		super();
		this.projectName = projectName;
		this.budget = budget;
		this.dailyWages = dailyWages;
	}



	public int getDailyWages() {
		return dailyWages;
	}



	public void setDailyWages(int dailyWages) {
		this.dailyWages = dailyWages;
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

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}



	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", budget=" + budget
				+ ", dailyWages=" + dailyWages + "]";
	}

	
	
	
	
}
