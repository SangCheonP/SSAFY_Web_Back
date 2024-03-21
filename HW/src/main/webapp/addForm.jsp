<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/day0319_practice/index">
		<input type="hidden" name="action" value="add">
		<label class="noteCode">코드명</label>
		<input type="text" name="noteCode"><br>
		
		<label class="model">모델명</label>
		<input type="text" name="model"><br>
		
		<label class="price">가격</label>
		<input type="text" name="price"><br>
		
		<label class="company">제조사</label>
		<input type="text" name="company"><br>
		
		<button>추가</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>