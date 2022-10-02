package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.bean.GPM;
import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.GPMException;

public class LoginAsGPMUseCase {
	public static void loginAsGPM() {
		GPMDao gmp = new GPMDaoImpl();
		Scanner sc = new Scanner(System.in);
		try {
			try {
				System.out.println("Enter your Id");
				int id = sc.nextInt();
				System.out.println("Enter your password");
				sc.nextLine();
				String pass = sc.nextLine();
				GPM member = gmp.loginAsGPM(id, pass);
				System.out.println("Welcome " + member.getGpmName());
			} catch (GPMException e) {
				System.out.println(e.getMessage());
				System.out.println("please try again");
				loginAsGPM();
			}
		}catch(InputMismatchException ime) {
			System.out.println("Please enter valid ID");
			loginAsGPM();
		}
		
	}
}
