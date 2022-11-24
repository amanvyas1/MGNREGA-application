package com.mgnrega.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	private int projectId;
	private String projectName;
	private int budget;
	private int dailyWages;
	
	
	
	public Project(String projectName, int budget,int dailyWages) {
		super();
		this.projectName = projectName;
		this.budget = budget;
		this.dailyWages = dailyWages;
	}
}
