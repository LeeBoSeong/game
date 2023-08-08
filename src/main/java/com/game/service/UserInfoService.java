package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.UserInfoVO;

public interface UserInfoService {
	List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);
	Map<String, String> selectUserInfoOne(String uiNum);
	int insertUserInfo(Map<String, String> userInfo);
	int updateUserInfo(Map<String, String> userInfo);
	int deleteUserInfo(String userInfo);
	
	Map<String, String> userLogInInfo(String uiId);
}
