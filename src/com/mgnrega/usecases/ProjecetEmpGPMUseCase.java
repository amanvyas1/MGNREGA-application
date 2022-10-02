package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.ProjectException;

public class ProjecetEmpGPMUseCase {

	public static void projectEmp() {
        Scanner sc= new Scanner(System.in);
		
		try {
			System.out.println("Enter gram panchyat member Id to get Employee List with project");
			int gpmid = sc.nextInt();
			GPMDao gpm = new GPMDaoImpl();
			
			try {
				List<ProjectEmpDTO> ped = gpm.projectEmpDetails(gpmid);
				ped.forEach(p->{
					System.out.println(p);
					System.out.println("--------------------------------------------------------------------------------------------");
				});
			} catch (ProjectException | EmployeeException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Please enter only in number");
			projectEmp();
		}

	}

}
