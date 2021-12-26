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
	<center>	
	<table border="1" cellpadding="0" cellspacing="0" width="90%">
		<tr>
			<tr>
				<th width="100">번호</th>
				<th width="200">카테고리명</th>
				<th width="150">보이기 유형</th>
				<th width="150">포스트 수</th>
				<th width="100">설명</th>
				<th width="100">삭제</th>
			</tr>
		</tr>
		<c:forEach var="category" items="${categoryList }">
			<tr>
				<td align="center">${category.categoryId }<td>
				<td align="center"><a href = "updateCategory.do?blogId=${blog.BLOG_ID }">${category.categoryName }</a></td>
				<td align="center">${category.displayType }</td>
				<td align="center">${category.cntDisplayPost }</td>
				<td align="center">${category.description }</td>
				<td align="center">${catego }
				<!-- <td align="center">삭제 불가</td> -->
			</tr>
		</c:forEach>
	</table>
	</center>
	<div class="left">
			<h5>카테고리 추가</h5>
	</div>
	<form action="insertCategory" method="post">
	<table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
	<tbody class="category_table">			
	<tr>
	<td height="20" colspan="10" class="tdcontent">
		카테고리명 : <input type="text" name="categotyName" size="20",  value = "${category.categoryName }">
	</td>
	</tr>
	<tr>
	<td height="20" colspan="10"  class="tdcontent">
	보이기 유형: 
		<input type="radio" name=categoryDisplayType value="TITLE"  checked="checked">제목 
		<input type="radio" name=categoryDisplayType value="TITLE_CONTENT">제목+내용 
	</td>
	</tr>
	<tr>
	<td height="20" colspan="10" class="tdcontent">
		포스트 수: <input type="text" name="cntDisplayPost" size="10", value = "${category.cntDisplayPost }">개(1~20)
	</td>
	</tr>
	<tr>
	<td height="20" colspan="10" class="tdcontent">
		설명 : <input type="text" name="description" size="30",  value = "${category.description }"> 
	</td>
	</tr>
	<tr>
	<td height="40" colspan="10" align="left">
	<input type="submit" value="카테고리 추가"></td>
</tr>
</tr>
</tbody>
</table>
</form>
	</div>
	<!-- footer -->
	<jsp:include page="./fragments/footer.jsp"></jsp:include>
</body>
</html>