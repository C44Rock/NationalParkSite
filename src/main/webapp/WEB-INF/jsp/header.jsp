<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

</head>


<body>

<header>
    		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Park Geek logo" />
        </a>
        <h1>National Park Geek</h1>    
        
</header>