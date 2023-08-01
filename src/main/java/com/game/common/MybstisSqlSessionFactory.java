package com.game.common;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.BoardInfoMapper;
import com.game.vo.BoardInfoVO;

public class MybstisSqlSessionFactory {

	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";

	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}

	public static void main(String[] args) {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = null;
		try {
			session = ssf.openSession(true);
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			BoardInfoVO bi = new BoardInfoVO();
			System.out.println(biMapper.selectBoardInfoList(bi));

//			bi.setBiTitle("굿");
//			bi.setBiContent("굿굿굿");
//			bi.setUiNum(2);
//			int result = biMapper.insertBoardInfo(bi);
//			System.out.println(result);
//
//			bi.setBiTitle("업데이트");
//			result = biMapper.updateBoardInfo(bi);
//			System.out.println(result);
//			bi.setBiNum(13);
//			result = biMapper.deleteBoardInfo(bi);
//			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
