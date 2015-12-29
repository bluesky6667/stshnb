<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.white-popup {
  position: relative;
  background: #FFF;
  padding: 20px;
  width: auto;
  max-width: 500px;
  margin: 20px auto;
}
</style>
<div id = "boardList">
<TABLE id="tab_title">
	<TR BGCOLOR=#A0A0A0>
		<TD ALIGN=CENTER><FONT SIZE=4><B>자유게시판</B></FONT></TD>
	</TR>
</TABLE>
<TABLE id="tab_boardList">
</TABLE>
<div style="width: 100px;margin:auto"><a href="${context}/article/write" id="dialog-modal">글쓰기</a></div>
</div>

<!-- Like so: -->
<a href="#test-popup" class="open-popup-link">Show inline popup</a>

<!-- Or like so: -->
<a href="mobile-friendly-page.html" data-mfp-src="#test-popup" class="open-popup-link">Show inline popup</a>

<div id="test-popup" class="white-popup mfp-hide">
<TABLE WIDTH=620 HEIGHT=40 BORDER=0 CELLSPACING=1 CELLPADDING=1 ALIGN=CENTER>
	<TR BGCOLOR=#A0A0A0>
		<TD ALIGN=CENTER><FONT SIZE=4><B>게시판 ( 게시글 입력 )</B></FONT></TD>
	</TR>
</TABLE>

<FORM NAME="BoardWrite" METHOD=POST ACTION="BoardWriteProc.jsp">

<TABLE WIDTH=620 BORDER=1 CELLSPACING=0 CELLPADDING=2 ALIGN=CENTER>

	<TR>
		<TD WIDTH=120 ALIGN=CENTER><B>제목</B></TD>
		<TD WIDTH=500>
			<INPUT TYPE=TEXT NAME="subject" SIZE=70>
		</TD>
	</TR>
	
	<TR>
		<TD WIDTH=120 ALIGN=CENTER><B>내용</B></TD>
		<TD WIDTH=500>
			<TEXTAREA NAME="content" COLS=70 ROWS=8></TEXTAREA>
		</TD>
	</TR>
	
	<TR>
		<TD WIDTH=120 ALIGN=CENTER><B>파일첨부</B></TD>
		<TD WIDTH=500>
			<INPUT TYPE=FILE NAME="filename" SIZE=60>
		</TD>
	</TR> 
	 
	<TR>
		<TD WIDTH=120 ALIGN=CENTER><B>패스워드</B></TD>
		<TD WIDTH=500>
			<INPUT TYPE=PASSWORD NAME="pass" SIZE=20>
		</TD>
	</TR>
	
</TABLE>

</FORM>

<TABLE WIDTH=620 HEIGHT=50 BORDER=0 CELLSPACING=1 CELLPADDING=1 ALIGN=CENTER>

	<TR ALIGN=CENTER>
		<TD WIDTH=110 ALIGN=LEFT>
			<IMG id="go_list" SRC="${img}/btn_list.gif" STYLE=CURSOR:HAND>
		</TD>
		<TD WIDTH=400 ALIGN=CENTER>		
			<IMG id="save" SRC="${img}/btn_save.gif" STYLE=CURSOR:HAND>&nbsp;&nbsp;
			<IMG SRC="${img}/btn_cancel.gif" STYLE=CURSOR:HAND>
		</TD>
		<TD WIDTH=110 ALIGN=LEFT>&nbsp;</TD>   
	</TR>
	
</TABLE>
</div>
<script type="text/javascript">
	$(function() {
		board.init('142','1');
		$('.open-popup-link').magnificPopup({
			type:'inline',
			midClick: true
			});
	});
	var board = {
		init : function(themeNo,pageNo) {
			$.getJSON(context+"/article/list/"+themeNo+"/"+pageNo,function(data){
				var table = '<TR ALIGN=CENTER><TD WIDTH=18%><B>번호</B></TD><TD WIDTH=25%><B>제목</B></TD><TD WIDTH=55%><B>내용</B></TD></TR>';
				$.each(data,function(index,value) {
					table += "<TR><TD WIDTH=18% ALIGN=CENTER>"+(index+1)+"</TD>"
					+"<TD WIDTH=25% ALIGN=CENTER>"+this.usrSubject+"</TD>"
					+"<TD WIDTH=55% ALIGN=CENTER>"+this.usrContent+"</TD>";
				});
				$('#tab_boardList').html(table);
			});
		}
	};
</script>