<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id = "boardList">
<TABLE id="tab_title">
	<TR BGCOLOR=#A0A0A0>
		<TD ALIGN=CENTER><FONT SIZE=4><B>자유게시판</B></FONT></TD>
	</TR>
</TABLE>
<TABLE id="tab_boardList">
	
</TABLE>
</div>
<script type="text/javascript">
	$(function() {
		board.init();
	});
	var board = {
		init : function() {
			$.getJSON(context+"/event/boardList/1",function(data){
				var table = '<TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD><TD WIDTH=40%><B>제목</B></TD><TD WIDTH=20%><B>작성자</B></TD><TD WIDTH=20%><B>작성일</B></TD><TD WIDTH=8%><B>참조</B></TD></TR>'
				+'<c:forEach var="member" items="${memberList}" varStatus="status">'
				+'<TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD><TD WIDTH=20% ALIGN=CENTER>${member.id}</TD>'
				+'<TD WIDTH=20% ALIGN=CENTER><A HREF="BoardContent.jsp">${member.name}</A></TD><TD WIDTH=30% ALIGN=LEFT>${member.email}</TD>'
				+'<TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR></c:forEach>';
				$('#tab_boardList').empty();
				$('#tab_boardList').html(table);
			});
		}
	}
</script>