<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/theme.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>임시</title>
</head>
<body>
<jsp:include page="./fragments/header.jsp"></jsp:include>
	<div class="main">
		<div class="left_basic">
			<a href = "blogadmin.do">기본설정</a>
			<a href = "blogadmin_categoryView.do">카테고리</a>
			<a href = "blogadmin_postView.do">글 작성</a>
<form action="updateBlog.do" method="post">
<input name="blogId" type="hidden" value="${blog.blogId}" />
<table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">	

<tr>
	<td height="20" colspan="10" align="left" class="tdcontent">
		블로그 제목 : <input type="text" name="title" size="20" value="${blog.title }">
	</td>
	</tr>
	<tr>
	<td height="20" colspan="10" align="left" class="tdcontent">
		블로그 태그 : <input type="text" name="tag" size="25" value="${blog.tag }">
	</td>
	</tr>
	<tr>
	<td height="20" colspan="10" align="left" class="tdcontent">
		메인페이지 포스트 : <input type="text" name="cntDisplayPost" size="5" value="${blog.cntDisplayPost }">
	</td>
	</tr>
	<tr>
	<td height="20" colspan="10" align="left" class="tdcontent">
		로고 이미지 : <img alt="j2logo" src="/images/j2eelogo.jpg">
	</td>
	</tr>
<tr>
	<td height="40" colspan="10" align="center">
	<input type="submit" value="확인"></td>
</tr>

</table>
</form>
		</div>

	</div>
	<!-- footer -->
	<jsp:include page="./fragments/footer.jsp"></jsp:include>
</body>
</html>