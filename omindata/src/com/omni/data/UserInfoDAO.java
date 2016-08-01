package com.omni.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.omni.data.vo.UserInfoVO;

public class UserInfoDAO {
	
	private Connection conn;
	
	public UserInfoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public UserInfoVO findUserById(int userId) {
		UserInfoVO uservo = null;
		try {
			
			String sql = "SELECT * FROM signin.comp_info where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				uservo = new UserInfoVO();
				uservo.setId(rs.getInt(1));
				uservo.setFirstName(rs.getString(2));
				uservo.setLastName(rs.getString(3));
				uservo.setGender(rs.getString(4));
				uservo.setEmail(rs.getString(5));
				uservo.setAddress(rs.getString(6));
				uservo.setCity(rs.getString(7));
				uservo.setState(rs.getString(8));
				uservo.setZipCode(rs.getInt(9));
				uservo.setHomePhone(rs.getInt(10));
				uservo.setUserName(rs.getString(11));
				uservo.setPassowrd(rs.getString(12));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return uservo;
	}
	
	public boolean isUserExists(String userId, String firstName, String lastName) {
		boolean isExists = false;
		try {
			String sql = "SELECT * FROM signin.comp_info where username = ? and first_name = ? and  last_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				isExists = true;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return isExists;
	}

	public String addUser(UserInfoVO user) {
		String error = null;	
		try {
        	String sql= "INSERT INTO comp_info (first_name,last_name,gender,email,address,city,state,zip_code,home_phone,username,passowrd) "
        			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1, user.getFirstName());
        	ps.setString(2, user.getLastName());
        	ps.setString(3, user.getGender());
        	ps.setString(4, user.getEmail());
        	ps.setString(5, user.getAddress());
        	ps.setString(6, user.getCity());
        	ps.setString(7, user.getState());
        	ps.setInt(8, user.getZipCode() );
        	ps.setInt(9, user.getHomePhone());
        	ps.setString(10, user.getUserName());
        	ps.setString(11, user.getPassowrd());
        	int rcode = ps.executeUpdate();
        	error = ""+rcode;
		} catch (Exception ex){
			error = ex.getMessage();
			ex.printStackTrace();
		}		
		return error;
	}
	
	public String updateUser(UserInfoVO user) {
		String error =null;
		try {
			String sql="UPDATE comp_info "
					+ "set gender=?,email=?,address=?,city=?,state=?,zip_code=?,home_phone=?,passowrd=?"
					+ "where first_name=? and last_name=? and username = ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getGender());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getCity());
			ps.setString(5, user.getState());
			ps.setInt(6, user.getZipCode());
			ps.setInt(7, user.getHomePhone());
			//ps.setString(8, user.getUserName());
			ps.setString(8, user.getPassowrd());
			ps.setString(9, user.getFirstName());
			ps.setString(10, user.getLastName());
			ps.setString(11, user.getUserName());
			int rcode = ps.executeUpdate();
			error=""+rcode;
			
		} catch(Exception ex){
			error = ex.getMessage();
			ex.printStackTrace();
		}
		return error;		
	}
}
