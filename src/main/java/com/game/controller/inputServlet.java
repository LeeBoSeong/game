package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/input/*")
public class inputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
			System.out.println(str);
		}

		System.out.println(sb.toString());
		Map<String, String> map = gson.fromJson(sb.toString(), Map.class);
		System.out.println(map);
		int json = 0;
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		String desc = request.getParameter("desc");
//		String trans =request.getParameter("trans");
//		String job =request.getParameter("job");
//		
//		String result = "이름 :"+name +" ,아이디: " + id +", 비번: "+ pwd + ", 소개: " +desc+ ", 성별: " +trans+ ", 직업: " + job;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
