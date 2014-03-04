
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Products - Eternal Beauty Essentials Website Template</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <!--[if IE]>
    <link rel="stylesheet" href="/resources/css/ie.css" type="text/css" charset="utf-8">
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
                <li>
                    <sec:authorize access="!hasRole('ROLE_ADMIN')">
                    <sec:authorize access="!hasRole('ROLE_MEMBER')">
                    <a href="register">Register</a>
                    </sec:authorize>
                    </sec:authorize>
                </li>
                <li class="selected">
                    <a href="/productlist">Products</a>
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

            </ul>
        </div>
    </div>

    <div id="sidebar">
        <h1>Products</h1>
        <table width="200" border="1">
            <tr>
                <form action="/member/searchKeyword/" method="post">
                    <th scope="row"><input type="text" value="" name="searchfield" id="searchfield" /></th>
                    <td><input type="submit" value="Search" /></td>
                </form>
            </tr>
        </table>
    </div>

    <div id="contents">
        <div id="main">
            <div id="items">

                <table border="3" cellspacing="0" cellpadding="0" >
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Add</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td width="213" valign="middle"><c:out value="${product.name}"></c:out></td>
                        <td width="213" valign="middle"><c:out value="${product.description}"></c:out></td>
                        <td width="213" valign="middle"><c:out value="${product.price}"></c:out></td>
                        <td width="213" valign="middle"><img src="image/${product.image.id}" alt="Img" height="100" width="100"></td>
                        <td width="213" valign="middle">

                        <sec:authorize access="!hasRole('ROLE_ADMIN')">
                            <sec:authorize access="hasRole('ROLE_MEMBER')">
                                <form:form method="get" action="/member/addToCart/${product.id}">
                                    <input type="hidden" value="1" class="span1" id="amount" name="amount">
                                    <button class="btn btn-primary" type="submit">Add to cart</button>
                                </form:form>
                            </sec:authorize>
                        </sec:authorize>

                        </td>
                    </tr>
                </c:forEach>

                </table>
            </div>
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
