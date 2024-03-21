<%@page import="model.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<%
	// BoardServlet 쪽에서 setAttribute 했던 데이터 받아라.
	Map<String, Object> pageInfo = 
		(Map<String, Object>) request.getAttribute("pageInfo");
%>
	<h2>SSAFY 대전 8반 게시판입니다.</h2>
	<table border="1">
		<tr>
			<th>bno.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
		<%if(pageInfo==null || 
			pageInfo.get("boardList")==null || 
			((List<BoardDTO>)pageInfo.get("boardList")).size()==0){ %>
			<tr>
				<td colspan="5">작성된 게시글이 없습니다. 게시글을 작성해보세요</td>
			</tr>
		<%}else{%>
			<%for(BoardDTO b: (List<BoardDTO>)pageInfo.get("boardList")) {%>
			<tr>
				<td><%=b.getBno() %></td>
				<td><a href="/day0320_board/board?action=detail&bno=<%=b.getBno()%>"><%=b.getTitle() %></a></td>
				<td><%=b.getWriter() %></td>
				<td><%=b.getWriteDate() %></td>
				<td><%=b.getReadCount() %></td>
			</tr>
			<%}%>
		<%}%>
	</table>
	
	<div>
		<%for(int p=(int)pageInfo.get("startPage"); p<=(int)pageInfo.get("endPage"); p++){ %>
			<a href="/day0320_board/board?action=list&page=<%=p%>"> <%=p%> </a>
		<%}%>
	</div>
	
	<a href="/day0320_board/board?action=writeForm">[글쓰러 가기]</a><a href="/day0320_board/">[ 메인 페이지 ]</a>
</body>
</html>


