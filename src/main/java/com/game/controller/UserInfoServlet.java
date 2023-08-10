package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.game.vo.UserInfoVO;
import com.google.gson.Gson;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonViews.getCmd(request);
		String json = "";
		if ("list".equals(cmd)) {
			json = gson.toJson(uiService.selectUserInfoList(null));
		} else if ("view".equals(cmd) || "update".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			if (uiNum != 0) {
				for (UserInfoVO map : uiService.selectUserInfoList(null)) {
					if (map.getUiNum() == (uiNum)) {
						json = gson.toJson(map);
						break;
					}
				}
			}
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonViews.getCmd(request);
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		Map<String, String> map = gson.fromJson(sb.toString(), Map.class);
		System.out.println(map);
		String json = "0";

		if ("delete".equals(cmd)) {
			String uiNum = map.get("num");
			System.out.println(uiNum);
			if (uiNum != null) {
				json = uiService.deleteUserInfo(uiNum) +"";
				System.out.println(json);
			}
		} else if ("insert".equals(cmd)) {
			json = uiService.insertUserInfo(map)+"";
		} else if ("update".equals(cmd)) {
			if(map != null) {
				json = uiService.updateUserInfo(map) + "";
			}
		}else if ("login".equals(cmd)) {
			String uiId = request.getParameter("uiId");
			String uiPw = request.getParameter("uiPwd");
			Map<String, String> userLogIn = uiService.userLogInInfo(uiId);
			if (userLogIn != null) {
				String dbPwd = userLogIn.get("uiPwd");
				System.out.println(dbPwd);
				System.out.println(uiPw + "a");
				if (uiPw.equals(dbPwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", userLogIn);
					request.setAttribute("msg", "로그인 성공");
					request.setAttribute("url", "/");
				} else {
					request.setAttribute("msg", "로그인 실패");
					request.setAttribute("url", "/user-info/login");
				}
			}
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
