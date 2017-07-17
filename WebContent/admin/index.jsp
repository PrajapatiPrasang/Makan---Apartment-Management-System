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
<link rel="icon" href="http://demo.neontheme.com/assets/images/favicon.ico">
<title>Dashboard</title>
<link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.min.css" id="style-resource-1">
<link rel="stylesheet" href="css/entypo.css" id="style-resource-2">
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic" id="style-resource-3">
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

			<footer class="main">
				<div class="pull-right">
					<a
						href="http://themeforest.net/item/neon-bootstrap-admin-theme/6434477?ref=Laborator"
						target="_blank">
						<!-- <strong>Purchase this theme for $24</strong> -->
					</a>
				</div>
				
			</footer>
		</div>
		<!-- TS148625999517821: Xenon - Boostrap Admin Template created by Laborator / Please buy this theme and support the updates -->
		<div id="chat" class="fixed" data-current-user="Art Ramadani"
			data-order-by-status="1" data-max-chat-history="25">
			<div class="chat-inner">
				<h2 class="chat-header">
					<a href="#" class="chat-close"><i class="entypo-cancel"></i></a> <i
						class="entypo-users"></i> Chat <span
						class="badge badge-success is-hidden">0</span>
				</h2>
				<div class="chat-group" id="group-1">
					<strong>Favorites</strong> <a href="#" id="sample-user-123"
						data-conversation-history="#sample_history"><span
						class="user-status is-online"></span> <em>Catherine J.
							Watkins</em></a> <a href="#"><span class="user-status is-online"></span>
						<em>Nicholas R. Walker</em></a> <a href="#"><span
						class="user-status is-busy"></span> <em>Susan J. Best</em></a> <a
						href="#"><span class="user-status is-offline"></span> <em>Brandon
							S. Young</em></a> <a href="#"><span class="user-status is-idle"></span>
						<em>Fernando G. Olson</em></a>
				</div>
				<div class="chat-group" id="group-2">
					<strong>Work</strong> <a href="#"><span
						class="user-status is-offline"></span> <em>Robert J. Garcia</em></a> <a
						href="#" data-conversation-history="#sample_history_2"><span
						class="user-status is-offline"></span> <em>Daniel A. Pena</em></a> <a
						href="#"><span class="user-status is-busy"></span> <em>Rodrigo
							E. Lozano</em></a>
				</div>
				<div class="chat-group" id="group-3">
					<strong>Social</strong> <a href="#"><span
						class="user-status is-busy"></span> <em>Velma G. Pearson</em></a> <a
						href="#"><span class="user-status is-offline"></span> <em>Margaret
							R. Dedmon</em></a> <a href="#"><span class="user-status is-online"></span>
						<em>Kathleen M. Canales</em></a> <a href="#"><span
						class="user-status is-offline"></span> <em>Tracy J. Rodriguez</em></a>
				</div>
			</div>
			<!-- conversation template -->
			<div class="chat-conversation">
				<div class="conversation-header">
					<a href="#" class="conversation-close"><i class="entypo-cancel"></i></a>
					<span class="user-status"></span> <span class="display-name"></span>
					<small></small>
				</div>
				<ul class="conversation-body">
				</ul>
				<div class="chat-textarea">
					<textarea class="form-control autogrow"
						placeholder="Type your message"></textarea>
				</div>
			</div>
		</div>
		<!-- Chat Histories -->
		<ul class="chat-history" id="sample_history">
			<li><span class="user">Art Ramadani</span>
				<p>Are you here?</p> <span class="time">09:00</span></li>
			<li class="opponent"><span class="user">Catherine J.
					Watkins</span>
				<p>This message is pre-queued.</p> <span class="time">09:25</span></li>
			<li class="opponent"><span class="user">Catherine J.
					Watkins</span>
				<p>Whohoo!</p> <span class="time">09:26</span></li>
			<li class="opponent unread"><span class="user">Catherine
					J. Watkins</span>
				<p>Do you like it?</p> <span class="time">09:27</span></li>
		</ul>
		<!-- Chat Histories -->
		<ul class="chat-history" id="sample_history_2">
			<li class="opponent unread"><span class="user">Daniel A.
					Pena</span>
				<p>I am going out.</p> <span class="time">08:21</span></li>
			<li class="opponent unread"><span class="user">Daniel A.
					Pena</span>
				<p>Call me when you see this message.</p> <span class="time">08:27</span>
			</li>
		</ul>
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