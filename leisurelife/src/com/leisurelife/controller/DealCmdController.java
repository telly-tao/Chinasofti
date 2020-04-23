package com.leisurelife.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leisurelife.controller.movie.MovieCommentController;
import com.leisurelife.controller.movie.MovieCommentSubmitController;
import com.leisurelife.controller.movie.MovieDetailsController;
import com.leisurelife.controller.movie.MovieListController;
import com.leisurelife.controller.music.ConcertDetailsController;
import com.leisurelife.controller.music.ConcertListController;
import com.leisurelife.controller.music.VocalConcertDetailsController;
import com.leisurelife.controller.music.VocalConcertListController;
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
		}else if(req.getParameter("cmd").equals("502")) {
			ConcertDetailsController concertDetails=new ConcertDetailsController();
			concertDetails.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("201")) {
			VocalConcertListController vocalConcertList=new VocalConcertListController();
			vocalConcertList.doPost(req, resp);

		}
		else if(req.getParameter("cmd").equals("202")) {
			VocalConcertDetailsController concertDetails=new VocalConcertDetailsController();
			concertDetails.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("101")) {
			MovieListController movieList=new MovieListController();
			movieList.doPost(req, resp);
		}
		else if(req.getParameter("cmd").equals("102")) {

		}else if(req.getParameter("cmd").equals("202")) {
			VocalConcertDetailsController vocalConcertDetails=new VocalConcertDetailsController();
			vocalConcertDetails.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("101")) {
			MovieListController movieList=new MovieListController();
			movieList.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("102")) {

			MovieDetailsController movieDetails=new MovieDetailsController();
			movieDetails.doPost(req, resp);
		}else if(req.getParameter("cmd").equals("103")) {
			MovieCommentController movieComment=new MovieCommentController();
			movieComment.doPost(req, resp);
		}
		else if(req.getParameter("cmd").equals("104")) {
			MovieCommentSubmitController movieCommentSubmit=new MovieCommentSubmitController();
			movieCommentSubmit.doPost(req, resp);
		}
	}

}
