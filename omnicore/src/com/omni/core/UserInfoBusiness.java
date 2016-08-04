package com.omni.core;

import com.omni.data.SigninDatabaseAdapter;
import com.omni.data.vo.SunInfoVO;
import com.omni.data.vo.UserInfoVO;

public class UserInfoBusiness {
	
	public String updateUserInfo(UserInfoVO userVO) {
		String error = null;
		// 1: check whether this user already exists in database
		SigninDatabaseAdapter adapter = new SigninDatabaseAdapter();
		if (adapter.isUserExists(userVO.getUserName(), userVO.getFirstName(), userVO.getLastName())) { 
			error = adapter.updateUser(userVO);
		} else {
			error = adapter.addUser(userVO);	
		}
		return error;
	}
	
	public String updateSubInfo(SunInfoVO userVO) {
		String error = null;
		// 1: check whether this user already exists in database
		SigninDatabaseAdapter adapter = new SigninDatabaseAdapter();
		//error=adapter.addSub(userVo)
		return error;
	}
}