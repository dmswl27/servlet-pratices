<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>scope(객체의 범위)</h1>
	${vo.no }<br/>
	${vo.name }<br/>
	
	=========<br/>
	${sessionScope.vo.no }<br/>
	${sessionScope.vo.name }<br/>
</body>
</html>