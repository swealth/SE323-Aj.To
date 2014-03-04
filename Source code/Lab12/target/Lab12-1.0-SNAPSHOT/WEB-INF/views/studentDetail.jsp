<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<h1>The student details</h1>
<c:choose>
<c:when test="${student != null}">
<table border="1" cellspacing="0" cellpadding="0">
        <tr>

            <td width="213" valign="top"><p>${student.name}</p></td>
            <td width="213" valign="top"><p>${student.sid}</p></td>
            <td width="213" valign="top"><p>${student.gpa}</p></td>
        </tr>
    </c:when>
<c:otherwise>
    <H1> There is no student with the given name</H1>
</c:otherwise>
</c:choose>
</table>
</body>
</html>