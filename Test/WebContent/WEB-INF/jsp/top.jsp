<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Done</title>
</head>

<body>
	<table>
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