package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.bean.Employee;
import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.EmployeeException;


public class UnassignedEmployee {

	public static void unassginedEmp() {
		GPMDao gpm = new GPMDaoImpl();
		
			try {
				List<Employee> list = gpm.unassignedEmp();
				System.out.println("Here is the list of unassigned employees");
				list.forEach(i->{
					System.out.println(i);
					System.out.println("----------------------------------------------------------------");
				});
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
		
	}

}
