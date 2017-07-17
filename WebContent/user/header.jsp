<div class="container">
				<div class="menu">
						<nav class="navbar navbar-default">
						  <div class="container-fluid">
						    <!-- Brand and toggle get grouped for better mobile display -->
						    <div class="navbar-header">
						     <!--  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						        <span class="sr-only"></span>
						        <span class="icon-bar"> </span>
						        <span class="icon-bar"> </span>
						        <span class="icon-bar"> </span>
						      </button> -->
						      <a class="navbar-brand" href="../user/index.jsp">
						      	<img src="img/Webp.net-resizeimage.png" height="55" width="160">
						      </a>
						    </div>
						
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						      <ul class="nav navbar-nav nav_link pull-right">
						        <li>
						        
						        <a href="../user/index.jsp"><b>HOME </b></a>
						        	
							    </li>
						        
						        <li><a href="<%=request.getContextPath()%>/allProperties?flag=fetch_properties"><b>PROPERTIES</b></a>
						        							        	
						        
						        </li>
						        <li><a class="drop_down">APPOINTMENT</a>
						        	<ul class="submenu">
							           
							           <li><a href="viewAppointment.jsp">View an Appointment</a> </li>
							           <li><a href="changeAppointment.jsp">Change an Appointment</a> </li>
							           <li><a href="cancelAppointment.jsp">Cancel an Appointment</a> </li>
							         
							    	</ul>						        	
						        </li>							        
						        	
						       <li><a class="drop_down">Rental Request</a>
						        	<ul class="submenu">
							           
							           <li><a href="viewRentalRequest.jsp">View Rental Request</a> </li>
							           <li><a href="cancelRentalRequest.jsp">Cancel Rental Request</a> </li>
							           
							         
							    	</ul>						        	
						        </li>		
						        
						        <li><a href="login.jsp"><b>LOGIN</b></a>
						        							        	
						        </li>
						        
						        <li><a href="contact.jsp"><b>CONTACT </b></a> </li>
						      </ul>
						    </div>
						  </div>
						</nav>
				</div>
				
			</div>