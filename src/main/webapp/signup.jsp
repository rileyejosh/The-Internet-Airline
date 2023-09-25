<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign up</title>
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

	<!-- TODO: Fix navigation bar links -->
	<!-- Navigation Bar -->
	<div class="w3-bar w3-border w3-light-grey w3-center">
		<a href="${pageContext.request.contextPath}/index.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Start
			Over</a> <a href="${pageContext.request.contextPath}/greatdeals.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Great
			Deals</a> <a href="${pageContext.request.contextPath}/help.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Help/Information</a>
		<a href="${pageContext.request.contextPath}/contact.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Contact
			Us</a>
	</div>
	<!-- Content -->
	<div style="text-align: center">
		<h1>Registration Form</h1>
		<h2>Sign up for a free account</h2>
	</div>
	<div class="centered-form">
		<form action=" " method="post">
			<table style="with: 100%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
			</table>
			<button class="w3-button w3-cell-middle w3-black w3-padding-large"
				type="submit" name="action" value="">Sign up</button>
		</form>
	</div>

</body>
</html>