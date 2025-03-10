<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<c:choose>

		<c:when test="${!empty jsInfo}">
			<h1 style="color: red; text-align: center;">JobSeeker Report</h1>
			<table border="1" bgcolor="cyan" align="center">
				<tr>
					<th>JsId</th>
					<th>JsName</th>
					<th>JsAddress</th>
					<th>Qualification</th>
					<th>download photo</th>
					<th>download resume</th>
				</tr>
				<c:forEach var="js" items="${jsInfo}">
					<tr>
						<td>${js.jsId}</td>
						<td>${js.jsName}</td>
						<td>${js.jsAddrs}</td>
						<td>${js.jsQlfy}</td>
						<td><a href="download?id=${js.jsId}&type=photo">download</a></td>
						<td><a href="download?id=${js.jsId}&type=resume">download</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center;">Records not found</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>