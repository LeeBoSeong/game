package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> boardInfo) {
		String sql = "SELECT BI.*,UI.UI_NAME FROM board_info BI\r\n" + "INNER JOIN user_info UI\r\n"
				+ "ON BI.BI_NUM = UI.UI_NUM WHERE 1=1";
		if (boardInfo != null) {
			String key = boardInfo.get("key");
			if ("1".equals(key)) {
				sql += " AND BI_TITLE LIKE CONCAT('%',?,'%')";
			} else if ("2".equals(key)) {
				sql += " AND UI_NAME LIKE CONCAT('%',?,'%')";
			} else if ("3".equals(key)) {
				sql += " AND BI_CONTENT LIKE CONCAT('%',?,'%')";
			} else if ("4".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if ("5".equals(key)) {
				sql += " AND (UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			}else if ("6".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%'))";
			}else if ("7".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			}
		}
		List<Map<String, String>> board = new ArrayList<Map<String, String>>();
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				if (boardInfo != null) {
					String key = boardInfo.get("key");
					if ("1".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					}else if ("2".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					}else if ("3".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
					}else if ("4".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					}else if ("5".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					}else if ("6".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
					}else if ("7".equals(key)) {
						ps.setString(1, boardInfo.get("value"));
						ps.setString(2, boardInfo.get("value"));
						ps.setString(3, boardInfo.get("value"));
					}
				}
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> boardInfo1 = new HashMap<String, String>();
						boardInfo1.put("biNum", rs.getString("BI_NUM"));
						boardInfo1.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo1.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo1.put("uiNum", rs.getString("UI_NUM"));
						boardInfo1.put("uiName", rs.getString("UI_NAME"));
						boardInfo1.put("credat", rs.getString("CREDAT"));
						boardInfo1.put("cretim", rs.getString("CRETIM"));
						boardInfo1.put("lmodat", rs.getString("LMODAT"));
						boardInfo1.put("lmotim", rs.getString("LMOTIM"));
						boardInfo1.put("active", rs.getString("ACTIVE"));
						board.add(boardInfo1);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return board;
	}

	@Override
	public Map<String, String> selectBoardInfoOne(String biNum) {
		String sql = "SELECT * FROM board_info WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, biNum);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Map<String, String> boardInfo1 = new HashMap<String, String>();
						boardInfo1.put("biNum", rs.getString("BI_NUM"));
						boardInfo1.put("biTitle", rs.getString("BI_TITLE"));
						boardInfo1.put("biContent", rs.getString("BI_CONTENT"));
						boardInfo1.put("uiNum", rs.getString("UI_NUM"));
						boardInfo1.put("credat", rs.getString("CREDAT"));
						boardInfo1.put("cretim", rs.getString("CRETIM"));
						boardInfo1.put("lmodat", rs.getString("LMODAT"));
						boardInfo1.put("lmotim", rs.getString("LMOTIM"));
						boardInfo1.put("active", rs.getString("ACTIVE"));
						return boardInfo1;
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> boardInfo) {
		String sql = "INSERT INTO board_info(BI_TITLE,BI_CONTENT,UI_NUM,\r\n" + "CREDAT,CRETIM,LMODAT,LMOTIM)\r\n"
				+ "VALUES(?,?,?,\r\n" + "DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%I%S'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%I%S')\r\n" + ")";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo.get("biTitle"));
				ps.setString(2, boardInfo.get("biContent"));
				ps.setString(3, boardInfo.get("uiNum"));
				return ps.executeUpdate();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		String sql = "UPDATE board_info\r\n" + "SET BI_TITLE=?,\r\n" + "BI_CONTENT=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "LMOTIM=DATE_FORMAT(NOW(),'%H%I%S')\r\n"
				+ "WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo.get("biTitle"));
				ps.setString(2, boardInfo.get("biContent"));
				ps.setString(3, boardInfo.get("biNum"));
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String boardInfo) {
		String sql = "DELETE FROM board_info WHERE BI_NUM=?";
		try (Connection con = DBCon.getCon()) {
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, boardInfo);
				return ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public static void main(String[] args) {
		BoardInfoDAO bi = new BoardInfoDAOImpl();
		System.out.println(bi.selectBoardInfoList(null));
		System.out.println(bi.selectBoardInfoOne("2"));
//		System.out.println(bi.deleteBoardInfo("2"));

//		Map<String, String> board = new HashMap();
//		board.put("biTitle", "워피스");
//		board.put("biContent", "워qweqwewqewqewqeweq");
//		board.put("uiNum", "2");
//		System.out.println(bi.insertBoardInfo(board));
//		
		Map<String, String> board = new HashMap();
		board.put("biTitle", "q1워피스");
		board.put("biContent", "qwe워qweqwewqewqewqeweq");
		board.put("biNum", "4");
		System.out.println(bi.updateBoardInfo(board));
	}

}
