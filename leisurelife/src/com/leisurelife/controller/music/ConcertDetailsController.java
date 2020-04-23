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

import com.leisurelife.service.impl.music.ConcertDetailsServiceImpl;
import com.leisurelife.service.music.ConcertDetailsService;
public class ConcertDetailsController extends HttpServlet {
	private static Logger logger=Logger.getLogger(ConcertDetailsController.class);
	
	private static final long serialVersionUID = -2435752707430865569L;
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
		System.out.println("ConcertDetailsController request:"+request);
		logger.info("ConcertDetailsController request:"+request);
		//��ȡ������
		ConcertDetailsService cds=new ConcertDetailsServiceImpl();
		String result=cds.concertDetailsRequest(request);
		System.out.println("ConcertDetailsController request:"+result);
		logger.info("ConcertDetailsController request:"+result);
		//�ύ������
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
