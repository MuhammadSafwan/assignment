<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Movie List</title>
</head>

<body>
	<table>
<form:form id="searchMovie" name="searchMovie" method="post"
		modelAttribute="searchedAge">
		<tr>
			<td><form:select id="age" path="id" cssStyle="width:165px">
					<form:option value="0" label=" Please Select " />
					<c:forEach var="age" items="${age}" varStatus="loop">
						<form:option value="${age.id}">${age.title}</form:option>
					</c:forEach>
				</form:select></td>
				<td><button type="submit">Search</button></td>
		</tr>
</form:form>
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