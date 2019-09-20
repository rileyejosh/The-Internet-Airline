<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help/Information</title>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.myLink {display: none}
</style>
</head>
<body>

<!-- Navigation Bar -->
<div class="w3-bar w3-border w3-light-grey w3-center">
  <a href="${pageContext.request.contextPath}/AirlineApp/index.jsp" style="width:25%" class="w3-bar-item w3-button w3-mobile">Start Over</a>
  <a href="${pageContext.request.contextPath}/AirlineApp/greatdeals.jsp" style="width:25%" class="w3-bar-item w3-button w3-mobile">Great Deals</a>
  <a href="${pageContext.request.contextPath}/AirlineApp/help.jsp" style="width:25%" class="w3-bar-item w3-button w3-mobile">Help/Information</a>
  <a href="${pageContext.request.contextPath}/AirlineApp/contact.jsp" style="width:25%" class="w3-bar-item w3-button w3-mobile">Contact Us</a>
</div>

<!-- Help -->
 <div class="w3-container w3-margin-center">
    <h3>Welcome to the Internet Airline!</h3>
    <h5>The Internet Airline is a convenient and easy-to-use web application for buying airline tickets at affordable prices.</h5>
    <h5><a href="${pageContext.request.contextPath}/AirlineApp/rules.jsp">View Rules</a></h5>
    <h5><a href="${pageContext.request.contextPath}/AirlineApp/contact.jsp">Display Contact Information</a></h5>
  </div>

  
</body>
</html>