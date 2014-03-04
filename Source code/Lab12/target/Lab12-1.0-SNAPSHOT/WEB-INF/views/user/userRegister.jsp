<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>User Registration</title>
</head>
<body>
<p align="center">Register Lecturer </p>
<div align="center">
    <table width="200" border="1">
        <form:form  method="post" action="/user/register" commandName="user">
            <tr>
                <th scope="row"><form:label path="name">Name</form:label></th>
                <td>
                    <label>
                        <form:input path="name" />
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add user name"/>
                </td>
            </tr>
        </form:form>
    </table>
</div>
<p>&nbsp;</p>
</body>

</html>
