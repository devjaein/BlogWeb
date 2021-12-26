<%@page contentType="text/html; charset=UTF-8" %>
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
<jsp:include page="./fragments/header.jsp"></jsp:include>
<div class="main">
    <div class="left">
        <a href="blogadmin.do">기본설정</a>
        <a href="blogadmin_categoryView.do">카테고리</a>
        <a href="blogadmin_postView.do">글 작성</a>
        <c:if test="${blog.status == '운영'}">
            <a href = "deleteRequest.do?blogId=${blog.blogId}">삭제요청</a>
        </c:if>
        <c:if test="${blog.status == '삭제요청'}">
            <a href = "deleteRequest.do?blogId=${blog.blogId}">운영</a>
        </c:if>
    </div>
    <center>
        <%-- 미분류 카테고리 --%>
        <c:if test="${!empty categoryList}">
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
                <c:forEach var="category" items="${categoryList}">
                    <tr>
                        <td align="center">
                                ${category.categoryId }
                        </td>
                        <c:if test="${category.categoryName == '미분류'}">
                            <td align="center">${category.categoryName}</td>
                        </c:if>
                        <c:if test="${category.categoryName != '미분류'}">
                        <td align="center"><a href="updateCategoryView.do?categoryId=${category.categoryId}&blogId=${category.blogId}">${category.categoryName }</a></td>
                        </c:if>
                        <c:if test="${category.displayType == 'TITLE'}">
                            <td align="center">제목</td>
                        </c:if>
                        <c:if test="${category.displayType == 'MIXED' }">
                            <td align="center">제목+내용</td>
                        </c:if>
                        <td align="center">${category.cntDisplayPost }</td>
                        <td align="center">${category.description }</td>
                        <c:if test="${category.categoryName == '미분류'}">
                            <td align="center">삭제 불가</td>
                        </c:if>
                        <c:if test="${category.categoryName != '미분류'}">
                            <td align="center"><a href="deleteCategory.do?categoryId=${category.categoryId}"><img src="/images/delete.jpg" alt="delete"></a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </center>
    <%--  카테고리 추가  --%>
    <c:if test="${categoryStatus == 'insert'}">
        <h5>카테고리 추가</h5>
        <form action="insertCategory.do" method="post">
            <input type="hidden" name="blogId" value="${blog.blogId}">
            <table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
                <tbody class="category_table">
                <tr>
                    <td height="20" colspan="10" class="tdcontent">
                        카테고리명 : <input type="text" name="categoryName" size="20">
                    </td>
                </tr>
                <tr>
                    <td height="20" colspan="10" class="tdcontent">
                        보이기 유형:
                        <input type="radio" name="displayType" value="TITLE" checked="checked">제목
                        <input type="radio" name="displayType" value="MIXED"> 제목+내용
                    </td>
                </tr>
                <tr>
                    <td height="20" colspan="10" class="tdcontent">
                        포스트 수: <input type="text" name="cntDisplayPost" size="10">개(1~20)
                    </td>
                </tr>
                <tr>
                    <td height="20" colspan="10" class="tdcontent">
                        설명 : <input type="text" name="description" size="30">
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
    </c:if>
    <!-- 카테고리 등록화면 종료 -->

    <!-- 카테고리 수정화면 시작 -->
    <c:if test="${categoryStatus =='update'}">
        <form action="updateCategory.do" method="post">
            <input type="hidden" name="categoryId" value="${category.categoryId }"/>
            <table width="720"  border="0" cellpadding="0" cellspacing="0">
                <tr><td height="5">&nbsp;</td></tr>
                <tr><td height="5">&nbsp;</td></tr>
                <tr><td class="tdcontent" height="5"><b>카테고리 수정</b></td></tr>
                <tr><td height="5">&nbsp;</td></tr>
                <tr>
                    <td width="150" class="inputlabel">카테고리명 :</td>
                    <td><input class="inputtext" type="text" size="40" name="categoryName" value="${category.categoryName }" ></td>
                </tr>
                <tr>
                    <td width="150" class="inputlabel">보이기 유형 :</td>
                    <td class="tdcontent">
                        <input type="radio" name="displayType" value="TITLE"  <c:if test="${category.displayType == 'TITLE' }">checked</c:if>>제목&nbsp;&nbsp;
                        <input type="radio" name="displayType" value="MIXED" <c:if test="${category.displayType == 'MIXED' }">checked</c:if>>제목+내용&nbsp;&nbsp;
                    </td>
                </tr>
                <tr>
                    <td width="150" class="inputlabel">포스트 수 :</td>
                    <td class="tdcontent"><input class="inputtext" type="text" size="4" name="cntDisplayPost" value="${category.cntDisplayPost }">개(1~20)</td>
                </tr>
                <tr>
                    <td width="150" class="inputlabel">설명 :</td>
                    <td><input class="inputtext" type="text" size="50" name="description" value="${category.description }"></td>
                </tr>
                <tr><td height="5">&nbsp;</td></tr>
                <tr>
                    <td colspan="10" align="center">&nbsp;<input type="submit" value="카테고리 수정"></td>
                </tr>
            </table>
        </form>
    </c:if>
</div>
<!-- footer -->
<jsp:include page="./fragments/footer.jsp"></jsp:include>
</body>
</html>