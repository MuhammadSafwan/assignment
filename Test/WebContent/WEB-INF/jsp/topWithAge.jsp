<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Done</title>
</head>

<body>
	<table>
	
	<%-- <tr>
		<td>Enter Team Name or ID</td>
		<form:form method="post" commandName="searchMovie">
			<td><form:input id="teamName" path="teamName"/></td>
			<td><button type="submit">Search</button></td>
	</form:form>
	</tr> --%>
	
		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>AVG RATING</th>
			<th>VOTES</th>
		</tr>
		<c:forEach var="movie" items="${movie}" varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<%-- <td>${movie[0]}</td> --%>
				<td>${movie[1]}</td>
				<td>${movie[2]}</td>
				<td>${movie[3]}</td>
			</tr>
		</c:forEach>
	</table>
	<%-- ${ movie[0].title } --%>
</body>


</html>