package com.leisurelife.controller.movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.leisurelife.service.impl.movie.MovieCommentSubmitServiceImpl;
import com.leisurelife.service.movie.MovieCommentSubmitService;

public class MovieCommentSubmitController extends HttpServlet {

	private static final long serialVersionUID = 6246155383014622248L;

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
		request.put("content", req.getParameter("content"));
		request.put("username", req.getParameter("username"));
		
		//��ȡ������
		MovieCommentSubmitService mcss=new MovieCommentSubmitServiceImpl();
		String result=mcss.movieCommentSubmitRequest(request);
		
		//�ύ������
		PrintWriter out =resp.getWriter();
		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}
}
