package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.bean.Employee;
import com.mgnrega.bean.GPM;
import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;

public interface GPMDao {
	
	public GPM loginAsGPM(int id,String password) throws GPMException;
	
	public String createEmployee(String name);
	
	public List<Employee> viewEmpList() throws EmployeeException;
	
	public List<Employee> unassignedEmp() throws EmployeeException;
	
	public String assignEmp(int empId, int projectId,int days) throws ProjectException,EmployeeException;
	
	public List<ProjectEmpDTO> projectEmpDetails(int gpmid)throws ProjectException,EmployeeException;
	
	
	
}
