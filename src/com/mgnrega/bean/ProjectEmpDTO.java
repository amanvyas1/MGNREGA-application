package com.mgnrega.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEmpDTO {
	private int projectId;
	private String projectName;
	private int empId;
	private String empName;
	private int wages;
	private int days;	
}
