package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;

public class CreateProjectUseCase {
	public static void createProject() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter project name");
			String name = sc.nextLine();
			System.out.println("Enter budget of project " + name);
			int budget = sc.nextInt();
			System.out.println("Enter daily wages for employees");
			int dwages = sc.nextInt();
			BDODao bdo = new BDODaoImpl();
			String msg = bdo.createProject(name, budget, dwages);
			System.out.println(msg);
		}catch(InputMismatchException ime) {
			System.out.println("Please enter proper values");
			CreateProjectUseCase.createProject();
		}		
	}
}
