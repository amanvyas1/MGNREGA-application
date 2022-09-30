package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;

public class AllocateProjectToGPMUseCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BDODao bdo = new BDODaoImpl();
		System.out.println("Enter Project Id");
		int pid = sc.nextInt();
		System.out.println("Enter gram panchayat member Id");
		int gid = sc.nextInt();
		try {
			String msg = bdo.allocateProjectGpm(gid,pid);
			System.out.println(msg);
		} catch (ProjectException | GPMException e) {
			e.printStackTrace();
		}
	}
	
}
