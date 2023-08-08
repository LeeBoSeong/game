package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybstisSqlSessionFactory;
import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.mapper.UserInfoMapper;
import com.game.service.UserInfoService;
import com.game.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoDAO uiRepo = new UserInfoDAOImpl();
	private SqlSessionFactory ssf = MybstisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo) {
		try(SqlSession session =ssf.openSession() ){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfoList(userInfo);
		}catch (Exception e) {
			throw e;
		}
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
