<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<section>
	<c:url var="imageUrl" value="/img/parks/${param.parkCode.toLowerCase()}.jpg"/>
	
    <a href="${detailPage}"><img style="width:100%" src="${imageUrl}" /></a>
    
    	<h1>${thisPark.name}</h1>
 
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
	<table>
			<tr>
	<c:forEach var="dailyForecast" items="${weeklyForecast}">
		
				<td>
				<c:url var="weatherImage" value="/img/weather/${dailyForecast.forecast}.png"/>
				
				<img style="width:40%" src="${weatherImage}"/><br>
				<c:choose>
					<c:when test = "${degreeUnit.equals('C')}">
						High: <fmt:formatNumber type="number" pattern="##.#" value="${(dailyForecast.highTemp - 32) / 9 * 5}"/><br>
						Low: <fmt:formatNumber type="number" pattern="##.#" value="${(dailyForecast.lowTemp - 32) / 9 * 5}"/><br>
					</c:when>
					<c:otherwise>
						High: ${dailyForecast.highTemp}<br>
						Low: ${dailyForecast.lowTemp}<br>
					</c:otherwise>
				</c:choose>
				Suggestions: ${dailyForecast.makeRecommendation()}<br>
				</td>
	</c:forEach>
		</tr>
		</table>
</section>

<hr>  
<br>


</body>
</html>