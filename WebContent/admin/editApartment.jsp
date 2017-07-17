<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/admin/">
<%
if(session.getAttribute("type")==null){
	response.sendRedirect("login.jsp");
}
else if(session.getAttribute("type")!= null && session.getAttribute("type").equals("resident")){
	response.sendRedirect("../user/index.jsp");
}
String error=(String)request.getAttribute("error");
if(error != null){
	out.print("<p style='background-color:green; font-size:16px; color:white'>"+error +"</p>");
}
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="Neon Admin Panel" />
<meta name="author" content="Laborator.co" />
<link rel="icon"
	href="http://demo.neontheme.com/assets/images/favicon.ico">
<title>Makan-Dashboard</title>
<link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.min.css"
	id="style-resource-1">
<link rel="stylesheet" href="css/entypo.css" id="style-resource-2">
<link rel="stylesheet"
	href="//fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic"
	id="style-resource-3">
<link rel="stylesheet" href="css/bootstrap.css" id="style-resource-4">
<link rel="stylesheet" href="css/neon-core.css" id="style-resource-5">
<link rel="stylesheet" href="css/neon-theme.css" id="style-resource-6">
<link rel="stylesheet" href="css/neon-forms.css" id="style-resource-7">
<link rel="stylesheet" href="css/custom.css" id="style-resource-8">
<script src="js/jquery-1.11.3.min.js"></script>
</head>
<body class="page-body page-fade gray"
	data-url="http://demo.neontheme.com">
	
	<div class="page-container">
		
		 <%@include file="menu.jsp" %>
		<div class="main-content">
			
			<%@include file="header.jsp" %>
			<div class="panel-body">
				<c:forEach items="${sessionScope.edit_apartments }" var="x">
				<form class="form-horizontal form-groups-bordered" action="<%=request.getContextPath()%>/addApartmentController?flag=update" method="post" role="form">
					
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-ta">No. of Bedroom*</label>
						<div class="col-sm-5">
							<input type="text" placeholder="No. of Bedroom" Name="bedroom" class="form-control" value="${x.bedroom }">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-ta">No. of Bathroom*</label>
						<div class="col-sm-5">
							<input type="text" placeholder="No. of Bathroom" Name="bathroom" class="form-control" value="${x.bathroom }">
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-ta">Amenities*</label>
						<div class="col-sm-5">
							<textarea placeholder="Enter Aminities" name="amenities" class="form-control" >${x.aminities }</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-ta">Apartment Address</label>
						<div class="col-sm-5">
							<textarea placeholder="Enter address" name="address" class="form-control">${x.address}</textarea>
						</div>
					</div>
					
						<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							City</label>
						<div class="col-sm-5">
							<input type="text" placeholder="Enter City" Name="city" value="${x.city }" class="form-control">
						</div></div>
						
						<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							State</label>
						<div class="col-sm-5">
							<input type="text" placeholder="Enter State" name="state" value="${x.state }" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							Zip Code</label>
						<div class="col-sm-5">
							<input type="text" placeholder="Enter Zip Code" Name="zipCode" value="${x.zip_code }" class="form-control">
						</div></div>
						
					
					<div class="form-group">
						<label class="col-sm-3 control-label" for="field-1">
							Rental Price (US Dollars)</label>
						<div class="col-sm-5">
							<input type="text" placeholder="Enter rental price per month" name="price" value="${x.price }" class="form-control">
						</div>
					</div>
						
						<input type="hidden" value="${x.apartment_id}" name="apartmentId"/>
						<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<button class="btn btn-primary" type="submit" >Update</button>
							<button class="btn btn-primary" type="reset" >Reset</button>
						</div>
						
					</div>
				</form>
				</c:forEach>
			</div>
			<hr />
			<!-- TS14862599959389: Xenon - Boostrap Admin Template created by Laborator / Please buy this theme and support the updates -->
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
	<!-- Imported styles on this page -->
	<link rel="stylesheet" href="css/jquery-jvectormap-1.2.2.css"
		id="style-resource-1">
	<link rel="stylesheet" href="css/rickshaw.min.css"
		id="style-resource-2">
	<script src="js/TweenMax.min.js" id="script-resource-1"></script>
	<script src="js/jquery-ui-1.10.3.minimal.min.js" id="script-resource-2"></script>
	<script src="js/bootstrap.js" id="script-resource-3"></script>
	<script src="js/joinable.js" id="script-resource-4"></script>
	<script src="js/resizeable.js" id="script-resource-5"></script>
	<script src="js/neon-api.js" id="script-resource-6"></script>
	<script src="js/cookies.min.js" id="script-resource-7"></script>
	<script src="js/jquery-jvectormap-1.2.2.min.js" id="script-resource-8"></script>
	<script src="js/jquery-jvectormap-europe-merc-en.js"
		id="script-resource-9"></script>
	<script src="js/jquery.sparkline.min.js" id="script-resource-10"></script>
	<script src="js/d3.v3.js" id="script-resource-11"></script>
	<script src="js/rickshaw.min.js" id="script-resource-12"></script>
	<script src="js/raphael-min.js" id="script-resource-13"></script>
	<script src="js/morris.min.js" id="script-resource-14"></script>
	<script src="js/toastr.js" id="script-resource-15"></script>
	<script src="js/fullcalendar.min.js" id="script-resource-16"></script>
	<script src="js/neon-chat.js" id="script-resource-17"></script>
	<!-- JavaScripts initializations and stuff -->
	<script src="js/neon-custom.js" id="script-resource-18"></script>
	<!-- Demo Settings -->
	<script src="js/neon-demo.js" id="script-resource-19"></script>
	<script src="js/neon-skins.js" id="script-resource-20"></script>
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