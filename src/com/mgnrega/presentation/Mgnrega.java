package com.mgnrega.presentation;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.usecases.AllocateProjectToGPMUseCase;
import com.mgnrega.usecases.AssignProjectToEmployeeUseCase;
import com.mgnrega.usecases.CreateEmployeeUseCase;
import com.mgnrega.usecases.CreateGPMUseCase;
import com.mgnrega.usecases.CreateProjectUseCase;
import com.mgnrega.usecases.EmpListbyBDOUseCase;
import com.mgnrega.usecases.LoginAsBDOUseCase;
import com.mgnrega.usecases.LoginAsGPMUseCase;
import com.mgnrega.usecases.ProjecetEmpGPMUseCase;
import com.mgnrega.usecases.ProjectEmpByPidBDOUseCase;
import com.mgnrega.usecases.UnassignedEmployee;
import com.mgnrega.usecases.UnassignedProjectToGPM;
import com.mgnrega.usecases.ViewAllGPMUseCase;
import com.mgnrega.usecases.ViewAllProjectUseCase;
import com.mgnrega.usecases.ViewEmpListUseCase;





public class Mgnrega {
	public static void main(String[] args) {
		System.out.println("Welcome to MGNREGA Application!");
		Mgnrega.selectOption();
	}
	
	public static void selectOption() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Select any option");
		System.out.println("1. Login as Block Devlopment Officer");
		System.out.println("2. Login as Gram Panchayat Member");
		System.out.println("3. Exit");
		try {
			int choice = sc.nextInt();
			if(choice==1) {
				LoginAsBDOUseCase.loginBdo();
				afterBdoLogin();
			}else if(choice==2) {
				LoginAsGPMUseCase.loginAsGPM();
				afterGPMLogin();
			}else if(choice==3) {
				exitMsg();
				System.exit(0);
			}else {
				System.out.println("Please enter valid option");
				selectOption();
			}
		} catch (InputMismatchException ime) {
			System.out.println("Please enter in number format");
			selectOption();
		}
		
	}
	
	public static void afterBdoLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Create a project.\r\n"
				+ "2. View List Of Project.\r\n"
				+ "3. Create new Gram Panchayat Member(GPM).\r\n"
				+ "4. View all the GPM.\r\n"
				+ "5. Allocate  Project to GPM\r\n"
				+ "6. See List of Employees working on Projects and their wages.\r\n"
				+ "7. See List of Employees working on a project by project ID.\r\n"
				+ "8. Logout.\r\n"
		);
		System.out.println("Please enter your choice");
		try {
			int choice2 = sc.nextInt();
			switch(choice2) {
			case 1: 
				CreateProjectUseCase.createProject();
				afterBdoLogin();
				break;
			case 2:
				ViewAllProjectUseCase.viewProjects();
				afterBdoLogin();
				break;
			case 3:
				CreateGPMUseCase.createGPM();
				afterBdoLogin();
				break;
			case 4:
				ViewAllGPMUseCase.viewGPMs();
				afterBdoLogin();
				break;
			case 5:
				UnassignedProjectToGPM.unassignProject();
				AllocateProjectToGPMUseCase.allocateGPM();
				afterBdoLogin();
				break;
			case 6:
				EmpListbyBDOUseCase.viewEmpList();
				afterBdoLogin();
				break;
			case 7:
				ProjectEmpByPidBDOUseCase.projectbyId();
				afterBdoLogin();
				break;
			case 8:
				selectOption();
				break;
			default:
				System.out.println("Please Enter valid option");
				afterBdoLogin();
				break;
			}	
		}catch(InputMismatchException ime) {
			System.out.println("please enter valid details");
			afterBdoLogin();
		}
	}
	
	public static void afterGPMLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Create Employee.\r\n"
				+ "2. View the Details of Employee.\r\n"
				+ "3. Assign Employee to a Project.\r\n"
				+ "4. View total number of days Employees worked in a project and also their wages.\r\n"
				+ "5. See list of unassigned employees.\r\n"
				+ "6. Logout.\r\n"	
		);
		System.out.println("Please enter your choice");
		try {
			int choice2 = sc.nextInt();
			switch(choice2) {
			case 1:
				CreateEmployeeUseCase.createEmp();
				afterGPMLogin();
				break;
			case 2:
				ViewEmpListUseCase.viewEmp();
				afterGPMLogin();
				break;
			case 3:
				UnassignedEmployee.unassginedEmp();
				AssignProjectToEmployeeUseCase.assignProject();
				afterGPMLogin();
				break;
			case 4:
				ProjecetEmpGPMUseCase.projectEmp();
				afterGPMLogin();
				break;
			case 5:
				UnassignedEmployee.unassginedEmp();
				afterGPMLogin();
				break;
			case 6:
				selectOption();
				break;
			default:
				System.out.println("Please Enter valid option");
				afterGPMLogin();
				break;
			}
		}catch(InputMismatchException ime) {
			System.out.println("please enter valid details");
			afterGPMLogin();
		}
	}
	
	public static void exitMsg() {
		System.out.println("Thank you for using");
	}
			
}