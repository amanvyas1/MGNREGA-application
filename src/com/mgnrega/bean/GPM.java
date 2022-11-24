package com.mgnrega.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GPM {
	private int gpmId;
	private String gpmName;
	private String phone;
	private String password;
	
	
	public GPM(String gpmName, String phone, String password) {
		super();
		this.gpmName = gpmName;
		this.phone = phone;
		this.password = password;
	}
	
}
