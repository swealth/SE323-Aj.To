<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Skin Care - Eternal Beauty Essentials Website Template</title>
	<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="/resources/css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
<style type="text/css">
<!--
#page #contents #main #adbox form table tr td strong {
	color: #FF0099;
}
#page #contents #main #adbox form p {
	color: #FF0099;
}
#page #contents #main #adbox form h2 strong {
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

            <sec:authorize access="!hasRole('ROLE_ADMIN')">
                <sec:authorize access="hasRole('ROLE_MEMBER')">
                    <img src="image/${sessionScope.memberSession.image.id}" width="70" height="70" align="right"/> </br>
                    <br><a href="logout"><p align="right">Logout</a>
                    ${sessionScope.memberSession.username}  </p>
                </sec:authorize>
            </sec:authorize>


            <sec:authorize access="!hasRole('ROLE_ADMIN')">
                <sec:authorize access="!hasRole('ROLE_MEMBER')">
                    <a href="register">Register</a> |
                    <a href="login">Login</a>
                </sec:authorize>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <img src="image/${sessionScope.userSession.image.id}" width="70" height="70" align="right"/> </br>
                <p align="right">${sessionScope.userSession.username}
                    <a href="logout">Logout</a>  </p>
            </sec:authorize>


			<div id="navigation">
				<ul>
					<li>
						<a href="/">Home</a>
					</li>
					<li>
						<a href="/admin/productlist">Products</a>
					</li>
					<li class="selected">
						<a href="/admin">Admin</a>
					</li>
					<li>
						<a href="">Member</a>
					</li>
					<li>
						<a href="/admin/history">History</a>
					</li>

				</ul>
			</div>
		</div>
		<div id="contents">
			<div id="main">
				<div id="adbox">
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
                  <form>
                    <h2><strong>Product</strong></h2>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                  </form>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
				  <p>&nbsp;</p>
                  
				  <div class="info2"></div>
				</div>
		  </div>
			<div id="sidebar">
				<h1>Admin</h1>
				<ul class="menu2">
					<li>
						<a href="/admin/addProduct">Add product</a>
					</li>
					<li class="selected">
						<a href="/admin/editProduct">Edit product</a>
					</li>
					<li>
                        <a href="/logout">Log out</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="footer">
			<ul class="navigation">
				<li>
						<a href="index">Home</a>
					</li>
					<li>
						<a href="register">Register</a>
					</li>
					<li>
                        <a href="productlist">Products</a>
					</li>
					<li class="selected">
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