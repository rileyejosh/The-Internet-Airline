<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* Style inputs */
  input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

/* Style the submit button */
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* Add a background color to the submit button on mouse-over */
input[type=submit]:hover {
  background-color: #45a049;
}
</style>
</head>
<body>

<!-- Navigation Bar -->
<div class="w3-bar w3-border w3-light-grey w3-center">
  <a href="/index.jsp" style="width:20%" class="w3-bar-item w3-button w3-mobile">Home</a>
  <a href="#" style="width:20%" class="w3-bar-item w3-button w3-mobile">Start Over</a>
  <a href="#" style="width:20%" class="w3-bar-item w3-button w3-mobile">Great Deals</a>
  <a href="#" style="width:20%" class="w3-bar-item w3-button w3-mobile">Help/Information</a>
  <a href="#" style="width:20%" class="w3-bar-item w3-button w3-mobile">Contact Us</a>
</div>

<!-- Content -->
<div style="text-align:center">
<h1>Welcome to the Internet Airline!</h1>
<h2>Travel with us.</h2>
</div>

<form action="/index.jsp" method="post">
  <label for="city">Origin City</label>
  <select name="city">
 	   <c:forEach items="${listCity}" var="city">
             <option value="${city.id}">
                  <c:if test="${city.id eq selectedCityId}">selected="selected"</c:if>
                    ${city.title}
             </option>
       </c:forEach>
  </select>
  
   <label for="city">Destination City</label>
  <select name="city">
 	   <c:forEach items="${listCity}" var="city">
             <option value="${city.id}">
                  <c:if test="${city.id eq selectedCityId}">selected="selected"</c:if>
                    
                    ${city.title}
             </option>
       </c:forEach>
  </select>

  <label for="date">Departure Date</label>
  <select name="date">
 
  </select>
  
  <label for="date">Return Date</label>
  <select name="date">

  </select>

  <input type="submit" value="Submit">
</form>
</body>
</html>