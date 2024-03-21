<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/day0320_board/board" method="post">
		제목 : <input type="text" name="title"><br>
		내용 : <textarea rows="10" cols="20" name="content"></textarea><br>
		<input type="hidden" name="action" value="write">
		<input type="submit" value="작성완료">
	</form>
</body>
</html>