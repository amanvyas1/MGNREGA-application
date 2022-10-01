package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		GPM gpm5 = null;
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
				gpm5 = new GPM(gpmname,phone,gpmpass);
				gpm5.setGpmId(gpmid);	
			}else {
				throw new GPMException("Invalid Id or Password");
			}
		}catch(SQLException sqe) {
			throw new GPMException(sqe.getMessage());
		}
		return gpm5;
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
		List<Employee> list = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("eid");
				String eName = rs.getString("ename");
				int daysWorked = rs.getInt("days");
				Employee e = new Employee();
				e.setEmpId(empId);
				e.seteName(eName);
				e.setDays(daysWorked);
				list.add(e);
			}
			} catch (SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
			if(list.size()==0) {
				throw new EmployeeException("No employee found");
			}
			return list;
	}

	@Override
	public List<Employee> unassignedEmp() throws EmployeeException {
		List<Employee> list = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from employee where pid is null");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("eid");
				String eName = rs.getString("ename");
				int daysWorked = rs.getInt("days");
				Employee e = new Employee();
				e.setEmpId(empId);
				e.seteName(eName);
				e.setDays(daysWorked);
				list.add(e);
			}
			} catch (SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
			if(list.size()==0) {
				throw new EmployeeException("No employee is left unassigned");
			}
			return list;
	}

	@Override
	public String assignEmp(int empId, int projectId,int days) throws ProjectException, EmployeeException {
		String message = "Project assigned to employee successfully";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from projects where pid=?");
			ps.setInt(1, projectId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from employee where eid=?");
				ps2.setInt(1, empId);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					PreparedStatement ps3 = conn.prepareStatement("update employee set pid=?,days=? where eid=?");
					ps3.setInt(1, projectId);
					ps3.setInt(2, days);
					ps3.setInt(3, empId);
					int res = ps3.executeUpdate();
					if(res>0) {
						message = "Project assigned to employee successfully";
					}else {
						throw new ProjectException("Technical Error");
					}
				}else {
					throw new EmployeeException("Invalid Employee Id");
				}
			}else {
				throw new ProjectException("Invalid project Id");
			}
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<ProjectEmpDTO> projectEmpDetails(int gpmid) throws ProjectException, EmployeeException {
		List<ProjectEmpDTO> pEmpList = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select p.pid,p.pname,e.eid,e.ename,e.days,e.days*p.dwage twage,g.gpmname from employee e inner join projects p inner join gpm g on e.pid=p.pid and g.pid=p.pid where g.gpmid=?");
			ps.setInt(1, gpmid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int projectId = rs.getInt("pid");
				String projectName = rs.getString("pname");
				int empId = rs.getInt("eid");
				String empName = rs.getString("ename");
				int days = rs.getInt("days");
				int wage = rs.getInt("twage");
				ProjectEmpDTO ped = new ProjectEmpDTO(projectId,projectName,empId,empName,wage,days);
				pEmpList.add(ped);
			}
		}catch(SQLException e) {
			throw new ProjectException("Technical Error");
		}
		if(pEmpList.size()==0) {
			throw new ProjectException("No employee is working on projects");
		}
		return pEmpList;
	}

}
