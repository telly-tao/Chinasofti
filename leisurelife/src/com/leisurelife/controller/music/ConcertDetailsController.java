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
@WebServlet("mcd")
public class ConcertDetailsController extends HttpServlet {

	private static final long serialVersionUID = -2435752707430865569L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取请求数据
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		request.put("mid", req.getParameter("mid"));
		
		//获取处理结果
		LoginService login=new LoginServiceImpl();
		List<Object> result=new ArrayList<Object>();
		result=login.loginRequest(request);
		
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
