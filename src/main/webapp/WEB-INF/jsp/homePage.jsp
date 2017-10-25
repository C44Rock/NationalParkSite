<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="formInput" value="/"/>
<form action="${formInput}" method="POST">
	<label for="degreeUnit">Degree Unit:</label>
	F:<input type="radio" name="degreeUnit" value="F">
	C:<input type="radio" name="degreeUnit" value="C">
	<input type="submit" value="Submit">
</form>

<c:forEach var="park" items="${parkList}">

<section>
	<c:url var="imageUrl" value="/img/parks/${park.image}.jpg"/>
	<c:url var="detailPage" value="/parkDetail">
		<c:param value = "${park.parkCode}" name = "parkCode"/>
	</c:url>
	
    <a href="${detailPage}"><img src="${imageUrl}" /></a>
    	<h1>${park.name}</h1>
    <h3>${park.location}</h3>
	<p>${park.summary}</p>
</section>

</c:forEach>

</body>
</html>