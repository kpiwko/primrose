<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
<title>Primrose - flower detail</title>
</head>

<body>
<p><a href="searchFlowers.do">Go back to the search form</a></p>
<c:if test="${not empty flower}">
	<table border="0">
		<tbody>
			<tr>
				<td><label>Id</label></td>
				<td><c:out value="${flower.id}" /></td>
			</tr>
			<tr>
				<td><label>Name</label></td>
				<td><c:out value="${flower.genus} ${flower.species}" /></td>
			</tr>
			<tr>
				<td><label>Location</label></td>
				<td><c:out value="${flower.location}" /></td>
			</tr>
			<tr>
				<td><label>Watering type</label></td>
				<td><c:out value="${flower.watering}" /></td>
			</tr>
			<tr>
				<td><label>Last watered</label></td>
				<td><fmt:formatDate value="${flower.lastWatered}" pattern="yyyy-MM-dd HH:mm:ss"
					type="both" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tr>
			<td><a href="waterNow.do?id=${flower.id}">Water now!</a></td>
		</tr>
	</table>
</c:if>

</body>
</html>