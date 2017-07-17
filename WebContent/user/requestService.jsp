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


<title>Service Request</title>

		<link rel="stylesheet" href="css/font-awesome.min.css">
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
</head>
<body class="page-body page-fade gray"
	data-url="http://demo.neontheme.com">
<%
		
		if(session.getAttribute("type")==null){
	
			response.sendRedirect("index.jsp");
	} 
		else if(session.getAttribute("type")!= null && session.getAttribute("type").equals("resident")){%>
			<%@include file="header1.jsp" %>
			<%}
		else if(session.getAttribute("type")!=null && session.getAttribute("type").equals("admin")){
			response.sendRedirect("../admin/index.jsp");
		}
			%>
	<div class="page-container">
<%
String error=(String)request.getAttribute("error");
if(error != null){
out.print("<p style='background-color:blue;'>"+error +"</p>");
} %>
    <div class="wrapper">
        
		 
		<div class="main-content">
		

			<div>
			<h2 align="center"><br>Request for a Service</h2></div>
			<br>
			<div class="panel-body">
				<form class="form-horizontal form-groups-bordered" action="<%=request.getContextPath()%>/requestServiceController?flag=add" method="post" role="form">
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							Service Type*</label>
						<div class="col-sm-5">
							<input type="text" placeholder="Enter type of Service" name="serviceType" class="form-control">
						</div></div>
					
					<div class="form-group">
							<label class="col-sm-3 control-label" for="field-ta">Service Description*</label>
							<div class="col-sm-5">
							<textarea placeholder="Briefly describe your problem" name="serviceDescription" class="form-control"></textarea>
							</div>
						</div>
						
						
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<button class="btn btn-primary" type="submit" >Request for Service</button>
							<button class="btn btn-primary" type="reset" >Reset</button>
						</div>
					</div>
				</form>
			</div>
			<hr />
			
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

			<!-- TS148625999514963: Xenon - Boostrap Admin Template created by Laborator / Please buy this theme and support the updates -->
			<!-- Footer -->
			<footer class="main">
				<div class="pull-right">
					<a
						href="http://themeforest.net/item/neon-bootstrap-admin-theme/6434477?ref=Laborator"
						target="_blank"> </a>
				</div>

			</footer>
		</div>



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