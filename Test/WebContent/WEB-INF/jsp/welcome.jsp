<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home Page</title>
</head>

<body>
	<table>
		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>GENRE</th>
		</tr>
		<c:forEach var="movie" items="${movie}" varStatus="loop">
			<tr>
				<td>${movie.id}</td>
				<td>${movie.title}</td>
				<td>${movie.genre}</td>
			</tr>
		</c:forEach>
	</table>
	<%-- ${ movie[0].title } --%>
</body>


</html>