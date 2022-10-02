package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.ProjectException;

public class AssignProjectToEmployeeUseCase {

	public static void assignProject() {
		GPMDao gpm = new GPMDaoImpl();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter project Id");
			int pid = sc.nextInt();
			System.out.println("Enter employee Id");
			int eid = sc.nextInt();
			System.out.println("Enter number of days for employee will work");
			int days = sc.nextInt();
			try {
				String message = gpm.assignEmp(eid, pid, days);
				System.out.println(message);
			} catch (ProjectException | EmployeeException e) {
				System.out.println(e.getMessage());
				assignProject();
			}
		} catch (InputMismatchException ime) {
			System.out.println("Please Enter valid inputs");
			assignProject();
		}
				

	}

}
