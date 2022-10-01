package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;

public class CreateEmployeeUseCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GPMDao gpm = new GPMDaoImpl();
		System.out.println("Enter Name");
		String name = sc.nextLine();
		String message = gpm.createEmployee(name);
		System.out.println(message);
		
	}
}
