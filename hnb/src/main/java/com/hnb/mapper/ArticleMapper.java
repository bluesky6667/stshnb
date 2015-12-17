package com.hnb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;

@Repository
public interface ArticleMapper {
	// C : 추가(회원가입)
	public int write(ArticleVO article);
	
	// R : 조회
	public List<ArticleVO> getList(Command command); //전체회원목록
	public List<ArticleVO> searchByKeyword(Command command); //임의의 값으로 검색
	public ArticleVO searchById(int rcdNo); //아이디로 조회
	public String getArticlePass(int rcdNo); // 글 비번 조회
	public int count(); //전체회원수 조회
	public int countByKeyword(Command command); //전체회원수 조회
	
	// U : 개인정보 변경
	public int changeRcdNo(ArticleVO article);
	public int changeContent(ArticleVO article);
	
	// D : 삭제 (회원탈퇴)
	public int remove(int rcdNo);
}
