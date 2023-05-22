<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>Welcome to the Internet Airline!</h1>
		<h2>Travel with us.</h2>
	</div>

	<form action="" method="post">
		<label for="ocity">Origin City</label> <select name="ocity">
			<c:forEach items="${listCity}" var="ocity">
				<option value="${ocity.id}">${ocity.title}</option>
			</c:forEach>
		</select> <label for="dcity">Destination City</label> <select name="dcity">
			<c:forEach items="${listCity}" var="dcity">
				<option value="${dcity.id}">${dcity.title}</option>
			</c:forEach>
		</select> <label for="ddate">Departure Date</label> <select class="year"
			name="dyear"></select> <select class="month" name="dmonth"></select> <select
			class="day" name="dday"></select> <label for="rdate">Return
			Date</label> <select class="year" name="ryear"></select> <select class="month"
			name="rmonth"></select> <select class="day" name="rday"></select>
		<button class="w3-button w3-cell-middle w3-black w3-padding-large"
			type="submit" name="action" value="departure">Submit</button>
	</form>
	
	 <%-- TODO: Point to January --%>
	<script>
		$(document).ready(
				function() {
					const monthNames = [ "January", "February", "March",
							"April", "May", "June", "July", "August",
							"September", "October", "November", "December" ];
					var qntYears = 4;
					var selectYear = $(".year");
					var selectMonth = $(".month");
					var selectDay = $(".day");
					var currentYear = new Date().getFullYear();

					for (var y = 0; y < qntYears; y++) {
						let date = new Date(currentYear);
						var yearElem = document.createElement("option");
						yearElem.value = currentYear
						yearElem.textContent = currentYear;
						selectYear.append(yearElem);
						currentYear--;
					}
					
					for (var m = 1; m <= 12; m++) {
					    var monthElem = document.createElement("option");
					    monthElem.value = m;
					    monthElem.textContent = monthNames[m-1];
					    selectMonth.append(monthElem);
					}

					var d = new Date();
					var month = d.getMonth();
					var year = d.getFullYear();
					var day = d.getDate();

					selectYear.val(year);
					selectYear.on("change", AdjustDays);
					selectMonth.val(month);
					selectMonth.on("change", AdjustDays);

					AdjustDays();
					selectDay.val(day)

					function AdjustDays() {
						var year = selectYear.val();
						var month = parseInt(selectMonth.val()) + 1;
						selectDay.empty();

						//get the last day, so the number of days in that month
						var days = new Date(year, month, 0).getDate();

						//lets create the days of that month
						for (var d = 1; d <= days; d++) {
							var dayElem = document.createElement("option");
							dayElem.value = d;
							dayElem.textContent = d;
							selectDay.append(dayElem);
						}
					}
				});
	</script>
</body>
</html>