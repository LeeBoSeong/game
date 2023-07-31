package com.game.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		List<Map<String, String>> userList = new ArrayList<>();
		String sql = "SELECT * FROM user_info";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> user = new HashMap<>();
						user.put("uiNum", rs.getString("UI_NUM"));
						user.put("uiName", rs.getString("UI_NAME"));
						user.put("uiId", rs.getString("UI_ID"));
						user.put("uiPwd", rs.getString("UI_PWD"));
						user.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						user.put("uiDesc", rs.getString("UI_DESC"));
						user.put("uiBirth", rs.getString("UI_BIRTH"));
						user.put("credat", rs.getString("CREDAT"));
						user.put("cretim", rs.getString("CRETIM"));
						user.put("lmodat", rs.getString("LMODAT"));
						user.put("lmotim", rs.getString("LMOTIM"));
						user.put("active", rs.getString("ACTIVE"));
						userList.add(user);
					}
				}
			}
		} catch (Exception e) {
		}
		return userList;
	}

	@Override
	public Map<String, String> selectUserInfoOne(String uiNum) {
		String sql="SELECT * FROM USER_INFO WHERE UI_NUM=?";
		try (Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,uiNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> user = new HashMap<>();
						user.put("uiNum", rs.getString("UI_NUM"));
						user.put("uiName", rs.getString("UI_NAME"));
						user.put("uiId", rs.getString("UI_ID"));
						user.put("uiPwd", rs.getString("UI_PWD"));
						user.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						user.put("uiDesc", rs.getString("UI_DESC"));
						user.put("uiBirth", rs.getString("UI_BIRTH"));
						user.put("credat", rs.getString("CREDAT"));
						user.put("cretim", rs.getString("CRETIM"));
						user.put("lmodat", rs.getString("LMODAT"));
						user.put("lmotim", rs.getString("LMOTIM"));
						user.put("active", rs.getString("ACTIVE"));
						return user;
					}
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql = "INSERT INTO USER_INFO (\r\n"
				+ "UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH,\r\n"
				+ "UI_DESC, UI_BIRTH,CREDAT,CRETIM,\r\n"
				+ "LMODAT,LMOTIM)\r\n"
				+ "VALUES(\r\n"
				+ "?,?,?,NULL,\r\n"
				+ "?,?,DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ ")\r\n";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiDesc"));
				ps.setString(5, userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE USER_INFO\r\n"
				+ "SET UI_NAME=?,UI_ID=?,UI_PWD=?,\r\n"
				+ "UI_DESC=?,UI_BIRTH=?\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()) {
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,userInfo.get("uiName"));
				ps.setString(2,userInfo.get("uiId"));
				ps.setString(3,userInfo.get("uiPwd"));
				ps.setString(4,userInfo.get("uiDesc"));
				ps.setString(5,userInfo.get("uiBirth"));
				ps.setString(6,userInfo.get("uiNum"));
				System.out.println(ps);
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(String userInfo) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		try (Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo);
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public Map<String, String> userLogInInfo(String uiId) {
		String sql="SELECT * FROM USER_INFO WHERE UI_ID=?";
		try (Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,uiId);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String, String> user = new HashMap<>();
						user.put("uiNum", rs.getString("UI_NUM"));
						user.put("uiName", rs.getString("UI_NAME"));
						user.put("uiId", rs.getString("UI_ID"));
						user.put("uiPwd", rs.getString("UI_PWD"));
						user.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						user.put("uiDesc", rs.getString("UI_DESC"));
						user.put("uiBirth", rs.getString("UI_BIRTH"));
						user.put("credat", rs.getString("CREDAT"));
						user.put("cretim", rs.getString("CRETIM"));
						user.put("lmodat", rs.getString("LMODAT"));
						user.put("lmotim", rs.getString("LMOTIM"));
						user.put("active", rs.getString("ACTIVE"));
						return user;
					}
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] args) {
		UserInfoDAO userDao = new UserInfoDAOImpl();
		System.out.println(userDao.selectUserInfoList(null));
		System.out.println(userDao.selectUserInfoOne("2"));
		System.out.println(userDao.deleteUserInfo("7"));
		
		
//		Map<String, String> user = new HashMap();
//		user.put("uiName", "홍길동");
//		user.put("uiId", "qwe1234");
//		user.put("uiPwd", "qwe1234");
//		user.put("uiDesc", "동에 번쩍 서에 번쩍");
//		user.put("uiBirth", "990913");
//		System.out.println(userDao.insertUserInfo(user));
		
//		Map<String, String> user = new HashMap<>();
//		user.put("uiName", "이원기");
//		user.put("uiId", "qwe1234");
//		user.put("uiPwd", "qwe123");
//		user.put("uiImgPath", "qwdafasf");
//		user.put("uiDesc", "베스트 번쩍 서에 번쩍");
//		user.put("uiBirth", "990205");
//		user.put("uiNum", "7");
//		System.out.println(userDao.updateUserInfo(user));
	}

}
