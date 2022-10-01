package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.bean.GPM;
import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.GPMException;

public class LoginAsGPMUseCase {
	public static void main(String[] args) {
		GPMDao gmp = new GPMDaoImpl();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter ID");
			GPM member = gmp.loginAsGPM(4, "12229");
			System.out.println(member.getGpmId() + " " + member.getGpmName());
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
