package com.leisurelife.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leisurelife.controller.music.ConcertListController;
@WebServlet("/dealcmd")
public class DealCmdController extends HttpServlet {

	private static final long serialVersionUID = 8611835336340391424L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("cmd").equals("0")) {
			LoginController login=new LoginController();
			login.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("1")) {
			RegisterController register=new RegisterController();
			register.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("501")) {
			ConcertListController concertList=new ConcertListController();
			concertList.doPost(req, resp);
		}
		
	}

}
