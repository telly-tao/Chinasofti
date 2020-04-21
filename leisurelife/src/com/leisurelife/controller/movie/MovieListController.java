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
import com.leisurelife.service.impl.movie.MovieListServiceImpl;
import com.leisurelife.service.movie.MovieListService;
@WebServlet("mml")
public class MovieListController extends HttpServlet {

	private static final long serialVersionUID = 4405718835789337528L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取请求数据
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		
		//获取处理结果
		MovieListService mls=new MovieListServiceImpl();
		List<Object> result=new ArrayList<Object>();
		result=mls.movieListRequest(request);
		
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
