package com.hnb.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.hnb.global.Constants;
import com.hnb.global.FileUpload;

@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	@Autowired MemberVO member;
	
	@RequestMapping("/admin_home")
	public String adminHome(){
		logger.info("MemberController-adminHome() 진입");
		return "member/admin_home";
	}
	@RequestMapping("/provision")
	public String provision(){
		logger.info("MemberController-provision() 진입");
		return "member/provision";
	}
	@RequestMapping("/join_member")
	public Model joinMember(
			String id,
			String password,
			String name,
			String birth,
			String addr,
			String gender,
			String email,
			String phone,
			Model model
			){
		logger.info("MemberController-joinMember() 진입");
		logger.info("id : {}", id);
		logger.info("패스워드 : {}", password);
		logger.info("이름 : {}", name);
		logger.info("생년 : {}", birth);
		logger.info("주소 : {}", addr);
		logger.info("성별 : {}", gender);
		logger.info("이메일 : {}", email);
		logger.info("전화번호 : {}", phone);
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setAddr(addr);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		int result = service.join(member);
		if (result == 1) {
			logger.info("회원가입 성공");
			model.addAttribute("result", "success");
			model.addAttribute("name", member.getName());
			logger.info("모델 : {}", model);
		} else {
			logger.info("회원가입 실패");
			model.addAttribute("result", "fail");
		}
		return model;
	}
	@RequestMapping("/join_Result")
	public String joinResult(){
		logger.info("MemberController-joinResult() 진입");
		return "member/join_Result";
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		logger.info("MemberController-logout() 진입");
		status.setComplete();
		return "redirect:/";		//바로 디테일로
	}
	@RequestMapping("/login")
	public @ResponseBody MemberVO login(
			String id,
			@RequestParam("pw") String password,
			Model model
			){
		logger.info("MemberController-login() 진입");
		member = service.login(id, password);
		model.addAttribute("user", member);
		if(member.getId().equals(id)){
			logger.info("로그인성공");
        } else {
        	logger.info("로그인실패");
            if (id.equals("choa")) {
            	model.addAttribute("admin","yes");
			} else {
				model.addAttribute("admin","no");
			}
        }
		return member;
	}
	@RequestMapping("/check_Overlap")
	public Model checkOverlap(
			String id,
			Model model
			){
		logger.info("MemberController-checkOverlap() 진입");
		if (service.selectById(id).getId() == null) {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
		} else {
			model.addAttribute("result", "unusable");
			model.addAttribute("id", id);
		}
		return model;
	}
	@RequestMapping("/mypage")
	public String myPage(){
		logger.info("MemberController-myPage() 진입");
		return "member/mypage.tiles";
	}
	@RequestMapping("/detail/{id}")
	public @ResponseBody MemberVO detail(
			@PathVariable("id")String id
			){
		logger.info("MemberController-detail() 진입");
		member = service.selectById(id);
		return member;
	}
	//포스트 방식- 리퀘스트매핑 초기화 공백없이
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody MemberVO update(
			@RequestParam(required=false,value="file")MultipartFile multipartFile,
			@RequestParam("id")String id,
			@RequestParam("password")String password,
			@RequestParam("addr")String addr,
			@RequestParam("email")String email,
			@RequestParam("phone")String phone
			){
		logger.info("MemberController-update() 진입");
		String path = Constants.imageDomain+"resources\\images\\";
		FileUpload fileUpload = new FileUpload();
		String fileName = multipartFile.getOriginalFilename();
		String fullPath = fileUpload.uploadFile(multipartFile, path, fileName);
		logger.info("파일업로드경로 : {}", fullPath);
		member.setPassword(password);
		member.setAddr(addr);
		member.setEmail(email);
		member.setPhone(phone);
		member.setProfile(fileName);
		int result = service.change(member);
		if (result==1) {
			logger.info("수정 성공");
		} else {
			logger.info("수정 실패");
		}
		return member;
	}
}
