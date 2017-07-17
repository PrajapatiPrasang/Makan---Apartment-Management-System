<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		
		<title>Property Details</title>
		
		<link rel="stylesheet" href="css/font-awesome.min.css">	
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />	
	</head>
	<body>
		<c:forEach items="${sessionScope.edit_apartments1 }" var="i" varStatus="j">
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
			
			
			
			
			
   			<div class="inner-page-property-details-header-area">
				<div class="property-detail-banner">
					<div class="header_slider_container">
						<img alt="banner-image" class="img-responsive image_header active_image" src="<%=request.getContextPath()%>/doc/${i.encrypted_name}">
						<!-- <img alt="banner-image" class="img-responsive image_header" src="img/propert-detail2.jpg"> -->
						<button class="previous_image_btn" type="button">
							<span class="glyphicon glyphicon-menu-left"> </span>
						</button>
						<button class="next_image_btn" type="button">
							<span class="glyphicon glyphicon-menu-right"> </span>
						</button>
						<div class="shadow"> </div>
					</div>   					
					<div class="property-detail-info">
						<div class="container">
							<div class="row">
									<div class="col-sm-12 col-xs-12 col-md-8 col-lg-8">
									<div class="row">
										<div class="col-xs-12 col-sm-7 col-md-7"><h1>${i.address }</h1></div>
										<div class="col-xs-12 col-sm-3 col-md-3"><label class="property_type">On Rental</label></div>
									</div>
									<p class="property-detail-address"><i class="fa fa-map-marker"> </i>${i.city } / ${i.state }</p>
									<div class="row property-detail-facility">
										<div class="col-xs-12 col-sm-3 col-md-3"><label class="property-detail-price"><% out.print("$ ");%> ${i.price}<% out.print(" per Month");%></label></div>
										<div class="col-xs-12 col-sm-3 col-md-3 property-detail-facility-icon"><img src="img/svg/bath.svg" class="svgImages" alt="bedroom"><label>Bedrooms</label><span>${i.bedroom }</span></div>
										<div class="col-xs-12 col-sm-3 col-md-3 property-detail-facility-icon"><img src="img/svg/bed.svg" class="svgImages" alt="bathroom"><label>Bathrooms</label><span>${i.bathroom }</span></div>
										
									</div>
								</div>
							</div>
						</div>
					</div>	
				</div>   								
			</div>
		</header>
		<section>
			<div class="property-detail">
				<div class="container">
					<div class="row">
						<div class="col-lg-8 col-md-8 property-detail-inner">
							
							<div class="row">
								<div class="col-lg-6 col-md-6">
									<h4>Essential Information</h4>
									<div class="row">
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Price</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value"><% out.print("$ ");%> ${i.price}<% out.print(" per Month");%></div>
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Bedrooms</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value">${i.bedroom }</div>
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Bathrooms</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value">${i.bathroom }</div>										
										
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 inofrmaition-label">Type</div>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 information-value">Single Family</div>
										<br>
										<br>
										</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<h4>Amenities</h4>
									<div class="row amenities-info">
										<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 inofrmaition-label"></div>
										<div class="col-lg-11 col-md-11 col-sm-10 col-xs-10 information-value">${i.aminities }</div>
										
										
									</div>		
								</div>
							</div>
							<br>
							<a href="<%=request.getContextPath() %>/addAppointmentController?flag=search&apartment_id=${i.apartment_id}"><button class="btn btn-primary" type="submit" >Schedule an Appointment</button></a>
							<a href="<%=request.getContextPath() %>/addAppointmentController?flag=fetchAddress&apartment_id=${i.apartment_id}"><button class="btn btn-primary" type="submit" >Request for Rental</button></a>
							<br>
							<br>
							<br>
						</div>
						
					</div>
				</div>
			</div>
		</section>
		</c:forEach>
	
		<%
		if(session.getAttribute("list_of_apartment_photos")!=null){
		%>
		<section>
			<div class="inner-page-gallery-three-columns">
				<div class="container">
					
					<div class="LivingRoom inner-page-gallery-three-columns-dimension-detail show-hide-detail" id="LivingRoom">
						<ul class="row">
						<c:forEach items="${sessionScope.list_of_apartment_photos }" var="m" varStatus="j">
							<li class="col-md-4 col-sm-4 col-xs-12">
								<img src="<%=request.getContextPath()%>/doc/${m.encrypted_name}" alt="gallery_img">
														
							</li>
							</c:forEach>							
						</ul>
					</div>
																					
				</div>
			</div>
		</section>
		
		
		<%}	%>
		<footer>
			<div class="footer">
				<span class="footer_copyright_text">Copyright 2017.All Rights Reserved by Makan  </span>
			</div> 
		</footer>
		
		<script src="js/jquery-2.1.4.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/image-light-box.js"></script>
		<script src="js/tab-navigation.js"></script>
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