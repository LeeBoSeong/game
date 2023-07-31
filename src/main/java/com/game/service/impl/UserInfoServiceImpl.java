package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoDAO uiRepo = new UserInfoDAOImpl();
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		
		return uiRepo.selectUserInfoList(userInfo);
	}

	@Override
	public Map<String, String> selectUserInfoOne(String uiNum) {
		// TODO Auto-generated method stub
		return uiRepo.selectUserInfoOne(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		return uiRepo.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		return uiRepo.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String userInfo) {
		// TODO Auto-generated method stub
		return uiRepo.deleteUserInfo(userInfo);
	}

	@Override
	public Map<String, String> userLogInInfo(String uiId) {
		return uiRepo.userLogInInfo(uiId);
	}
	
	

}
