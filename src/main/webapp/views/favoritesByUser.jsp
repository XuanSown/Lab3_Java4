<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video yêu thích</title>
</head>
<body>

	<form action="favorites-by-use" method="get">
		Nhập fullname:
		<input type="text" name="fullname" value="${param.fullname}">
		<button type="submit">Tìm kiếm</button>
	</form>
	<hr>
	<c:if test="${not empty user}">
		<h1>${user.fullname}</h1>
		<h3>Các video đã yêu thích</h3>
		
		<c:choose>
			<c:when test="${not empty user.favorites}">
				<ul>
					<c:forEach var="fav" items="${user.favorites}">
						<li>${fav.video.title}</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p>Người dùng này chưa thích video nào</p>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<c:if test="${empty user}">
		<p>Không tìm thấy người dùng hoặc chưa tìm kiếm!</p>
	</c:if>
</body>
</html>