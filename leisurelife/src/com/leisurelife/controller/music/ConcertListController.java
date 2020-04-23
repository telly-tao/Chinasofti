package com.leisurelife.controller.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.leisurelife.service.impl.music.ConcertListServiceImpl;
import com.leisurelife.service.music.ConcertListService;
//@WebServlet("mcl")
public class ConcertListController extends HttpServlet {

	private static final long serialVersionUID = 483442196554952650L;
	private static Logger logger=Logger.getLogger(ConcertListController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取请求数据
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		System.out.println("ConcertListController request"+request);
		logger.info("ConcertListController request"+request);
		//获取处理结果
		ConcertListService cls=new ConcertListServiceImpl();
		String result=cls.concertListRequest(request);
		System.out.println("ConcertListController result"+result);
		logger.info("ConcertListController result"+result);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
