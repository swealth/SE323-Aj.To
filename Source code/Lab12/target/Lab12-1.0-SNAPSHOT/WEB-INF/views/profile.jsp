<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Fragrance - Eternal Beauty Essentials Website Template</title>
	<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="/resources/css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
<style type="text/css">
<!--
#page #contents #main #adbox .info3 h2 {
	color: #f6faff;
}
#page #contents #main #adbox .info3 h1 {
	color: #ff1829;
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
                ${sessionScope.userSession.username}
                <a href="logout">Logout</a>
            </sec:authorize>

			<div id="navigation">
				<ul>
					<li>
						<a href="/">Home</a>
					</li>
					<li>
						<a href="/productlist">Products</a>
					</li>
					<li>
						<a href="/admin">Admin</a>
					</li>
					<li class="selected">
						<a href="/member/profile">Member</a>
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
				  <div class="info3">
			    <h1>Profile</h1> <br>
                <table border="0"></table>

                <tr colspan ="2"><td>Username:</td><td>${sessionScope.memberSession.username}</td></tr> <br>
                <tr colspan ="2"><td>Password: </td> <td>${sessionScope.memberSession.password}</td></tr> <br>
                <tr colspan ="2"><td>Name: </td><td>${sessionScope.memberSession.name}</td></tr>         <br>
			    <tr colspan ="2" ><td>Address: </td><td>${sessionScope.memberSession.address}</td></tr>   <br>
                <tr colspan ="2"><td>Picture: </td></tr>   <br>
                <tr colspan ="2"><td><img src="image/${sessionScope.memberSession.image.id}"></td></tr>

                </table>
				  </div>
				</div>
	    </div>
			<div id="sidebar">
				<h1>Member</h1>
				<ul class="menu2">
					<li>
						<a href="profile">Profile</a>
					</li>
					<li class="selected">
						<a href="update/${sessionScope.userSession.username}">Edit Profile</a>
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
						<a href="/">Home</a>
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
					<li class="selected">
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