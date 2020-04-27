package com.leisurelife.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import com.leisurelife.controller.delicious.DeliciousCommentController;
//import com.leisurelife.controller.delicious.DeliciousCommentSubmitComtroller;
//import com.leisurelife.controller.delicious.DeliciousDetialsController;
//import com.leisurelife.controller.delicious.DeliciousListController;
//import com.leisurelife.controller.movie.MovieCommentController;
//import com.leisurelife.controller.movie.MovieCommentSubmitController;
//import com.leisurelife.controller.movie.MovieDetailsController;
//import com.leisurelife.controller.movie.MovieListController;
//import com.leisurelife.controller.music.ConcertDetailsController;
//import com.leisurelife.controller.music.ConcertListController;
//import com.leisurelife.controller.music.VocalConcertDetailsController;
//import com.leisurelife.controller.music.VocalConcertListController;
//import com.leisurelife.controller.theatre.BeijingOperaDetialsController;
//import com.leisurelife.controller.theatre.BeijingOperaListController;
//import com.leisurelife.controller.theatre.ModernDramaDetialsController;
//import com.leisurelife.controller.theatre.ModernDramaListController;
import com.leisurelife.service.LoginService;
import com.leisurelife.service.RegisterService;
import com.leisurelife.service.delicious.DeliciousCommentService;
import com.leisurelife.service.delicious.DeliciousCommentSubmitService;
import com.leisurelife.service.delicious.DeliciousDetialsService;
import com.leisurelife.service.delicious.DeliciousListService;
import com.leisurelife.service.impl.LoginServiceImpl;
import com.leisurelife.service.impl.RegisterServiceImpl;
import com.leisurelife.service.impl.delicious.DeliciousCommentServiceImpl;
import com.leisurelife.service.impl.delicious.DeliciousCommentSubmitServiceImpl;
import com.leisurelife.service.impl.delicious.DeliciousDetialsServiceImpl;
import com.leisurelife.service.impl.delicious.DeliciousListServiceImpl;
import com.leisurelife.service.impl.movie.MovieCommentServiceImpl;
import com.leisurelife.service.impl.movie.MovieCommentSubmitServiceImpl;
import com.leisurelife.service.impl.movie.MovieDetailsServiceImpl;
import com.leisurelife.service.impl.movie.MovieListServiceImpl;
import com.leisurelife.service.impl.music.ConcertDetailsServiceImpl;
import com.leisurelife.service.impl.music.ConcertListServiceImpl;
import com.leisurelife.service.impl.music.VocalConcertDetailsServiceImpl;
import com.leisurelife.service.impl.music.VocalConcertListServiceImpl;
import com.leisurelife.service.impl.theatre.BeijingOperaDetialsServiceImpl;
import com.leisurelife.service.impl.theatre.BeijingOperaListServiceImpl;
import com.leisurelife.service.impl.theatre.ModernDramaDetialsServiceImpl;
import com.leisurelife.service.impl.theatre.ModernDramaListServiceImpl;
import com.leisurelife.service.movie.MovieCommentService;
import com.leisurelife.service.movie.MovieCommentSubmitService;
import com.leisurelife.service.movie.MovieDetailsService;
import com.leisurelife.service.movie.MovieListService;
import com.leisurelife.service.music.ConcertDetailsService;
import com.leisurelife.service.music.ConcertListService;
import com.leisurelife.service.music.VocalConcertDetailsService;
import com.leisurelife.service.music.VocalConcertListService;
import com.leisurelife.service.theatre.BeijingOperaDetialsService;
import com.leisurelife.service.theatre.BeijingOperaListService;
import com.leisurelife.service.theatre.ModernDramaDetialsService;
import com.leisurelife.service.theatre.ModernDramaListService;

