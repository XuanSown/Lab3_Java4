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
		<p>Không tìm thấy người dùng</p>
	</c:if>
</body>
</html>