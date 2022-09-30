package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.BDODaoImpl;

public class CreateGPMUseCase {

	public static void main(String[] args) {
		BDODaoImpl bdo = new BDODaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter member name");
		String name = sc.nextLine();
		System.out.println("Enter member's phone number");
		String phone = sc.nextLine();
		System.out.println("Enter memeber's password (max lenght=10)");
		String pass= sc.nextLine();
		String msg = bdo.createGPM(name, phone, pass);
		System.out.println(msg);

	}

}
