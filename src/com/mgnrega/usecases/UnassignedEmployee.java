package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.bean.Employee;
import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.EmployeeException;


public class UnassignedEmployee {

	public static void main(String[] args) {
		GPMDao gpm = new GPMDaoImpl();
		
			try {
				List<Employee> list = gpm.unassignedEmp();
				list.forEach(e->System.out.println(e));
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
		
	}

}
