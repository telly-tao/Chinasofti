package com.leisurelife.controller.movie;

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
import com.leisurelife.service.impl.movie.MovieCommentServiceImpl;
import com.leisurelife.service.movie.MovieCommentService;
//@WebServlet("mmcc")
public class MovieCommentController extends HttpServlet {

	private static final long serialVersionUID = -816389183445419587L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ȡ��������
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		request.put("mid", req.getParameter("mid"));
		request.put("type", Integer.parseInt(req.getParameter("tyep")));
		
		//��ȡ������
		MovieCommentService mvs=new MovieCommentServiceImpl();
		List<Object> result=new ArrayList<Object>();
		result=mvs.movieCommentRequest(request);
		
		//�ύ������
		PrintWriter out =resp.getWriter();
		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
