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

import com.leisurelife.service.impl.music.VocalConcertDetailsServiceImpl;
import com.leisurelife.service.music.VocalConcertDetailsService;
//@WebServlet("mvcd")
public class VocalConcertDetailsController extends HttpServlet {

	private static final long serialVersionUID = -2873156464928580876L;
	private static Logger logger=Logger.getLogger(VocalConcertDetailsController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取请求数据
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		request.put("cid", req.getParameter("cid"));
		System.out.println("VocalConcertDetailsController request :"+request);
		logger.info("VocalConcertDetailsController request :"+request);
		//获取处理结果
		VocalConcertDetailsService vcds=new VocalConcertDetailsServiceImpl();
		String result=vcds.vocalConcertDetailsRequest(request);
		System.out.println("VocalConcertDetailsController result :"+result);
		logger.info("VocalConcertDetailsController result :"+result);
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
