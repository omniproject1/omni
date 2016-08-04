package com.omni.data;

import java.sql.Connection;

import com.omni.data.vo.UserInfoVO;

public class SigninDatabaseAdapter {
	public void searchForData() {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			UserInfoDAO dao = new UserInfoDAO(conn);
			UserInfoVO vo = dao.findUserById(2);
			System.out.println("id: "+vo.getId());
			System.out.println("First Name: "+vo.getFirstName());
			System.out.println("Last Name: "+vo.getLastName());
			System.out.println("Gender: "+vo.getGender());
			System.out.println("Email: "+vo.getEmail());
			System.out.println("Address: "+vo.getAddress());
			System.out.println("City: "+vo.getCity());
			System.out.println("State: "+vo.getState());
			System.out.println("Zip Code: "+vo.getZipCode());
			System.out.println("User Name: "+vo.getUserName());
			System.out.println("Password: "+vo.getPassowrd());
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isUserExists(String userId, String firstName, String lastName) {
		Connection conn = null;
		boolean isExists = false;
		try {
			conn = ConnectionFactory.getConnection();
			UserInfoDAO dao = new UserInfoDAO(conn);
			isExists = dao.isUserExists(userId, firstName, lastName);		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		return isExists;
}
	
	public String addUser(UserInfoVO user) {
		Connection conn =null;
		String error=""; 
		try {
			conn=ConnectionFactory.getConnection();
			UserInfoDAO dao = new UserInfoDAO(conn);
			error = dao.addUser(user);			
		} catch (Exception ex){
			ex.printStackTrace();
			error = ex.getMessage();
		} finally {
			if (conn!=null){
				try{
					conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}										
		}
		
		return error;
	}

	
	public String addSub(UserInfoDAO user) {
		Connection conn =null;
		String error=""; 
		try {
			conn=ConnectionFactory.getConnection();
			UserInfoDAO dao = new UserInfoDAO(conn);
			//error = dao.addSub(user);			
		} catch (Exception ex){
			ex.printStackTrace();
			error = ex.getMessage();
		} finally {
			if (conn!=null){
				try{
					conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}										
		}
		
		return error;
	}
	public String updateUser(UserInfoVO user) {
		Connection conn =null;
		String error=""; 
		try {
			conn=ConnectionFactory.getConnection();
			UserInfoDAO dao = new UserInfoDAO(conn);
			error = dao.updateUser(user);			
		} catch (Exception ex){
			ex.printStackTrace();
			error = ex.getMessage();
		} finally {
			if (conn!=null){
				try{
					conn.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}										
		}
		
		return error;
	}

	public String deleteUser(UserInfoVO user) {
		
		
		return null;
	}
	
	public static void main(String[] args) {
		SigninDatabaseAdapter adapter = new SigninDatabaseAdapter();
		adapter.searchForData();
	}
}
