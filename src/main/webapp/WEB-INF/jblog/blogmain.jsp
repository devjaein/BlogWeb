<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/theme.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<title>임시</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="./fragments/main_header.jsp"/>
	<div class="main">
		<div class="left">
<c:forEach var = "post" items="${postList }">
			<h3>${post.title }
				<c:if test="${user.userId==blog.blogId}"><a href="postUpdateView.do?postId=${post.postId}">EDIT</a> / <a href="postDelete.do?postId=${post.postId}">DEL</a></c:if></h3>
			<h6>${post.createdDate }</h6>
			<h6>${post.content }</h6>
			<a>posted by ${user.userName}</a>
</c:forEach>
		</div>
		<div class="right">
			<c:if test="${user == null}">
			<a href="loginView.do">로그인</a>
			</c:if>
			<c:if test="${user != null}">
			<a href="logout.do">로그아웃</a>
			</c:if>
			<c:if test="${user.userId == blog.blogId}">
			<a href="blogadmin.do">블로그 관리</a> <br>
			</c:if>
			<img alt="j2logo" src="/images/j2eelogo.jpg"> <br>
			<h5>카테고리</h5>
			<tr>
				<td class="categoryitem">
					<a class="title" href="blogmain.do?blogId=${blog.blogId }">전체 보기</a><br>
					<c:forEach var="category" items="${categoryList }">
						<a class="title" href="blogmain.do?blogId=${category.blogId }&categoryId=${category.categoryId }">${category.categoryName }</a><br>
					</c:forEach>
				</td>
			</tr>
			<br> <img alt="logo" src="/images/logo.jpg">
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="./fragments/footer.jsp"></jsp:include>
</body>
</html>