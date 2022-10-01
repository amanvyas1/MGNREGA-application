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

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		
		try {
			System.out.println("Enter gram panchyat member Id to get Employee List with project");
			int gpmid = sc.nextInt();
			GPMDao bdo = new GPMDaoImpl();
			
			try {
				List<ProjectEmpDTO> ped = bdo.projectEmpDetails(gpmid);
				ped.forEach(p->System.out.println(p));
			} catch (ProjectException | EmployeeException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Please enter only in number");
		}

	}

}
