package com.mgnrega.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	private int empId;
	private String empName;
	private int days;
	

	public Employee(String empName) {
		super();
		this.empName = empName;
	}
	
}
