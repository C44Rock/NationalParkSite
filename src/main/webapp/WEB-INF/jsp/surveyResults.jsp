<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h1>The most popular parks!</h1>


<section>
	<c:forEach var="park" items="${popularParks}">
		<table>
		<tr>
		<td>
		<c:url var="imageUrl" value="/img/parks/${park.image}.jpg"/>
				
				<img src="${imageUrl}" width="200" height="200"/></td>
		<td><p>${park.name}: </p></td>
		<td><p>${park.surveyCount} Vote(s)</p></td>
		
		</tr>
		
		</table>
	
	</c:forEach>
</section>

<hr>  
<br>