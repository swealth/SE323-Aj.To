<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Checkout - Eternal Beauty Essentials Website Template</title>
	<link rel="stylesheet" href="/resources/css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
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
					<li class="selected">
						<a href="productlist">Products</a>
					</li>
					<li>
						<a href="/admin">Admin</a>
					</li>
					<li>
						<a href="/member/profile">Member</a>
					</li>
					<li>
						<a href="/admin/history">History</a>
					</li>
					<li>
						<a href="blogs">Blog</a>
					</li>
					<li>
						<a href="contact">Contact</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="contents">
			<div id="main">
				<form action="index.html" method="post" id="checkout">
				
					<div id="compute" class="contentbox">
						<h2><span>Order Summary</span></h2>
						<table>
							<thead>
								<tr>
									<th>Item Description</th>
									<th>QTY</th>
									<th>Price Each</th>
									<th class="last-child">Order Price</th>
								</tr>
							</thead>
							<tbody>
                            <c:forEach items="${sessionScope.memberSession.cart.products}" var="productInCart" varStatus="status">
								<tr>
									<td><div class="frame2">
											<img src="image/${productInCart.product.image.id}" alt="Img" height="41" width="45">
										</div>
										<span class="title">${productInCart.product.name}</span>
										<p>
                                                ${productInCart.product.description}
										</p></td>
									<td>${productInCart.product.amount}</td>
									<td>$ ${productInCart.product.price}</td>
									<td><span class="total">$ ${productInCart.total}</span></td>
								</tr>
                            </c:forEach>
							</tbody>
						</table>
						<ul>
							<li>
								Subtotal: <span>$ ${sessionScope.memberSession.cart.total}</span>
							</li>
						</ul>
           <!--            <center> <input type="button" value="Paypal">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="Credit Card">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="Transfer Money">  </center> -->

                        <form action="">
                            <input type="checkbox" name="payment" value="Credit Card">Credit Card<br>
                            <input type="checkbox" name="payment" value="Transfer Money">Transfer Money
                        </form>

                    </div>
					<input type="submit" value="Submit Order" class="order">
				</form>


			</div>
			<div id="sidebar">
				<h1>Checkout</h1>
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
					<li class="selected">
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