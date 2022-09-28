package com.mgnrega.bean;

public class Project {
	private int projectId;
	private String projectName;
	private int budget;
	
	public Project() {
		
	}

	
	
	public Project(String projectName, int budget) {
		super();
		this.projectName = projectName;
		this.budget = budget;
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
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", budget=" + budget + "]";
	}
	
	
	
}
