<!DOCTYPE html>
<html>
	<head>
	<base href="${pageContext.request.contextPath}/user/">
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="Residency theme">
		<meta name="keywords" content="Residency,sale,buy,rent,pg,house,villa,apartment">
		<meta name="author" content="Fortune Creations">
		<meta name="viewport" content="width=device-width">
		
		<title>Contact-Us</title>
		
		<link rel="stylesheet" href="css/font-awesome.min.css">

		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
	</head>
	<body>
		
				<header>
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
out.print("<p style='background-color:green; font-size:24px; color:white'><b>"+error +"</b></p>");
} %>
			<div class="container">

				
			</div>
			
   			<div class="inner-page-header-area"> <img alt="banner-image" src="img/innerpage_header.jpg">
				<div class="container">
					<div class="inner_slider_text">
						<div class="property_info_header">
							<h2> Contact us </h2><h5><a href="index.jsp">Home</a> &gt; Contact us </h5>
						</div>
					</div>
				</div>
			</div>
		</header>
		
		<section>
			<div class="inner-contact">
				<div class="container">
					<h1>Contact Us</h1>
					<div class="row" id="inner-contact-address">
						<div class="col-md-6 col-sm-6 col-xs-12">
							<h2>Office Address</h2>
							<div class="row" align="center">
								<div class="col-md-6 col-sm-6 col-xs-12 inner-contact-border">
									<p>1400, Washington Ave</p>
									<p>Albany, NY - 12222</p>
									<p>United States.</p>
									<p>Phone : (518) - 776 - 9499</p>
									<p>Email : makanapartment@gmail.com</p>									
								</div>
								
							</div>
						</div>
						
					</div>
					<div class="inner-contact-agent-area">
						<div id="inner-contact-agent-intro" class="row">
							<div class="col-md-8 col-sm-8 col-xs-12">
								<div class="row">
									
									<div class="col-md-10 col-sm-10 col-xs-9">
										
										<div class="inner-contact-icon">
											<span class="glyphicon glyphicon-earphone"></span><span>518-776-9499</span>
											<span class="glyphicon glyphicon-envelope"></span><span><a href="mailto:makanapartment@gmail.com">makanapartment@gmail.com</a></span>
										</div>
									</div>
								</div>
							</div>
							
						</div>				
						<form method="post" action="<%=request.getContextPath() %>/contactUsController?flag=add">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="name" placeholder="Full Name" required>
									<input type="text" name="phone" placeholder="Phone Number" required>
									<input type="email" name="email"  placeholder="Email Address" required>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<textarea name="message" placeholder="Message" required></textarea>
									<input type="submit" name="sendmessage" class="send-message" value="SUBMIT NOW" />
								</div>
							</div>
						</form>
					</div>
									
				</div>				
			</div>
		</section>
		<div class="modal fade" id="contact_our_agent" tabindex="-1" role="dialog">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content" id="model-contact-form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						
					</div>
					<div class="modal-body">
						<div class="contact-form model-contact-form" id="contact-form">
							
							<form class="agnet-contact-form" name="contact_form" method="post" action="functions.php">
								<ul>
									<li>
										<input type="text" name="full_name" id="full_name" placeholder="Full Name" required>
										<input type="number" name="phone_number" id="phone_number" placeholder="Phone Number" required>
										<input type="email" name="email_address" id="email_address" placeholder="Email Address" required>
									</li>
									<li>
										<textarea name="message" id="message" placeholder="Message" required></textarea>
										<input type="submit" name="sendmessage" class="send-message" value="SUBMIT NOW" />
									</li>
								</ul>
							</form>
						
				</div>
			</div>
		</div>
		</div>
		</div>
		<footer>
			<div class="footer">
				<span class="footer_copyright_text">Copyright 2017.All Rights Reserved by Makan </span>
			</div> 
		</footer>
		<script src="js/jquery-2.1.4.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
				
		<script src="js/formsubmit.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				function centerModals(){
				  $('.modal').each(function(i){
				    var $clone = $(this).clone().css('display', 'block').appendTo('body');
				    var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);
				    top = top > 0 ? top : 0;
				    $clone.remove();
				    $(this).find('.modal-content').css("margin-top", top);
				  });
				}
				$('.modal').on('show.bs.modal', centerModals);
				$(window).on('resize', centerModals);
			});
		</script>		
	</body>
</html>