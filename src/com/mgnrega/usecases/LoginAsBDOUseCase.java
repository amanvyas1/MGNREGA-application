package com.mgnrega.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.ProjectException;

public class LoginAsBDOUseCase {

	public static void loginBdo() {
		BDODao bdo = new BDODaoImpl();
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Enter your Id");
			int id = sc.nextInt();
			System.out.println("Enter your password");
			sc.nextLine();
			String pass = sc.nextLine();
			try {
				boolean res = bdo.loginAsBDO(id, pass);
				if(res) {
					System.out.println("Login successful!");
				}else {
					System.out.println("Invalid Credentials!");
					loginBdo();
				}
			} catch (ProjectException e) {
				System.out.println(e.getMessage());
				loginBdo();
			}

		}catch(InputMismatchException ime){
			System.out.println("Please enter valid input");
			loginBdo();
		}
	}

}
