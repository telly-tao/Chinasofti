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

import com.leisurelife.service.impl.movie.MovieDetailsServiceImpl;
import com.leisurelife.service.movie.MovieDetailsService;
//@WebServlet("mmd")
public class MovieDetailsController extends HttpServlet {

	private static final long serialVersionUID = 5828548786637575733L;
	private static Logger logger=Logger.getLogger(MovieDetailsController.class);
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
		System.out.println("MovieDetails request p:" +request);
		logger.info("MovieDetails request p:" +request);
		//获取处理结果
		MovieDetailsService mds=new MovieDetailsServiceImpl();
		String result=mds.moviceDetialsRequest(request);
		System.out.println("MovieDetails result :" +result);
		logger.info("MovieDetails result :" +result);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
