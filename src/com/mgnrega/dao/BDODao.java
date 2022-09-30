package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.bean.Project;
import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;

public interface BDODao {
	
	public String createProject(String name,int budget,int dailyWages);
	
	public List<Project> viewAllProjects() throws ProjectException;
	
	public String createGPM(String name,String phone,String password);
	
	public List<GPMDao> viewAllGPM() throws GPMException;
	
	public String allocateProjectGpm(int gpmId,int projectId) throws ProjectException, GPMException;
	
	public List<Project> unassignedProject() throws ProjectException;
	
	public List<ProjectEmpDTO> projectEmpDetails()throws ProjectException;
	
	
	
	
}
