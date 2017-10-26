<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

		<h1>Simple Survey</h1>
		<h4>Please Vote For Your Favorite National Park!</h4>
	<c:url value="/surveyOutput" var="surveyOutput"/>
<form method="POST" action="${surveyOutput}">
		<table>
			<tr>
				<td>
				<label for="parkCode">Park</label>
				<select name="parkCode">
					<option value="GNP">Glacier National Park</option>
					<option value="GCNP">Grand Canyon National Park</option>
					<option value="GTNP">Grand Teton National Park</option>
					<option value="MRNP">Mount Ranier National Park</option>
					<option value="GSMNP">Great Smokey Mountain National Park</option>
					<option value="ENP">Everglades National Park</option>
					<option value="YNP">Yellowstone National Park</option>
					<option value="YNP2">Yosemite National Park</option>
					<option value="CVNP">Cuyahoga Valley National Park</option>
					<option value="RMNP">Rockey Mountain National Park</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><label for="email">Email</label></td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td><label for="state">State of Residence</label></td>
				<td><input type="text" name="state"/></td>
			</tr>
				<tr>
				<td><label for="activity">Physical Activity Level:</label></td>
				</tr>
				<tr>
				<td><input type="radio" name="activity" value="inactive">Inactive</td>
				</tr>
				<tr>
				<td><input type="radio" name="activity" value="sedentary">Sedentary</td>
				</tr>
				<tr>
				<td><input type="radio" name="activity" value="active">Active</td>
				</tr>
				<tr>
				<td><input type="radio" name="activity" value="extremelyActive">Extremely Active</td>
				</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form>
	
	<hr>  
<br>