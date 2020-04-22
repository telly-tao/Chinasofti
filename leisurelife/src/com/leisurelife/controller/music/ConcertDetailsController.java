package com.leisurelife.controller.music;

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

import com.alibaba.fastjson.JSON;
import com.leisurelife.service.LoginService;
import com.leisurelife.service.impl.LoginServiceImpl;
import com.leisurelife.service.impl.music.ConcertDetailsServiceImpl;
import com.leisurelife.service.music.ConcertDetailsService;
//@WebServlet("mcd")
public class ConcertDetailsController extends HttpServlet {

	private static final long serialVersionUID = -2435752707430865569L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取请求数据
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		request.put("mid", req.getParameter("mid"));
		System.out.println("request:"+request);
		//获取处理结果
		ConcertDetailsService cds=new ConcertDetailsServiceImpl();
		String result=cds.concertDetailsRequest(request);
		System.out.println(result);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
