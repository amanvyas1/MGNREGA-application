package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.bean.GPM;
import com.mgnrega.bean.Project;
import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;

public class UnassignedProjectToGPM {

	public static void main(String[] args) {
		BDODao bdo = new BDODaoImpl();
		try {
			System.out.println("Unassigned Projects");
			List<Project> list = bdo.unassignedProject();
			list.forEach(p->System.out.println(p));
			System.out.println("Unassigned GPMs");
			List<GPM> gpmlist = bdo.unassignedGPM();
			gpmlist.forEach(g->System.out.println(g));
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(GPMException e) {
			e.printStackTrace();
		}
	}

}
