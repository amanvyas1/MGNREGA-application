package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.ProjectException;

public class ProjectEmpByPidBDOUseCase {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		try {
			System.out.println("Enter project Id to get Employee List with project");
			int pid = sc.nextInt();
			BDODao bdo = new BDODaoImpl();
			try {
				List<ProjectEmpDTO> ped = bdo.projectEmpDetailsByPID(pid);
				ped.forEach(p->System.out.println(p));
			} catch (ProjectException e) {
				System.out.println(e.getMessage());
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter only in number");
		}

	}

}
