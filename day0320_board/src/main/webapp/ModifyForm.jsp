<%@page import="model.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
	<h2>수정 페이지</h2>
	<% BoardDTO dto = (BoardDTO)request.getAttribute("detail"); %>
	
	<form action="/day0320_board/board">
		<input type="hidden" name="action" value="modify">
		<input type="hidden" name="bno" value="<%=dto.getBno()%>">
		
		제목: <input type="text" name="title" value="<%=dto.getTitle() %>"><br>
		내용: <textarea rows="10" cols="20" name="content"><%=dto.getContent() %></textarea><br> 
		
		<input type="submit" value="글 수정"><br>
	</form>
	<a href="/day0320_board/board?action=list">[ 목록 ]</a>
</body>
</html>