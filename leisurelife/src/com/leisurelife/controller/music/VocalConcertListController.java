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

import com.leisurelife.controller.LoginController;
import com.leisurelife.service.impl.music.VocalConcertListServiceImpl;
import com.leisurelife.service.music.VocalConcertListService;

public class VocalConcertListController extends HttpServlet {

	private static final long serialVersionUID = -3239875443876470805L;
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
		
		//获取处理结果
		VocalConcertListService vcls=new VocalConcertListServiceImpl();
		String result=vcls.vocalConcertListRequest(request);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
