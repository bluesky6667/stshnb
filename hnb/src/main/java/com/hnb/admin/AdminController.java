package com.hnb.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.article.ArticleServiceImpl;
import com.hnb.article.ArticleVO;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieServiceImpl;
import com.hnb.movie.MovieVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberVO member;
	@Autowired MemberServiceImpl memberService;
	@Autowired MovieVO movie;
	@Autowired MovieServiceImpl movieService;
	@Autowired ArticleVO article;
	@Autowired ArticleServiceImpl articleService;
	/*
	// RESTful 방식 (url에 {} 이 있어서 @PathVariable 사용한 경우)
	@RequestMapping("/memberList/{pageNo}")
	public @ResponseBody Map<String,Object> memberList(
			@PathVariable("pageNo")String pageNo,
			Model model){
		logger.info("AdminController-memberList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", memberService.getList(CommandFactory.list(pageNo)));
		map.put("count", memberService.count());
		map.put("pageNo", pageNo);
		return map;
	}
	@RequestMapping("/memberList")
	public String goList(){
		logger.info("AdminController-goList(default) 진입");
		return "admin/memberList.tiles";
	}*/
	
	@RequestMapping("/memberList/{pageNo}")
	public @ResponseBody Map<String,Object> memberList(
			@PathVariable("pageNo")String pageNo,
			Model model){
		logger.info("AdminController-memberList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		int count = memberService.count(),pageNum = Integer.parseInt(pageNo),pageSize = 5,groupSize = 3;
		int totPage = (count%pageSize==0) ? count/pageSize : count/pageSize+1;
		int startPage = pageNum -((pageNum-1)%groupSize);
		int lastPage = (startPage+groupSize-1 <= totPage) ? startPage+groupSize-1 : totPage;
		Map<String,Object> map = new HashMap<String,Object>();
		logger.info("count : {}", count);
		map.put("list", memberService.getList(CommandFactory.list(pageNo)));
		map.put("count", count);
		map.put("pageNo", pageNo);
		map.put("startPage", startPage);
		map.put("groupSize", groupSize);
		map.put("lastPage", lastPage);
		map.put("totPage", totPage);
		return map;
	}
	@RequestMapping("/main")
	public String home(){
		logger.info("AdminController-home() 진입");
		return "admin/admin/main.tiles";
	}
	
	@RequestMapping("/movie_list")
	public String movieList(){
		logger.info("AdminController-movieList() 진입");
		return "admin/movie_list";
	}

	@RequestMapping("/member_profile")
	public String memberProfile(){
		logger.info("AdminController-memberProfile() 진입");
		return "admin/member_profile";
	}
	@RequestMapping("/movie_profile")
	public String movieProfile(){
		logger.info("AdminController-movieProfile() 진입");
		return "admin/movie_profile";
	}
	@RequestMapping("/insert")
	public String insert(){
		logger.info("AdminController-insert() 진입");
		return "admin/insert";
	}
	@RequestMapping("/insert2")
	public String insert2(){
		logger.info("AdminController-insert2() 진입");
		return "admin/insert2";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("AdminController-delete() 진입");
		return "admin/delete";
	}
	
}
