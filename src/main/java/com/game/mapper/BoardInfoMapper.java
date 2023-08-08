package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfoVO;

public interface BoardInfoMapper {

	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO bi);

	BoardInfoVO selectBoardInfo(String biNum);

	int insertBoardInfo(BoardInfoVO bi);

	int updateBoardInfo(BoardInfoVO bi);

	int deleteBoardInfo(BoardInfoVO bi);
	
	
}
