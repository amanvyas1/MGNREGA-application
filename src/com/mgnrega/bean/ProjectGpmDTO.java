package com.mgnrega.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ProjectGpmDTO {
	private int projectId;
	private String projectName;
	private int gpmId;
	private String gpmName;	
}
