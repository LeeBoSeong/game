package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybstisSqlSessionFactory;
import com.game.mapper.TestInfoMapper;
import com.game.service.TestInfoService;
import com.game.vo.TestInfoVO;

public class TestInfoServiceImpl implements TestInfoService {
	private SqlSessionFactory ssf = MybstisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<TestInfoVO> selecTestInfoList(TestInfoVO testInfo) {
		try(SqlSession session = ssf.openSession()){
			TestInfoMapper testMapper = session.getMapper(TestInfoMapper.class);
			return testMapper.selecTestInfoList(null);
		}catch (Exception e) {
			throw e;
		}
	}

}
