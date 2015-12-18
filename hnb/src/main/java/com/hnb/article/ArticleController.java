package com.hnb.article;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired ArticleVO article;
	@Autowired ArticleServiceImpl articleService;
	
	// RESTful 방식 (url에 {} 이 있어서 @PathVariable 사용한 경우)
	@RequestMapping("/list/{themeNo}/{pageNo}")
	public @ResponseBody List<ArticleVO> getList(
			@PathVariable("themeNo")String themeNo,
			@PathVariable("pageNo")String pageNo,
			Model model){
		logger.info("ArticleController-getList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		logger.info("넘어온 테마 번호 : {}",themeNo);
		List<ArticleVO> list = articleService.getList(CommandFactory.boardList(pageNo,themeNo));
		logger.info("리스트 수 : {}",list.size());
		/*model.addAttribute("memberList",list);
		model.addAttribute("count", memberService.count());
		model.addAttribute("pageNo", pageNo);
		logger.info("멤버리스트 조회결과 : {}", list);*/
		return list;
	}
	@RequestMapping("/list")
	public String goList(){
		logger.info("ArticleController-goList() 진입");
		return "article/list.tiles";
	}
	@RequestMapping("/write")
	public String write(){
		logger.info("ArticleController-write() 진입");
		return "article/write.jsp";
	}
	@RequestMapping("/save")
	public String save(
			@RequestBody ArticleVO article){
		logger.info("ArticleController-save() 진입");
		return "article/save.jsp";
	}
}
