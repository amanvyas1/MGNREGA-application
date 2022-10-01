package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.ProjectException;

public class EmpListbyBDOUseCase {

	public static void main(String[] args) {
		BDODao bdo = new BDODaoImpl();
		try {
			List<ProjectEmpDTO> ped = bdo.projectEmpDetails();
			ped.forEach(p->System.out.println(p));
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
