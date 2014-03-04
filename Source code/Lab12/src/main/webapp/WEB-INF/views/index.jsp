<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Eternal Beauty Essentials Website Template</title>
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
    <!--[if IE]>
    <link rel="stylesheet" href="/resources/css/ie.css" type="text/css" charset="utf-8">
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
        -->
    </style>
</head>
<body>
<div id="page">
    <div id="header">

        <div id="logo">
            <a href="/"><img src="/resources/images/logo.png" alt="LOGO"></a>
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
                <li class="selected">
                    <a href="/">Home</a>
                </li>
                <li>
                    <a href="register">Register</a>
                </li>
                <li>
                    <a href="/productlist">Products</a>
                </li>
                <li>
                    <a href="/admin">Admin</a>
                </li>
                <li>
                    <a href="/member/profile">Member</a>
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
                <img src="/resources/images/pet.gif" alt="Img" height="384" width="700">
                <div class="info">
                    <h1>Pet Shop</h1>
                </div>
            </div>
            <ul id="promotions">
                <li> </li>
            </ul>
        </div>
        <div id="sidebar">
            <sec:authorize access="!hasRole('ROLE_ADMIN')">
            <sec:authorize access="hasRole('ROLE_MEMBER')">
            <div class="cart">
                <a href="/member/cart">View Cart</a> <span>Your cart<br> is here!</span>
            </div>
            </sec:authorize>
            </sec:authorize>
            <div class="news">
                <sec:authorize access="!hasRole('ROLE_ADMIN')">
                <sec:authorize access="!hasRole('ROLE_MEMBER')">
                <h2>Log in</h2>
                <table align="center">
                    <form id="loginForm" action="/j_spring_security_check" method="post" accept-charset="UTF-8">
                        <table cellspacing="2">
                            <tbody>
                            <tr>
                                <td><p>Username: </p></td>
                                <td><p><input id="j_username" name="j_username" type="text"/></p></td>
                            </tr>
                            <tr>
                                <td><p>Password:</p></td>
                                <td><input id="j_password" name ="j_password" type="password"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><a href="#"><input type="submit" class="submit_btn" name="log in" value="Log in" /></a>
                                    <a href="register"><input type="submit" class="submit_btn" name="register"  value="Register"/></a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                    </table>
                </sec:authorize>
                </sec:authorize>
                <sec:authorize access="!hasRole('ROLE_ADMIN')">
                <sec:authorize access="hasRole('ROLE_MEMBER')">
                    Welcome Member <br/>
                    <a href="/logout">LogOut</a>
                </sec:authorize>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    Welcome Admin </br>
                    <a href="/logout">LogOut</a>
                </sec:authorize>
            </div>
        </div>
        <div id="footer">
            <ul class="navigation">
                <li class="selected">
                    <a href="/">Home</a>
                </li>
                <li>
                    <a href="register">Register</a>
                </li>
                <li>
                    <a href="cosmetics">Cosmetics</a>
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