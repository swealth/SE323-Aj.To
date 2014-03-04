<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="user/header.jsp"/>
<h1>The student list</h1>
<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <td width="213" valign="top"><p><strong>no.</strong></p></td>
    <td width="213" valign="top"><p><strong>name</strong></p></td>
    <td width="213" valign="top"><p><strong>Salary</strong></p></td>
    </thead>
    <c:forEach items="${lecturers}" var="lecturer" varStatus="status">
    <tr>
        <td width="213" valign="top"><p><strong>${status.count}</strong></p></td>
        <td width="213" valign="top"><p><strong>${lecturer.name}</strong></p></td>
        <td width="213" valign="top"><p><strong>${lecturer.salary}</strong></p></td>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <td width="213" valign="top"><img src="image/${lecturer.image.id}"></td>
        </sec:authorize>
    </tr>
    </c:forEach>
</table>
</body>
</html>