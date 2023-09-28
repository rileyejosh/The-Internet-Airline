<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log in</title>
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

.error-message {
	color: red;
	text-align: center;
}

/* Center the form horizontally */
.centered-form {
	width: 400px; /* Adjust the width as needed */
	margin: 0 auto;
}

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
	background-color:;
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
	<%-- Check if errorMessage attribute is set --%>
	<%
	if (request.getAttribute("errorMessage") != null) {
	%>
	<div class="error-message">
		<%=request.getAttribute("errorMessage")%>
	</div>
	<%
	}
	%>
	<c:if test="${not empty sessionScope.username}">
    Welcome, <c:out value="${sessionScope.username}" />!
    
    <%--<a href="${pageContext.request.contextPath}/?action=logout">Log out</a>--%>
	</c:if>
	
	<!-- Content -->
	<div style="text-align: center">
		<h1>Login Form</h1>
	</div>
	<div class="centered-form">
		<form action=" " method="post" id="form">
			<table style="with: 100%">
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="username" id="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
			</table>
			<button class="w3-button w3-cell-middle w3-black w3-padding-large"
				type="submit" name="action" value="loginResult">Sign in</button>
			<p>
				Don't have an account? <a
					href="${pageContext.request.contextPath}/signup.jsp"
					style="width: 50%" class=" w3-mobile">Register here!</a>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	 <script>
		$(document).ready(function() {
			//global vars
			var form = $("#form");
			var username = $("#username");
			var password = $("#password");

			//On Submitting
			form.submit(function() {
				if (username.val().length == 0 ) {
					alert('Please enter the username');
					return false;
				} else {
					if (password.val().length == 0) {
						alert('Please enter the password');
						return false;
					}

					else
						return true;
				}
			});
		});
	</script>
</body>
</html>