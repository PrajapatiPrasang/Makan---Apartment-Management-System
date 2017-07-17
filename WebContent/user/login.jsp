<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<%
if(session.getAttribute("type")!=null && session.getAttribute("type").equals("admin")){
	response.sendRedirect("index.jsp");
	}
else if(session.getAttribute("type")!=null && session.getAttribute("type").equals("resident")){
	response.sendRedirect("../user/index.jsp");
}
String error=(String)request.getAttribute("error");
if(error != null){
	out.print("<p style='background-color:white;'>"+error +"</p>");
}
%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>Makan Login</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min1.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min1.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
</head>

<body class="full-page">

<div class="container-fluid">
    <div class="container">
    
        <div class="row">
            <div class="col-md-12">
                <div class="signin-signup-form">
                    <a href="../user/index.jsp"><img src="img/logo_makan_new.PNG" height="75" width="285"/></a>
                    <div class="form-title"><br>LOGIN</div>
                    <form action="<%=request.getContextPath() %>/loginController" method="post">
                        <input type="hidden" name="flag" value="login" required>
                        <div class="form-text">
                            <input type="text" name="username" placeholder="Username" required>
                        </div>
                        <div class="form-text">
                            <input type="password" name="password" placeholder="Password" required>
                        </div>
                        <div class="form-button">
                            <input type="submit" value="Login">
                        </div>
                    </form>
                    <div class="links-holder"><a href="../user/email.jsp">Forgot Password</a> </div>
                   <br> <div class="links-holder"><a href="../user/index.jsp">Back</a> </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br><br><br><br><br>
    <footer>
			<div class="footer">
				<span class="footer_copyright_text">Copyright 2017.All Rights Reserved by Makan  </span>
			</div> 
		</footer>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="js/main.js"></script>
</body>
</html>
