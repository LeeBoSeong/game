package com.game.controller;

import java.io.IOException;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonViews;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;

@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardInfoService bi = new BoardInfoServiceImpl();

	public static boolean isLogIn(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		return true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonViews.getCmd(request);
		if (!isLogIn(request, response)) {
			return;
		}

		if ("list".equals(cmd)) {
			Map<String, String> parm = null;
			if (request.getParameter("searchType") != null) {
				parm = new HashMap<String, String>();
				String key = request.getParameter("searchType");
				String value = request.getParameter("searchStr");
				parm.put("key", key);
				parm.put("value", value);
			}

			List<Map<String, String>> boardList = bi.selectBoardInfoList(parm);
			request.setAttribute("boardList", boardList);

		} else if ("view".equals(cmd) || "update".equals(cmd)) {
			Map<String, String> board = bi.selectBoardInfoOne(request.getParameter("biNum"));
			request.setAttribute("board", board);
		}
		CommonViews.forword(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!isLogIn(request, response)) {
			return;
		}

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> user = (Map<String, String>) session.getAttribute("user");
		String cmd = CommonViews.getCmd(request);
		if ("insert".equals(cmd)) {
			Map<String, String> board = new HashMap();
			board.put("biTitle", request.getParameter("biTitle"));
			board.put("biContent", request.getParameter("biContent"));
			board.put("uiNum", user.get("uiNum"));
			int result = bi.insertBoardInfo(board);
			request.setAttribute("msg", "등록 실패!");
			request.setAttribute("url", "/board-info/list");
			if (result == 1) {
				request.setAttribute("msg", "등록 성공");
				request.setAttribute("url", "/board-info/list");
			}
		} else if ("delete".equals(cmd)) {
			int result = bi.deleteBoardInfo(request.getParameter("biNum"));
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("url", "/board-info/list");
			if (result == 1) {
				request.setAttribute("msg", "삭제 성공");
				request.setAttribute("url", "/board-info/list");
			}
		} else if ("update".equals(cmd)) {
			Map<String, String> board = new HashMap();
			board.put("biTitle", request.getParameter("biTitle"));
			board.put("biContent", request.getParameter("biContent"));
			board.put("biNum", request.getParameter("biNum"));
			int result = bi.updateBoardInfo(board);
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "/board-info/list");
			if (result == 1) {
				request.setAttribute("msg", "수정 성공");
				request.setAttribute("url", "/board-info/list");
			}
		}
		CommonViews.forwordMessahe(request, response);
	}

}
