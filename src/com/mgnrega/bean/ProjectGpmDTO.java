package com.mgnrega.bean;

public class ProjectGpmDTO {
	private int projectId;
	private String projectName;
	private int gpmId;
	private String gpmName;
	
	
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
	public int getGpmId() {
		return gpmId;
	}
	public void setGpmId(int gpmId) {
		this.gpmId = gpmId;
	}
	public String getGpmName() {
		return gpmName;
	}
	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}
	public ProjectGpmDTO(int projectId, String projectName, int gpmId, String gpmName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.gpmId = gpmId;
		this.gpmName = gpmName;
	}
	
	public ProjectGpmDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProjectGpmDTO [projectId=" + projectId + ", projectName=" + projectName + ", gpmId=" + gpmId
				+ ", gpmName=" + gpmName + "]";
	}
	
	
}