@WebServlet("/dealcmd")
public class DealCmdController extends HttpServlet {
	private static final long serialVersionUID = 8611835336340391424L;
	private static Logger logger=Logger.getLogger(DealCmdController.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result=null;
		Map<String,Object> request=null;
		switch (req.getParameter("cmd")) {
		//请求列表
		case "0"://登录
			//LoginController login = new LoginController();
			//login.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			request.put("username", req.getParameter("username"));
			request.put("password", req.getParameter("password"));
			System.out.println("LoginController request:"+request);
			logger.info("LoginController request:"+request);
			//获取处理结果
			LoginService login=new LoginServiceImpl();
			result=login.loginRequest(request);
			System.out.println("LoginController result:"+request);
			logger.info("LoginController result:"+result);
			break;
		case "1"://注册
//			RegisterController register = new RegisterController();
//			register.doPost(req, resp);
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			request.put("username", req.getParameter("username"));
			request.put("password", req.getParameter("password"));
			System.out.println("RegisterController request:"+request);
			logger.info("RegisterController request:"+request);
			//获取处理结果
			RegisterService register=new RegisterServiceImpl();
			result=register.registerRequest(request);
			System.out.println("RegisterController result:"+result);
			logger.info("RegisterController result:"+result);
			break;
		case "501"://音乐会列表
//			ConcertListController concertList = new ConcertListController();
//			concertList.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			System.out.println("ConcertListController request"+request);
			logger.info("ConcertListController request"+request);
			//获取处理结果
			ConcertListService cls=new ConcertListServiceImpl();
			result=cls.concertListRequest(request);
			System.out.println("ConcertListController result"+result);
			logger.info("ConcertListController result"+result);
			break;
		case "502"://音乐会详情
//			ConcertDetailsController concertDetails = new ConcertDetailsController();
//			concertDetails.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			request.put("mid", req.getParameter("mid"));
			System.out.println("ConcertDetailsController request:"+request);
			logger.info("ConcertDetailsController request:"+request);
			//获取处理结果
			ConcertDetailsService cds=new ConcertDetailsServiceImpl();
			result=cds.concertDetailsRequest(request);
			System.out.println("ConcertDetailsController request:"+result);
			logger.info("ConcertDetailsController request:"+result);
			break;
		case "201"://演唱会列表
//			VocalConcertListController vocalConcertList = new VocalConcertListController();
//			vocalConcertList.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			System.out.println("VocalConcertListController request:"+request);
			logger.info("VocalConcertListController request:"+request);
			//获取处理结果
			VocalConcertListService vcls=new VocalConcertListServiceImpl();
			result=vcls.vocalConcertListRequest(request);
			System.out.println("VocalConcertListController result:"+result);
			logger.info("VocalConcertListController result:"+result);
			break;
		case "202"://演唱会详情
//			VocalConcertDetailsController vocalConcertDetails = new VocalConcertDetailsController();
//			vocalConcertDetails.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			request.put("cid", req.getParameter("cid"));
			System.out.println("VocalConcertDetailsController request :"+request);
			logger.info("VocalConcertDetailsController request :"+request);
			//获取处理结果
			VocalConcertDetailsService vcds=new VocalConcertDetailsServiceImpl();
			result=vcds.vocalConcertDetailsRequest(request);
			System.out.println("VocalConcertDetailsController result :"+result);
			logger.info("VocalConcertDetailsController result :"+result);
			break;
		case "101"://影视列表
//			MovieListController movieList = new MovieListController();
//			movieList.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			System.out.println("MovieList request p:" +request);
			logger.info("MovieList request p:" +request);
			//获取处理结果
			MovieListService mls=new MovieListServiceImpl();
			result=mls.movieListRequest(request);
			System.out.println("MovieList result :" +result);
			logger.info("MovieList result :" +result);
			break;
		case "102"://影视细节
//			MovieDetailsController movieDetails = new MovieDetailsController();
//			movieDetails.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			request.put("mid", req.getParameter("mid"));
			System.out.println("MovieDetails request p:" +request);
			logger.info("MovieDetails request p:" +request);
			//获取处理结果
			MovieDetailsService mds=new MovieDetailsServiceImpl();
			result=mds.moviceDetialsRequest(request);
			System.out.println("MovieDetails result :" +result);
			logger.info("MovieDetails result :" +result);
			break;
		case "103"://影评列表
//			MovieCommentController movieComment = new MovieCommentController();
//			movieComment.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			request.put("mid", req.getParameter("mid"));
			request.put("type", 1);
			System.out.println("MovieCommlist request p:" +request);
			logger.info("MovieCommlist request p:" +request);
			//获取处理结果
			MovieCommentService mvs=new MovieCommentServiceImpl();
			result=mvs.movieCommentRequest(request);
			System.out.println("MovieCommlist result :" +result);
			logger.info("MovieCommlist result :" +result);
			break;
		case "104"://影评提交
//			MovieCommentSubmitController movieCommentSubmit = new MovieCommentSubmitController();
//			movieCommentSubmit.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			request.put("mid", req.getParameter("mid"));
			request.put("type", 1);
			request.put("content", req.getParameter("content"));
			request.put("username", req.getParameter("username"));
			System.out.println("MovieCommSub request p:" +request);
			logger.info("MovieCommSub request p:" +request);
			//获取处理结果
			MovieCommentSubmitService mcss=new MovieCommentSubmitServiceImpl();
			result=mcss.movieCommentSubmitRequest(request);
			System.out.println("MovieCommSub result :" +result);
			logger.info("MovieCommSub result :" +result);
			break;
		case "601"://京剧列表
//			BeijingOperaListController beijingOperaListController = new BeijingOperaListController();
//			beijingOperaListController.doPost(req, resp);
			System.out.println("MovieCommlist start");
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			System.out.println("MovieCommlist request p:" +request);
			logger.info("MovieCommlist request p:" +request);
			//获取处理结果
			BeijingOperaListService bols=new BeijingOperaListServiceImpl();
			result=bols.beijingOperaListRequest(request);
			System.out.println("BeijingOperaList result :" +result);
			logger.info("BeijingOperaList result :" +result);
			break;
		case "602"://京剧细节
//			BeijingOperaDetialsController beijingOperaDetialsController = new BeijingOperaDetialsController();
//			beijingOperaDetialsController.doPost(req, resp);
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			request.put("mid", req.getParameter("mid"));
			System.out.println("BeijingOperaDetials request p:" +request);
			logger.info("BeijingOperaDetials request p:" +request);
			//获取处理结果
			BeijingOperaDetialsService bods=new BeijingOperaDetialsServiceImpl();
			result=bods.beijingOperaDetialsRequest(request);
			System.out.println("BeijingOperaDetials result :" +result);
			logger.info("BeijingOperaDetials result :" +result);
			break;
		case "701"://话剧列表
//			ModernDramaListController modernDramaListController = new ModernDramaListController();
//			modernDramaListController.doPost(req, resp);
			System.out.println("MovieCommlist start");
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			System.out.println("ModernDramaList request p:" +request);
			logger.info("ModernDramaList request p:" +request);
			//获取处理结果
			ModernDramaListService modls=new ModernDramaListServiceImpl();
			result=modls.modernDramaListRequest(request);
			System.out.println("ModernDramaList result :" +result);
			logger.info("ModernDramaList result :" +result);
			break;
		case "702"://话剧详情
//			ModernDramaDetialsController modernDramaDetialsController = new ModernDramaDetialsController();
//			modernDramaDetialsController.doPost(req, resp);
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			request.put("mid", req.getParameter("mid"));
			System.out.println("ModernDramaDetials request p:" +request);
			logger.info("ModernDramaDetials request p:" +request);
			//获取处理结果
			ModernDramaDetialsService mdds=new ModernDramaDetialsServiceImpl();
			result=mdds.modernDramaDetialsRequest(request);
			System.out.println("ModernDramaDetials result :" +result);
			logger.info("ModernDramaDetials result :" +result);
			break;
		case "301"://美食列表
//			DeliciousListController deliciousListController = new DeliciousListController();
//			deliciousListController.doPost(req, resp);
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			System.out.println("DeliciousList request p:" +request);
			logger.info("DeliciousList request p:" +request);
			//获取处理结果
			DeliciousListService dls=new DeliciousListServiceImpl();
			result=dls.deliciousListRequest(request);
			System.out.println("DeliciousList result :" +result);
			logger.info("DeliciousList result :" +result);
			break;
		case "302"://美食细节
//			DeliciousDetialsController deliciousDetialsController = new DeliciousDetialsController();
//			deliciousDetialsController.doPost(req, resp);
			request =new HashMap<String,Object>();
			request.put("cmd", Integer.parseInt(req.getParameter("cmd")));
			request.put("mid", req.getParameter("mid"));
			System.out.println("DeliciousDetials request p:" +request);
			logger.info("DeliciousDetials request p:" +request);
			//获取处理结果
			DeliciousDetialsService dds=new DeliciousDetialsServiceImpl();
			result=dds.deliciousDetialsRequest(request);
			System.out.println("DeliciousDetials result :" +result);
			logger.info("DeliciousDetials result :" +result);
			break;
		case "303"://美食评论
//			DeliciousCommentController deliciousCommentController = new DeliciousCommentController();
//			deliciousCommentController.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			request.put("mid", req.getParameter("mid"));
			request.put("type", 2);
			System.out.println("DeliciousComment request p:" +request);
			logger.info("DeliciousComment request p:" +request);
			//获取处理结果
			DeliciousCommentService dcs=new DeliciousCommentServiceImpl();
			result=dcs.deliciousCommentRequest(request);
			System.out.println("DeliciousComment result :" +result);
			logger.info("DeliciousComment result :" +result);
			break;
		case "304"://美食评论提交
//			DeliciousCommentSubmitComtroller deliciousCommentSubmitComtroller = new DeliciousCommentSubmitComtroller();
//			deliciousCommentSubmitComtroller.doPost(req, resp);
			//获取请求数据
			request =new HashMap<String,Object>();
			request.put("cmd", req.getParameter("cmd"));
			request.put("mid", req.getParameter("mid"));
			request.put("type", 2);
			request.put("content", req.getParameter("content"));
			request.put("username", req.getParameter("username"));
			System.out.println("DeliciousCommentSubmit request p:" +request);
			logger.info("DeliciousCommentSubmit request p:" +request);
			//获取处理结果
			DeliciousCommentSubmitService dcss=new DeliciousCommentSubmitServiceImpl();
			result=dcss.deliciousCommentSubmitRequest(request);
			System.out.println("DeliciousCommentSubmit result :" +result);
			logger.info("DeliciousCommentSubmit result :" +result);
			break;
		default:
			break;
		}
		//提交处理结果
		PrintWriter out =resp.getWriter();
		out.write(result);
		out.flush();
		out.close();

	}

}
