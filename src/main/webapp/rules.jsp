<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rules</title>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

.myLink {
	display: none
}
</style>
</head>
<body>

	<!-- Navigation Bar -->
	<div class="w3-bar w3-border w3-light-grey w3-center">
		<a href="${pageContext.request.contextPath}"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Start
			Over</a> <a href="${pageContext.request.contextPath}/greatdeals.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Great
			Deals</a> <a href="${pageContext.request.contextPath}/help.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Help/Information</a>
		<a href="${pageContext.request.contextPath}/contact.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Contact
			Us</a>
	</div>
	<c:if test="${not empty sessionScope.username}">
    Welcome, <c:out value="${sessionScope.username}" />!
    
    <%--<a href="${pageContext.request.contextPath}/?action=logout">Log out</a>--%>
	</c:if>
	<!-- Help -->
	<div class="w3-container w3-margin-center">
		<h3>Guidelines to follow:</h3>

	</div>


</body>
</html>