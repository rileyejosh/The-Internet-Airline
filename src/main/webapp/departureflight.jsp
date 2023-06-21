<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif;
}

.myLink {
	display: none;
}
</style>
<title>Departure Flight</title>
</head>
<body>

	<!-- Navigation Bar -->
	<div class="w3-bar w3-border w3-light-grey w3-center">
		<a href="${pageContext.request.contextPath}/AirlineApp/index.jsp"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Start
			Over</a> <a href="#" style="width: 25%"
			class="w3-bar-item w3-button w3-mobile">Great Deals</a> <a href="#"
			style="width: 25%" class="w3-bar-item w3-button w3-mobile">Help/Information</a>
		<a href="#" style="width: 25%" class="w3-bar-item w3-button w3-mobile">Contact
			Us</a>
	</div>

	<div class="w3-container">
		<h2>Departure Flights</h2>
		<p>Flight Results:</p>
		<form action="${pageContext.request.contextPath}/" method="post">
			<input type="hidden" name="ReturnDate" value="hiddenValue" /> 
						
			
			

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
				<c:forEach var="f" items="${df}" varStatus="status">
					
					<tr>
						<td> <input type="radio" name="flight" value="${status.index + 1}"> </td>
						<td>${f.originCity.city.isPresent() ? f.originCity.city.get().title : ''}</td>
						<td>${f.arrivalCity.city.isPresent() ? f.arrivalCity.city.get().title : ''}</td>
						<td><fmt:formatDate value="${f.flight.fdate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${f.flight.fnumber} </td>
						<td>${f.flight.available}</td>
						<td>${f.flight.classFlight}</td>
						<td>${f.flight.ftime}</td>
						<td>${f.flight.price}</td>
						
					</tr>
				</c:forEach>
			</table>
			    <input type="hidden" id="selectedFlight" name="selectedFlight" />
			
			<button class="w3-button w3-cell-middle w3-black w3-padding-large"
				type="submit" name="action" value="return" onclick="return getValue()">Submit</button>
		</form>
	</div>

	<script>
	  function getValue() {
	        var radios = document.getElementsByName('flight');
	        var selectedFlight = "";
	        for (var i = 0; i < radios.length; i++) {
	            if (radios[i].checked) {
	                var row = radios[i].parentNode.parentNode; // Get the parent <tr> element
	                var rowData = {
	                    originCity: row.cells[1].textContent,
	                    destinationCity: row.cells[2].textContent,
	                    date: row.cells[3].textContent,
	                    flightNumber: row.cells[4].textContent,
	                    available: row.cells[5].textContent,
	                    flightClass: row.cells[6].textContent,
	                    flightTime: row.cells[7].textContent,
	                    price: row.cells[8].textContent
	                };
	                selectedFlight = JSON.stringify(rowData);
	                break;
	            }
	        }
	        if (selectedFlight !== "") {
	            document.getElementById('selectedFlight').value = selectedFlight;
	            return true;
	        } else {
	            alert("Please select a flight");
	            return false;
	        }
	    }

	</script>
</body>
</html>
