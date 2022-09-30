package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mgnrega.bean.Employee;
import com.mgnrega.bean.GPM;
import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{

	@Override
	public GPM loginAsGPM(int id, String password) throws GPMException {
		GPM gpm = null;
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps =  conn.prepareStatement("select * from gpm where gpmid = ? and password = ?");
			ps.setInt(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int gpmid = rs.getInt("gpmid");
				String gpmname = rs.getString("gpmname");
				String phone = rs.getString("phone");
				String gpmpass = rs.getString("password");
				GPM gpm1 = new GPM(gpmname,phone,gpmpass);
				gpm1.setGpmId(gpmid);	
			}else {
				throw new GPMException("Invalid Id or Password");
			}
		}catch(SQLException sqe) {
			throw new GPMException(sqe.getMessage());
		}
		return gpm;
	}

	@Override
	public String createEmployee(String name) {
		String message = "Employee could not be created";
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into employee(ename) values(?)");
			ps.setString(1, name);
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Employee created successfully!";
			}
		}catch(SQLException sqe) {
			message = sqe.getMessage();
		}
		return message;
	}

	@Override
	public List<Employee> viewEmpList() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> unassignedEmp() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmp(int empId, int projectId) throws ProjectException, EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectEmpDTO> projectEmpDetails() throws ProjectException, EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
