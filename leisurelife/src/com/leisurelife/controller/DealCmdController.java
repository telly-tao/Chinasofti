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
		switch (req.getParameter("cmd")) {
		//请求列表
		case "0"://登录
			LoginController login = new LoginController();
			login.doPost(req, resp);
			break;
		case "1"://注册
			RegisterController register = new RegisterController();
			register.doPost(req, resp);
			break;
		case "501"://音乐会列表
			ConcertListController concertList = new ConcertListController();
			concertList.doPost(req, resp);
			break;
		case "502"://音乐会列表
			ConcertDetailsController concertDetails = new ConcertDetailsController();
			concertDetails.doPost(req, resp);
			break;
		case "201"://演唱会列表
			VocalConcertListController vocalConcertList = new VocalConcertListController();
			vocalConcertList.doPost(req, resp);
			break;
		case "202"://演唱会详情
			VocalConcertDetailsController vocalConcertDetails = new VocalConcertDetailsController();
			vocalConcertDetails.doPost(req, resp);
			break;
		case "101"://影视列表
			MovieListController movieList = new MovieListController();
			movieList.doPost(req, resp);
			break;
		case "102"://影视细节
			MovieDetailsController movieDetails = new MovieDetailsController();
			movieDetails.doPost(req, resp);
			break;
		case "103"://影评列表
			MovieCommentController movieComment = new MovieCommentController();
			movieComment.doPost(req, resp);
			break;
		case "104"://影评提交
			MovieCommentSubmitController movieCommentSubmit = new MovieCommentSubmitController();
			movieCommentSubmit.doPost(req, resp);
			break;
		default:
			break;
		}

	}

}
