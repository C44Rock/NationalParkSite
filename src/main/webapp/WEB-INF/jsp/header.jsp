<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

</head>


<body>

<header>
    		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Park Geek logo" width="780" height="216" />
        </a>
        <h1>National Park Geek</h1>  
        
        
        <hr>
        <c:url value="/" var="homePage" /><a href="${homePage}">Home</a>
        <c:url value="/surveyInput" var="surveyInput" /><a href="${surveyInput}">Survey</a><br>
        <hr>  
        
</header>