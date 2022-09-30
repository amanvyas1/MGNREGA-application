package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.bean.GPM;
import com.mgnrega.bean.Project;
import com.mgnrega.bean.ProjectEmpDTO;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.utility.DBUtil;

public class BDODaoImpl implements BDODao{

	@Override
	public String createProject(String name, int budget, int dailyWages) {
		String message = "Project could not be created";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into projects(pname,budget,dwage) values(?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, budget);
			ps.setInt(3, dailyWages);
			
			int res = ps.executeUpdate();
			if(res>0) {
				message = "Project created successfully";
			}
		}catch(SQLException se) {
			message = se.getMessage();
		}
		return message;
	}

	@Override
	public List<Project> viewAllProjects() throws ProjectException {
		List<Project> projectList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from projects");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int projectId = rs.getInt("pid");
				String projectName = rs.getString("pname");
				int budget = rs.getInt("budget");
				int dailyWage = rs.getInt("dwage");
				
				Project p = new Project(projectName,budget,dailyWage);
				p.setProjectId(projectId);
				
				projectList.add(p);
			}
		}catch(SQLException sqe) {
			throw new ProjectException(sqe.getMessage());
		}
		
		if(projectList.size()==0) {
			throw new ProjectException("No project found");
		}
		return projectList;
	}

	@Override
	public String createGPM(String name, String phone, String password) {
		String message = "Gram Panchayat member could not be created";
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into gpm(gpmname,phone,password) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, password);
			int res = ps.executeUpdate();
			if(res>0) {
				message = "Gram panchayat member successfully added";
			}
		}catch(SQLException sqe) {
			message = sqe.getMessage();
		}
		return message;
	}

	@Override
	public List<GPM> viewAllGPM() throws GPMException {
		List<GPM> l = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from gpm");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int gpmId = rs.getInt("gpmid");
				String gpmName = rs.getString("gpmname");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				GPM gpm = new GPM(gpmName,phone,password);
				gpm.setGpmId(gpmId);
				l.add(gpm);
			}
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		if(l.size()==0) {
			throw new GPMException("No Gram panchayat member found");
		}
		return l;
	}

	@Override
	public String allocateProjectGpm(int gpmId, int projectId) throws ProjectException, GPMException {
		
		String message = "Project could not be allocated";
		
		try(Connection conn = DBUtil.provideConnection()){
		   PreparedStatement ps = conn.prepareStatement("select * from projects where pid=?");
		   ps.setInt(1, projectId);
		   ResultSet rs= ps.executeQuery();
		   if(rs.next()) {
			   PreparedStatement ps2 = conn.prepareStatement("select * from gpm where gpmid=?");
			   ps2.setInt(1, gpmId);
			   ResultSet rs2 = ps2.executeQuery();
			   if(rs2.next()) {
				   PreparedStatement ps3 = conn.prepareStatement("update gpm set pid=? where gpmid=?");
				   ps3.setInt(1, projectId);
				   ps3.setInt(2, gpmId);
				   int res = ps3.executeUpdate();
				   if(res>0) {
					   message = "Project allocated to gram panchayat member successfully";
				   }else {
					   throw new ProjectException("Technical Error");
				   }
			   }else {
				   throw new GPMException("Invalid GPM Id");
			   }
		   }else {
			   throw new ProjectException("Invalid Project Id");
		   }
		}catch(SQLException sqe) {
			throw new ProjectException(sqe.getMessage());
		}
		return message;
	}

	@Override
	public List<Project> unassignedProject() throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectEmpDTO> projectEmpDetails() throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

}
