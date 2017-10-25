<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<section>
	<c:url var="imageUrl" value="/img/parks/${param.parkCode.toLowerCase()}.jpg"/>
	
    <a href="${detailPage}"><img src="${imageUrl}" /></a>
    	<h1>${park.name}</h1>
 
	<p>${thisPark.summary}</p>
	<p>Location: ${thisPark.location}</p>
	<p>Acreage: ${thisPark.size}</p>
	<p>Elevation: ${thisPark.elevation}</p>
	<p>Total Trail Length: ${thisPark.trailLength}</p>
	<p>Number of Campsites: ${thisPark.campsiteNumber}</p>
	<p>Climate: ${thisPark.climate}</p>
	<p>Founded: ${thisPark.yearFounded}</p>
	<p>Number of Annual Visitors: ${thisPark.visitorCount}</p>
	<p>Inspirational Quote: ${thisPark.quote}</p>
	<p>Source of Quote: ${thisPark.quoteSource}</p>
	<p>Cost of Entry: ${thisPark.entryFee}</p>
	<p>Number of Species: ${thisPark.speciesCount}</p>
</section>

<section>
	<c:forEach var="dailyForecast" items="${weeklyForecast}">
		<table>
			<tr>
				<td>
				<c:url var="weatherImage" value="/img/weather/${dailyForecast.forecast}.png"/>
				
				<img src="${weatherImage}"/>
				High: "${dailyForecast.highTemp}"<br>
				Low: "${dailyForecast.lowTemp}"<br>
				Suggestions: "${dailyForecast.makeRecommendation()}"<br>
				</td>
			</tr>
		</table>
	
	</c:forEach>
</section>


</body>
</html>