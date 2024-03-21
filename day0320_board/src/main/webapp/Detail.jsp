<%@page import="model.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h2>게시판 글 세부사항 페이지</h2>
	<% BoardDTO dto = (BoardDTO)request.getAttribute("detail"); %>
	제목: <%=dto.getTitle() %><br>
	작성자: <%=dto.getWriter() %><br>
	내용: <%=dto.getContent() %><br>
	작성날짜: <%=dto.getWriteDate() %><br>
	조회수: <%=dto.getReadCount() %><br>
	<form action="/day0320_board/board">
		<input type="hidden" name="action" value="delete">
		<input type="hidden" name="bno" value="<%=dto.getBno()%>">
		<input type="submit" value="글 삭제">
	</form>
	<form action="/day0320_board/board">
		<input type="hidden" name="action" value="modifyForm">
		<input type="hidden" name="bno" value="<%=dto.getBno()%>">
		<input type="submit" value="글 수정"><br>
	</form>
	<a href="/day0320_board/board?action=list">[ 목록 ]</a>
</body>
</html>