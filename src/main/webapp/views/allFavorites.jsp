<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Video yêu thích</title>
<style>
table {
	width: 80%;
	border-collapse: collapse;
	margin: 20px auto;
	font-family: Arial, sans-serif;
}

th, td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: left;
}

th {
	background-color: #f4f4f4;
	color: #333;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}

h1 {
	text-align: center;
	color: #444;
}
</style>
</head>
<body>
	<h1>Danh sách Video đã yêu thích</h1>
	<c:choose>
		<c:when test="${not empty favorites}">
			<table>
				<thead>
					<tr>
						<th>Video Title</th>
						<th>Người thích</th>
						<th>Ngày thích</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="fav" items="${favorites}">
						<tr>
							<td>${fav.video.title}</td>
							<td>${fav.user.fullname}</td>
							<td>
								<%-- Định dạng ngày tháng thành dd/MM/yyyy cho đẹp --%>
								<fmt:formatDate value="${fav.likeDate}" pattern="dd/MM/yyyy" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p style="text-align: center;">Chưa có video nào được yêu thích</p>
		</c:otherwise>
	</c:choose>
</body>
</html>