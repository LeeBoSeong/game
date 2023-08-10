package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonViews;
import com.game.service.TestInfoService;
import com.game.service.impl.TestInfoServiceImpl;
import com.google.gson.Gson;

@WebServlet("/test-info/*")
public class TsetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TestInfoService testService = new TestInfoServiceImpl();
    private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonViews.getCmd(request);
		
		String json = "";
		if("list".equals(cmd)) {
			response.setContentType("application/json;charset=UTF-8");
			json = gson.toJson(testService.selecTestInfoList(null));
			PrintWriter out = response.getWriter();
			out.print(json);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
