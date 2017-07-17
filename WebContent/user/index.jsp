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
		<title>Makan</title>
		
		<link rel="stylesheet" href="css/font-awesome.min.css">
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
		
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
<div class="header">
				<div class="header_slider_container">
					<figure class="image_header active_image">
						<img src="img/dreamvilla-slide1.jpg" alt="header" />	
						
				</figure>
					<figure class="image_header home-page-slider-header">
						<img src="img/dreamvilla-slide2.jpg" alt="header" />	
						<figcaption>
							<div class="container">
								<div class="slider_text">
									<div class="property_info_header">
										<h2>welcome to Makan site</h2>
										
																				
									</div>
								</div>
							</div>
						</figcaption>						
					</figure>					
					<button class="previous_image_btn" type="button">
						<span class="glyphicon glyphicon-menu-left"> </span>
					</button>
					<button class="next_image_btn" type="button">
						<span class="glyphicon glyphicon-menu-right"> </span>
					</button>
				</div>
			</div>
		</header>	
		
		<div class="multiple-recent-properties" style="height:1040px">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<h3 class="section-heading recent-properties">Most Recent Residential Properties</h3>		
						</div>
						
					</div>
					<div class="row">
							
    							
    							
    							<div class="item active">
    							<c:forEach items="${sessionScope.list_of_apartment }" var="i" varStatus="j">
                         		<c:if test="${j.count le 6 }">
                     
									<div class="col-sm-6 col-md-4 col-lg-4">
										<div class="image-with-label">
											<a href="<%=request.getContextPath() %>/addApartmentController?flag=list&apartment_id=${i.apartment_id}"><img class="img-responsive" alt="recent-properties-1" src="<%=request.getContextPath()%>/doc/${i.encrypted_name}"></a>
											
										</div>
										<a href="<%=request.getContextPath() %>/addApartmentController?flag=list&apartment_id=${i.apartment_id}"><h6>${i.address }</h6></a>
										<span class="recent-properties-address">${i.city } / ${i.state }</span>
										<p class="recent-properties-price"><% out.print("$ ");%> ${i.price}<% out.print(" per Month");%></p>
										<a href="<%=request.getContextPath() %>/addAppointmentController?flag=search&apartment_id=${i.apartment_id}"><button class="btn btn-primary" type="submit" >Schedule an Appointment</button></a>
										<a href="<%=request.getContextPath() %>/addAppointmentController?flag=fetchAddress&apartment_id=${i.apartment_id}"><button class="btn btn-primary" type="submit" >Request for Rental</button></a>
									</div>
									
									</c:if>
									</c:forEach>
									
									
									
								</div>							
						</div>						
					</div>
					
				</div>
			
		<footer>
			<div class="footer">
				<span class="footer_copyright_text">Copyright 2017.All Rights Reserved by Makan  </span>
			</div> 
		</footer>
		<script src="js/jquery-2.1.4.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="http://maps.googleapis.com/maps/api/js"></script>
		<script src="js/google-map.js"></script>
		<script src="js/slider.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/formsubmit.js"></script>
	</body>
</html>