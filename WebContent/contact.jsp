<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Contact</title>
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

  <!-- Contact -->
  <div class="w3-container">
    <h2>Contact</h2>
    <p>Let us book your next trip!</p>
    <i class="fa fa-map-marker" style="width:30px"></i> Chicago, US<br>
    <i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515<br>
    <i class="fa fa-envelope" style="width:30px"> </i> Email: db-inc@pnw.com<br>
    <form action="/action_page.php" target="_blank">
      <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Email" required name="Email"></p>
      <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Message" required name="Message"></p>
      <p><button class="w3-button w3-black w3-padding-large" type="submit">SEND MESSAGE</button></p>
    </form>
  </div>

</body>
</html>