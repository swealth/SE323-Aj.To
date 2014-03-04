<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1>The Course List list</h1>
    <c:forEach items="${course}" var="c" >
    <h2>Course name </h2> ${c.name}
    <h3>Lecturer name </h3>${c.lecturer.name}
        <table border="1" cellspacing="0" cellpadding="0">
           <thead>
            <td width="213" valign="top"><p><strong>no.</strong></p></td>
            <td width="213" valign="top"><p><strong>name</strong></p></td>
            <td width="213" valign="top"><p><strong>student id</strong></p></td>
            <td width="213" valign="top"><p><strong>GPA</strong></p></td>
            </thead>

        <c:forEach items="${c.students}" var="s" varStatus="status">
            <tr>
                <td width="213" valign="top"><p><strong>${status.count}</strong></p></td>
                <td width="213" valign="top"><p><strong>${s.name}</strong></p></td>
                <td width="213" valign="top"><p><strong>${s.sid}</strong></p></td>
                <td width="213" valign="top"><p><strong>${s.gpa}</strong></p></td>
            </tr>
        </c:forEach>

    </table>
    </c:forEach>
</body>
</html>