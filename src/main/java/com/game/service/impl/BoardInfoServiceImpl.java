package com.game.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybstisSqlSessionFactory;
import com.game.dao.BoardInfoDAO;
import com.game.dao.impl.BoardInfoDAOImpl;
import com.game.mapper.BoardInfoMapper;
import com.game.service.BoardInfoService;
import com.game.vo.BoardInfoVO;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDAO bi = new BoardInfoDAOImpl();
	private SqlSessionFactory ssf = MybstisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO boardInfo) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfoList(boardInfo);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public BoardInfoVO selectBoardInfoOne(String biNum) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfo(biNum);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int insertBoardInfo(Map<String, String> boardInfo) {
		return bi.insertBoardInfo(boardInfo);
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		return bi.updateBoardInfo(boardInfo);
	}

	@Override
	public int deleteBoardInfo(String boardInfo) {
		return bi.deleteBoardInfo(boardInfo);
	}

}
