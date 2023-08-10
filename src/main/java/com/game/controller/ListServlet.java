package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import com.game.common.CommonViews;
import com.google.gson.Gson;

@WebServlet("/list/*")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<Map<String, String>> MOCK_LIST;
	private Gson gson = new Gson();
	static {
		MOCK_LIST = new ArrayList<Map<String, String>>();
		for (int i = 1; i <= 100; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("num", i + "");
			map.put("name", "이름" + i);
			map.put("age", i + "살");
			map.put("address", "서울 어딘가");
			MOCK_LIST.add(map);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonViews.getCmd(request);
		String json = "";
		if ("list".equals(cmd)) {
			json = gson.toJson(MOCK_LIST);
		} else if ("one".equals(cmd) || "update".equals(cmd)) {
			String num = request.getParameter("num");
			if (num != null) {
				for (Map<String, String> map : MOCK_LIST) {
					if (map.get("num").equals(num)) {
						json = gson.toJson(map);
						break;
					}
				}
			}
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		String cmd = CommonViews.getCmd(request);
		String json = "0";

		if ("insert".equals(cmd)) {
			map.put("num", MOCK_LIST.size() + 1 + "");
			if (MOCK_LIST.add(map)) {
				json = "1";
			}
		} else if ("delete".equals(cmd)) {
			String num = request.getParameter("num");
			if (num != null) {
				for (Map<String, String> map1 : MOCK_LIST) {
					if (map1.get("num").equals(num)) {
						if (MOCK_LIST.remove(map1)) {
							json = "1";

						}
						break;
					}
				}
			}
		} else if ("upadte".equals(cmd)) {
			if (map != null && map.get("num") != null) {
				String num = map.get("num");
				for (Map<String, String> uMap : MOCK_LIST) {
					if (uMap.get("num").equals(num)){
						uMap.put("name",uMap.get("num"));
						uMap.put("age",uMap.get("age"));
						uMap.put("address",uMap.get("address"));
					}
				}
			}

		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
