package com.leisurelife.controller.movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.leisurelife.controller.LoginController;
import com.leisurelife.service.impl.movie.MovieCommentServiceImpl;
import com.leisurelife.service.movie.MovieCommentService;

public class MovieCommentController extends HttpServlet {

	private static final long serialVersionUID = -816389183445419587L;
	private static Logger logger=Logger.getLogger(LoginController.class);
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
		request.put("type", Integer.parseInt(req.getParameter("tyep")));
		System.out.println("MovieCommlist request p:" +request);
		logger.info("MovieCommlist request p:" +request);
		//获取处理结果
		MovieCommentService mvs=new MovieCommentServiceImpl();
		String result=mvs.movieCommentRequest(request);
		System.out.println("MovieCommlist result :" +result);
		logger.info("MovieCommlist result :" +result);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
