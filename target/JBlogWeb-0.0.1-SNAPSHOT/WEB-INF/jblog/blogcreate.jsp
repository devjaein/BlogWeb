<%-- <%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/theme.css">
<title>새글등록</title>
</head>
<body>
	<center>
		<h1>
			<img src="images/logo.jpg">
		</h1>
		<form action="insertBlog.do" method="post">
		<input name = "blogId" value = "${user.userId }" type = "hidden">
			블로그 제목 : <input name = "title" type = "text">
			<input type = "submit" value = "블로그 생성">
		</form>
		<a href="index.jsp">인덱스 페이지로 이동</a>
	</center>
</body>
</html> --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>블로그 만들기!!</title>
<Link rel="stylesheet" href="css/theme.css">
</head>
<body>
<center>
<form action="insertBlog.do" method="post">
<input name="blogId" type="hidden" value="${user.userId}"/>
<table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
<tr><td height=40 colspan="10">&nbsp;</td></tr>
<tr>
	<td width="100%" height="120" colspan="10" align="center">
		<img src="images/logo.jpg" border="0">
	</td>
</tr>
<tr>
	<td width="40%" height="20">&nbsp;</td>
	<td width="60%">블로그 생성 : <input type="text" name="title" size="65"><input type="submit" value="블로그 생성"></td>
</tr>
<tr>
	<td width="40%" height="20">&nbsp;</td>
	<td width="100%"><a href="/"><b>인덱스로 이동</b></a></td>
</tr>
</table>
</form>
</center>
</body>
</html>