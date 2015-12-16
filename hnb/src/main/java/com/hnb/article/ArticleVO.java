package com.hnb.article;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ArticleVO implements Serializable {
	private static final long serialVersionUID = 1L;
	int rcdNo;			// 글 번호
	int grpNo;			// 글 그룹 번호
	String usrName;		// 작성자 이름
	String usrMail;		// 작성자 이메일
	String usrSubject;	// 글 제목
	String usrContent;	// 글 내용
	String usrPass;		// 글 비번
	String usrFileName;	// 업로드 되는 파일 이름
	int usrFileSize;	// 업로드 되는 파일 크기
	String usrDate;		// 작성일
	int usrRefer;		// 글 참조 횟수
	int usrLevel;		// 글 레벨
	int usrOrder;		// 글 그룹에서 글의 출력순서
	public int getRcdNo() {
		return rcdNo;
	}
	public int getGrpNo() {
		return grpNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public String getUsrMail() {
		return usrMail;
	}
	public String getUsrSubject() {
		return usrSubject;
	}
	public String getUsrContent() {
		return usrContent;
	}
	public String getUsrPass() {
		return usrPass;
	}
	public String getUsrFileName() {
		return usrFileName;
	}
	public int getUsrFileSize() {
		return usrFileSize;
	}
	public String getUsrDate() {
		return usrDate;
	}
	public int getUsrRefer() {
		return usrRefer;
	}
	public int getUsrLevel() {
		return usrLevel;
	}
	public int getUsrOrder() {
		return usrOrder;
	}
	public void setRcdNo(int rcdNo) {
		this.rcdNo = rcdNo;
	}
	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}
	public void setUsrSubject(String usrSubject) {
		this.usrSubject = usrSubject;
	}
	public void setUsrContent(String usrContent) {
		this.usrContent = usrContent;
	}
	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}
	public void setUsrFileName(String usrFileName) {
		this.usrFileName = usrFileName;
	}
	public void setUsrFileSize(int usrFileSize) {
		this.usrFileSize = usrFileSize;
	}
	public void setUsrDate(String usrDate) {
		this.usrDate = usrDate;
	}
	public void setUsrRefer(int usrRefer) {
		this.usrRefer = usrRefer;
	}
	public void setUsrLevel(int usrLevel) {
		this.usrLevel = usrLevel;
	}
	public void setUsrOrder(int usrOrder) {
		this.usrOrder = usrOrder;
	}

	
}
