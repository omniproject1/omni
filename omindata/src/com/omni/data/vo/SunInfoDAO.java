package com.omni.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.omni.data.vo.SunInfoVO;

public class UserInfoDAO {
	
	private Connection conn;
	
	public SunInfoDAO(Connection conn) {
		this.conn = conn;
	}

	public String addSub(SunInfoVO user) {
		String error = null;	
		try {
        	String sql= "INSERT INTO sub_reg (username,passowrd,semester,branch,num_subjects,sub1,sub2,sub3,sub4,sub5) "
        			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1, user.getUsertName());
        	ps.setString(2, user.getPassowrd());
        	ps.setString(3, user.getSemester());
        	ps.setString(4, user.getBranch());
        	ps.setString(5, user.getNumSubjects());
        	ps.setString(6, user.getSub1());
        	ps.setString(7, user.getSub2());
        	ps.setString(8, user.getSub3() );
        	ps.setString(9, user.getSub4());
        	ps.setString(10, user.getSub5());
        	int rcode = ps.executeUpdate();
        	error = ""+rcode;
		} catch (Exception ex){
			error = ex.getMessage();
			ex.printStackTrace();
		}		
		return error;
	}



}