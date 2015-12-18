<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<script type="text/javascript">
	$(function() {
		board.init('142','1');
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