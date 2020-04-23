package com.leisurelife.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.leisurelife.service.LoginService;
import com.leisurelife.service.impl.LoginServiceImpl;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -8043293461953776895L;
	private static Logger logger=Logger.getLogger(LoginController.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求数据
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", req.getParameter("cmd"));
		request.put("username", req.getParameter("username"));
		request.put("password", req.getParameter("password"));
		System.out.println("request1111:"+request);
		logger.info("request:"+request);
		//获取处理结果
		LoginService login=new LoginServiceImpl();
		String result=login.loginRequest(request);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		logger.info("request:"+result);
		out.write(result);
		out.flush();
		out.close();
	}

}
