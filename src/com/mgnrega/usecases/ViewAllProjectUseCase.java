package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.bean.Project;
import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.ProjectException;

public class ViewAllProjectUseCase {

	public static void main(String[] args) {
		BDODao bdo = new BDODaoImpl();
		
		try {
			List<Project> l = bdo.viewAllProjects();
			l.forEach(p->{
				System.out.println("ProjectId =" + p.getProjectId()+ " Project Name= " + p.getProjectName()+ " Daily wages " + p.getDailyWages() +" Budget " + p.getBudget());
				System.out.println("=============================================================================");
			});
		} catch (ProjectException e) {
			e.printStackTrace();
		}
		
		

	}

}
