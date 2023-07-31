package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.game.common.CommonViews;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserInfoService uiService = new UserInfoServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonViews.getCmd(request);
		if("list".equals(cmd)) {
			request.setAttribute("userList", uiService.selectUserInfoList(null));
		}else if ("view".equals(cmd)||"update".equals(cmd)) {
			Map<String, String> user = uiService.selectUserInfoOne(request.getParameter("uiNum"));
			request.setAttribute("userInfo", user);
			
		}else if ("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("msg", "로그아웃 성공");
			request.setAttribute("url", "/");
			CommonViews.forwordMessahe(request, response);
			return;
		}
		CommonViews.forword(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonViews.getCmd(request);
		if("update".equals(cmd)) {
			Map<String, String> userInfo = new HashMap();
			String uiNum = request.getParameter("uiNum");
			userInfo.put("uiNum", uiNum);
			userInfo.put("uiName", request.getParameter("uiName"));
			userInfo.put("uiId", request.getParameter("uiId"));
			userInfo.put("uiPwd", request.getParameter("uiPwd"));
			userInfo.put("uiBirth", request.getParameter("uiBirth"));
			int result = uiService.updateUserInfo(userInfo);
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "/user-info/update?uiNum="+uiNum);
			if(result == 1) {
				request.setAttribute("msg", "수정 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}else if("delete".equals(cmd)) {
			int result = uiService.deleteUserInfo(request.getParameter("uiNum"));
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("url", "/user-info/list");
			if(result == 1) {
				request.setAttribute("msg", "삭제 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}else if ("insert".equals(cmd)){
			Map<String, String> userInfoMap = new HashMap();
			userInfoMap.put("uiName", request.getParameter("uiName"));
			userInfoMap.put("uiId", request.getParameter("uiId"));
			userInfoMap.put("uiPwd", request.getParameter("uiPwd"));
			userInfoMap.put("uiDesc", request.getParameter("uiDesc"));
			userInfoMap.put("uiBirth", request.getParameter("uiBirth"));
			int result = uiService.insertUserInfo(userInfoMap);
			request.setAttribute("msg", "등록 실패");
			request.setAttribute("url", "/user-info/list");
			if(result == 1) {
				request.setAttribute("msg", "등록 성공");
				request.setAttribute("url", "/user-info/list");
			}
		}else if ("login".equals(cmd)) {
			String uiId = request.getParameter("uiId");
			String uiPw = request.getParameter("uiPwd");
			Map<String, String> userLogIn = uiService.userLogInInfo(uiId);
			if(userLogIn != null) {
				String dbPwd = userLogIn.get("uiPwd");
				System.out.println(dbPwd);
				System.out.println(uiPw+"a");
				if (uiPw.equals(dbPwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", userLogIn);
					request.setAttribute("msg", "로그인 성공");
					request.setAttribute("url", "/");
				}else{
					request.setAttribute("msg", "로그인 실패");
					request.setAttribute("url", "/user-info/login");
				}
			}
		}
		CommonViews.forwordMessahe(request, response);
	}

}
