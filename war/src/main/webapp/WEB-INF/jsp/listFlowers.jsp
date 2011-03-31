<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
<head>
<title>Primrose - your flowers</title>
</head>

<body>

<!-- 
<form:form commandName="userInput">

        Search accounts <form:select path="invoiceStatus"
		items="${stringList}" /> current invoice by subscriber name:<br />
	<form:input path="nameFragment" />
	<input type="submit" value="Search" />
	<br />
	<span class="displaynumber" style="font-size: 90%"> Display up
	to <form:input path="maxAccountNum" maxlength="2" size="2"
		cssStyle="font-size:90%" /> relevant accounts. </span>
</form:form>
-->

<c:if test="${(flowers ne null) and (empty flowers)}">
        Sorry no result matches...
</c:if>
<c:if test="${not empty flowers}">
	<table border="0">
		<thead>
			<tr>
				<th>#</th>
				<th>ID</th>
				<th>Subscriber name</th>
				<th>Membership</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${flowers}" var="flower" varStatus="s">
			<tr>
				<td><c:out value="${s.index}" /></td>
				<td><c:out value="${flower.id}" /></td>
				<td><c:out value="${flower.genus} ${flower.species}" /></td>
				<td><a href='accountDetail.do?id=<c:out value="${flower.id}"/>'>Detail</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>