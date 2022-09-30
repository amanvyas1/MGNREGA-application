package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.bean.GPM;
import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.GPMException;

public class ViewAllGPMUseCase {
	public static void main(String[] args) {
		BDODao bdo = new BDODaoImpl();
		try {
			List<GPM> l = bdo.viewAllGPM();
			l.forEach(gpm->{
				System.out.println("Member Id=" + gpm.getGpmId() + " Member Name=" + gpm.getGpmName() + " phone number=" + gpm.getPhone() + " password=" + gpm.getPassword());
			});
		} catch (GPMException e) {
			e.printStackTrace();
		}
	}
}
 