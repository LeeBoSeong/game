package com.game.common;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonViews {
	private static final String PREFIX = "/WEB-INF/views";
	private static final String SUFFIX = ".jsp";
	
	public static String getCmd(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		return uri.substring(idx);
	}
	
	public static void forword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = PREFIX + request.getRequestURI() + SUFFIX;
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	public static void forwordMessahe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/common/message.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
}
