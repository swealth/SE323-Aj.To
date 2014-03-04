<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Eternal Beauty Essentials Website Template</title>
	<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
<style type="text/css">
<!--
#page #contents #sidebar .news form table tr td strong {
	color: #FF0099;
}
#page #contents #sidebar .news form table tr td {
	color: #FF0099;
}
#page #contents #sidebar .news form h2 {
	color: #FF0099;
}
#page #contents #main #adbox .info form table tr td strong {
	color: #FF00CC;
}
#page #contents #main #adbox .info form table tr td {
	color: #FF00CC;
}
-->
</style>
</head>
<body>
	<div id="page">
		<div id="header">
			<div id="logo">
				<a href="index"><img src="/resources/images/logo.png" alt="LOGO"></a>
			</div>
			<div id="navigation">
				<ul>
					<li class="selected">
						<a href="index">Home</a>
					</li>
					<li>
						<a href="register">Register</a>
					</li>
					<li>
                        <a href="productlist">Products</a>
					</li>
					<li>
						<a href="admin">Admin</a>
					</li>
					<li>
						<a href="member">Member</a>
					</li>
					<li>
						<a href="history">History</a>
					</li>

				</ul>
			</div>
		</div>
		<div id="contents">
			<div id="main">
				<div id="adbox">
				  <p>&nbsp;</p>
				  <div class="info">
					<h1>Admin Login</h1>
                      <form:form  method="post" action="/addValidAdmin" commandName="user" enctype="multipart/form-data">
                          <table width="200" border="1" align="center">
                              <tr>
                                  <td><strong>Username:</strong></td>
                                  <td><form:input path="username" /></td>
                              </tr>
                              <tr>
                                  <td><strong>Password:</strong></td>
                                  <td><form:password path="password" /></td>
                              </tr>
                              <tr>
                                  <td><strong>Picture:</strong></td>
                                  <td><input type="file" name="file" id="file"/></td>
                              </tr>
                          </table>
                          <br>
                          <center><input type="submit" value="Register"/></center>
                          <p>&nbsp;</p>
                      </form:form>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				  </div>
		    </div>
				<ul id="promotions">
				  <li> </li>
				</ul>
			</div>
			<div id="sidebar">
				<div class="cart">
					<a href="cart">View Cart</a> <span>Your cart<br> is empty</span>
				</div>
				<div class="news">
                <form>
                  <ul class="menu2">
					<li>
						<a href="memberLogin">Member Login</a>
					</li>
					<li class="selected">
						<a href="adminLogin">Admin Login</a>
					</li>
					<li>
						<a href="fragrance.html">Citrus</a>
					</li>
					<li>
						<a href="fragrance.html">Lush</a>
					</li>
					<li>
						<a href="fragrance.html">Forest</a>
					</li>
					<li>
						<a href="fragrance.html">Breeze</a>
					</li>
				</ul>

               	  <p>&nbsp;</p>
               	  <center>
               	    <p>
               	    
           	        </p>
               	    <p>&nbsp;</p>
               	  </center>
                </form>
					
			  </div>
			</div>
		</div>
		<div id="footer">
			<ul class="navigation">
				<li class="selected">
						<a href="index">Home</a>
					</li>
					<li>
						<a href="register">Register</a>
					</li>
					<li>
                        <a href="productlist">Products</a>
					</li>
					<li>
						<a href="admin">Admin</a>
					</li>
					<li>
						<a href="member">Member</a>
					</li>
					<li>
						<a href="history">History</a>
					</li>

			</ul>
			<p id="footnote">
				© Eternal Beauty Essentials 2012. All Rights Reserved.
			</p>
		</div>
	</div>
</body>
</html>