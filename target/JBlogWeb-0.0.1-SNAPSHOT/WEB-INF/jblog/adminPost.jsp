<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/theme.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>임시</title>
</head>
<body>
<!-- header -->
	<jsp:include page="./fragments/header.jsp"></jsp:include>
	<div class="main">
		<div class="left">
			<a href = "blogadmin.do">기본설정</a>
			<a href = "blogadmin_categoryView.do">카테고리</a>
			<a href = "blogadmin_postView.do">글 작성</a>
		</div>
	<form action = "postInsert.do" mehtod = "post">
	<input type = "hidden" name = "categoryId" value = "${category.categoryId }"> 
	제목 : <input type="text" name="cntDisplayPost" size="64">
	<br><br><br>
	내용 : <textarea name="content" cols="55" rows="5"> </textarea>
	<input type="submit" value="확인">
	</form>
	</div>
<!-- footer -->
	<jsp:include page="./fragments/footer.jsp"></jsp:include>
</body>
</html>