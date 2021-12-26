<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<title>임시</title>
</head>
<body>
<div class = "header_bg">
<img style="background-image: url("/images/kubrickbgcolor.jpg");">
<center>
	<br>
	<br>
	<a id="title">${blog.title }의 블로그</a> 
	<br>
	<a id="subTitle">${category.CATEGORY_NAME }</a>
	<br>
	<br>
	<a href="/logout.do">로그아웃</a>
	<a href="blogmainView.do">내 블로그 메인</a>
</center>
</div>
</body>
</html>