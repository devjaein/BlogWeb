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
	<jsp:include page="./fragments/main_header.jsp"></jsp:include>
	<div class="main">
		<div class="left">
<c:forEach var = "post" items="${postList }">
			<a href="#">${post.title }</a> <a href="#">EDIT</a> / <a href="#">DEL</a>
			<br>
			<h6>${post.createdDate }</h6>
			<h6>${post.content }</h6>
			<a>posted by ${post.postId }</a>
</c:forEach>  
		</div>
		<div class="right">
			<a href="loginView.do">로그인</a> <a href="logout.do">로그아웃</a> <a href="blogadmin.do">블로그 관리</a> <br>
			<img alt="j2logo" src="/images/j2eelogo.jpg"> <br>
			<h5>카테고리</h5>
			<c:forEach var = "category" items="${categoryList }">
				<h6>"${category.categoryName }</h6>
			</c:forEach>
			<br> <img alt="logo" src="/images/logo.jpg">
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="./fragments/footer.jsp"></jsp:include>
</body>
</html>