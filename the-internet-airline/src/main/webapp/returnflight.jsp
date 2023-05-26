<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
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
<title>Return Flight</title>
</head>
<body>
	<!-- Navigation Bar -->
	<div class="w3-bar w3-border w3-light-grey w3-center">
		<a href="${pageContext.request.contextPath}/AirlineApp/index.jsp"
			style="width: 20%" class="w3-bar-item w3-button w3-mobile">Start
			Over</a> <a href="#" style="width: 20%"
			class="w3-bar-item w3-button w3-mobile">Great Deals</a> <a href="#"
			style="width: 20%" class="w3-bar-item w3-button w3-mobile">Help/Information</a>
		<a href="#" style="width: 20%" class="w3-bar-item w3-button w3-mobile">Contact
			Us</a>
	</div>

	<div class="w3-container">
		<h2>Return Flights</h2>
		<p>Flight Results:</p>
		<form action=" " method="post">
			<table class="w3-table-all">
				<tr>
					<th></th>
					<th>Origin City</th>
					<th>Destination City</th>
					<th>Date</th>
					<th>Flight Number</th>
					<th>Available</th>
					<th>Flight Class</th>
					<th>Flight Time</th>
					<th>Price</th>
				</tr>
				<c:forEach var="f" items="${rf}" varStatus="status">	
					<tr>
						<td><input type="radio" name="flight" value="${status.index + 1}"></td>
						<td>${f.depCity}</td>
						<td>${f.arrCity}</td>
						<td>${f.fdate}</td>
						<td>${f.fnumber}</td>
						<td>${f.avail}</td>
						<td>${f.classFlight}</td>
						<td>${f.ftime}</td>
						<td>${f.price}</td>

					</tr>
				</c:forEach>
				<tr>
						<td><input type="radio" name="flight" value="${status.index + 1}"></td>
						<td>No Returning Flight</td>
				</tr>
			</table>
			<button class="w3-button w3-cell-middle w3-black w3-padding-large"
				type="submit" name="action" value="return" onclick="getValue()">Submit</button>
		</form>
	</div>

	<script>
		function getValue() {
			// Get all radio buttons with the name "flight"
			var radios = document.getElementsByName('flight');

			// Loop through each radio button
			for (var i = 0; i < radios.length; i++) {
				// Check if the radio button is checked
				if (radios[i].checked) {
					// Get the value of the checked radio button
					var selectedValue = radios[i].value;
					// Do something with the selected value
					alert("You selected " + selectedValue);
					return;
				}
			}
			// If no radio button is checked
			alert("Please select a flight; otherwise, select no return flight option.");
		}
	</script>

</body>
</html>