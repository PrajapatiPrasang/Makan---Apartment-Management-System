<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page import="VO.addAppointmentVO"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/user/">
<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="Residency theme">
		<meta name="keywords" content="Residency,sale,buy,rent,pg,house,villa,apartment">
		<meta name="author" content="Fortune Creations">
		<meta name="viewport" content="width=device-width">


<title>View Bill</title>

		<link rel="stylesheet" href="css/font-awesome.min.css">
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	
</head>
<body class="page-body page-fade gray"
	data-url="http://demo.neontheme.com">

	<div class="page-container">
		
<%
		
		if(session.getAttribute("type")==null){
	%>
			<%@include file="header.jsp" %>
	<%} 
		else if(session.getAttribute("type")!= null && session.getAttribute("type").equals("resident")){%>
			<%@include file="header1.jsp" %>
			<%}
		else if(session.getAttribute("type")!=null && session.getAttribute("type").equals("admin")){
			response.sendRedirect("../admin/index.jsp");
		}
			%>
<%
String error=(String)request.getAttribute("error");
if(error != null){
out.print("<p style='background-color:red; font-size:24px; color:white'><b>"+error +"</b></p>");
} %>
       		 
		<div class="main-content">
		
	<c:forEach items="${sessionScope.list_of_all_payment }" var="x">
	<br><br><br><br>
			<div align="center">
			<h4 align="left">Your Pending Bill is</h4>
			</div>
			<br>
			<div class="panel-body">
				
				<form class="form-horizontal form-groups-bordered" action="<%=request.getContextPath()%>/paymentController?flag=pay" method="post" role="form">
					
					<input type="hidden" name="payment_id" value="${x.payment_id }">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							First Name</label>
						<div class="col-sm-5">
							<input type="text" disabled="disabled" placeholder="Enter First Name" name="firstname" class="form-control" value="${x.addResidentVO.first_name }">
						</div></div>
						
						<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							Last Name</label>
						<div class="col-sm-5">
							<input type="text" disabled="disabled" placeholder="Enter Last Name" name="lastname" class="form-control" value="${x.addResidentVO.last_name }">
						</div></div>
						
						
						<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							Address</label>
						<div class="col-sm-5">
							<textarea disabled="disabled" class="form-control">${x.addApartmentVO.address }</textarea>
						</div></div>
						
						<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							Bill Amount</label>
						<div class="col-sm-5">
							<input disabled="disabled" type="text" placeholder="Enter Last Name" name="lastname" class="form-control" value="${x.addApartmentVO.price }">
						</div></div>
						
							<input type="hidden" name="firstname" value="${x.addResidentVO.first_name }"> 
							<input type="hidden" name="lastname" value="${x.addResidentVO.last_name }"> 
							<input type="hidden" name="emailId" value="${x.addResidentVO.email_id }"> 
							<input type="hidden" name="phoneNo" value="${x.addResidentVO.phone_no }"> 
							<input type="hidden" name="rent" value="${x.addApartmentVO.price }"> 
						
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<button class="btn btn-primary" type="submit" >Pay Now</button>
							
						</div>
					</div>
				</form>
				
			</div>
			
			</c:forEach>
			
			<br><br><br><br><br><br><br><br><br>
    <footer>
			<div class="footer">
				<span class="footer_copyright_text">Copyright 2017.All Rights Reserved by Makan  </span>
			</div> 
		</footer>
			
			<script type="text/javascript">
				jQuery(document)
						.ready(
								function($) {
									// Sample Toastr Notification
									setTimeout(
											function() {
												var opts = {
													"closeButton" : true,
													"debug" : false,
													"positionClass" : rtl()
															|| public_vars.$pageContainer
																	.hasClass('right-sidebar') ? "toast-top-left"
															: "toast-top-right",
													"toastClass" : "black",
													"onclick" : null,
													"showDuration" : "300",
													"hideDuration" : "1000",
													"timeOut" : "5000",
													"extendedTimeOut" : "1000",
													"showEasing" : "swing",
													"hideEasing" : "linear",
													"showMethod" : "fadeIn",
													"hideMethod" : "fadeOut"
												};

											}, 3000);
									// Sparkline Charts
									$(".top-apps").sparkline('html', {
										type : 'line',
										width : '50px',
										height : '15px',
										lineColor : '#ff4e50',
										fillColor : '',
										lineWidth : 2,
										spotColor : '#a9282a',
										minSpotColor : '#a9282a',
										maxSpotColor : '#a9282a',
										highlightSpotColor : '#a9282a',
										highlightLineColor : '#f4c3c4',
										spotRadius : 2,
										drawNormalOnTop : true
									});
									$(".monthly-sales").sparkline(
											[ 1, 5, 6, 7, 10, 12, 16, 11, 9,
													8.9, 8.7, 7, 8, 7, 6, 5.6,
													5, 7, 5, 4, 5, 6, 7, 8, 6,
													7, 6, 3, 2 ], {
												type : 'bar',
												barColor : '#ff4e50',
												height : '55px',
												width : '100%',
												barWidth : 8,
												barSpacing : 1
											});
									$(".pie-chart").sparkline(
											[ 2.5, 3, 2 ],
											{
												type : 'pie',
												width : '95',
												height : '95',
												sliceColors : [ '#ff4e50',
														'#db3739', '#a9282a' ]
											});

									$(".daily-visitors")
											.sparkline(
													[ 1, 5, 5.5, 5.4, 5.8, 6,
															8, 9, 13, 12, 10,
															11.5, 9, 8, 5, 8, 9 ],
													{
														type : 'line',
														width : '100%',
														height : '55',
														lineColor : '#ff4e50',
														fillColor : '#ffd2d3',
														lineWidth : 2,
														spotColor : '#a9282a',
														minSpotColor : '#a9282a',
														maxSpotColor : '#a9282a',
														highlightSpotColor : '#a9282a',
														highlightLineColor : '#f4c3c4',
														spotRadius : 2,
														drawNormalOnTop : true
													});

									$(".stock-market").sparkline(
											[ 1, 5, 6, 7, 10, 12, 16, 11, 9,
													8.9, 8.7, 7, 8, 7, 6, 5.6,
													5, 7, 5 ], {
												type : 'line',
												width : '100%',
												height : '55',
												lineColor : '#ff4e50',
												fillColor : '',
												lineWidth : 2,
												spotColor : '#a9282a',
												minSpotColor : '#a9282a',
												maxSpotColor : '#a9282a',
												highlightSpotColor : '#a9282a',
												highlightLineColor : '#f4c3c4',
												spotRadius : 2,
												drawNormalOnTop : true
											});

									$("#calendar").fullCalendar({
										header : {
											left : '',
											right : '',
										},
										firstDay : 1,
										height : 200,
									});
								});

				function getRandomInt(min, max) {
					return Math.floor(Math.random() * (max - min + 1)) + min;
				}
			</script>

			<br />

			
		</div>



	</div>
	<!-- Imported styles on this page -->
	<script src="js/jquery-2.1.4.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="http://maps.googleapis.com/maps/api/js"></script>
		<script src="js/google-map.js"></script>
		<script src="js/slider.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/formsubmit.js"></script>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-28991003-7' ]);
		_gaq.push([ '_setDomainName', 'demo.neontheme.com' ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
</html>