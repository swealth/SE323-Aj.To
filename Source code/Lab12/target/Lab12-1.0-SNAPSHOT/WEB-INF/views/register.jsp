<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>What&rsquo;s New - Eternal Beauty Essentials Website Template</title>
	<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="/resources/css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
<style type="text/css">
<!--
#page #contents #main form table tr td {
	color: #FF0099;
}
-->
</style>
</head>
<body>
	<div id="page">
		<div id="header">
			<div id="logo">
				<a href="index.jsp"><img src="/resources/images/logo.png" alt="LOGO"></a>
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

					<li class="selected">
						<a href="register">Register</a>
					</li>
					<li>
						<a href="productlist">Products</a>
					</li>
					<li>
						<a href="admin">Admin</a>
					</li>
					<li>
						<a href="member/profile">Member</a>
					</li>
					<li>
						<a href="admin/history">History</a>
					</li>

				</ul>
			</div>
		</div>
		<div id="contents">
		  <div id="main">
			<ul id="products">
					<li></li>
					<li></li>
			</ul>

			<p>&nbsp;</p>
            <form:form  method="post" action="/addValidMember" commandName="member" enctype="multipart/form-data">
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
			    <td><strong>Name:</strong></td>
			    <td><form:input path="name" /></td>
		      </tr>
			  <tr>
			    <td><strong>Address:</strong></td>
			    <td><form:textarea path="address" /></td>
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
          </div>
		  <div id="sidebar">
		    <h1>Register</h1>
		  </div>
		</div>
		<div id="footer">
			<ul class="navigation">
				<li>
						<a href="/">Home</a>
					</li>
					<li class="selected">
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


