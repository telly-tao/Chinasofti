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
import com.leisurelife.service.impl.music.VocalConcertDetailsServiceImpl;
import com.leisurelife.service.music.VocalConcertDetailsService;
//@WebServlet("mvcd")
public class VocalConcertDetailsController extends HttpServlet {

	private static final long serialVersionUID = -2873156464928580876L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ȡ��������
		Map<String,Object> request =new HashMap<String,Object>();
		request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
		request.put("cid", req.getParameter("cid"));
		
		//��ȡ������
		VocalConcertDetailsService vcds=new VocalConcertDetailsServiceImpl();
		String result=vcds.vocalConcertDetailsRequest(request);
		
		//�ύ������
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
