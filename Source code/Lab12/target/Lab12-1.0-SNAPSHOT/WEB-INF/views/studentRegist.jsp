<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Student Registration</title>

</head>
<style>
    .error {
        color:#ff0000;

    }
    .errorblock {
        color: #000;
        background-color:#ffEEEE ;
        border:3px solid #ff0000;
        padding: 8px;
        margin: 16px;

    }
</style>
<body>
<p align="center">Register Student </p>
<div align="center">
    <table width="200" border="1">
        <form:form  method="post" action="/student/addValidStudent" commandName = "student" enctype="multipart/form-data">
            <form:hidden path="id"/>
            <tr>
                <th scope="row"><form:label path="name">Student Name</form:label></th>
                <td>
                    <label>
                        <form:input path="name" />
                    </label>
                </td>
                <td>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="salary">Student Salary</form:label></th>
                <td>
                    <label>
                        <form:input path="salary"/>
                    </label>
                </td>
                <td>
                    <form:errors path="salary" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="sid">Student ID</form:label></th>
                <td>
                    <label>
                        <form:input path="sid" />
                    </label>
                </td>
                <td>
                    <form:errors path="sid" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="telNum">Telephone Number</form:label></th>
                <td>
                    <label>
                        <form:input path="telNum" />
                    </label>
                </td>
                <td>
                    <form:errors path="telNum" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="gpa">GPA</form:label></th>
                <td>
                    <label>
                        <form:input path="gpa" />
                    </label>
                </td>
                <td>
                    <form:errors path="gpa" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th scope="row"><form:label path="image">images</form:label></th>
                <td>
                    <label>
                        <input type="file" name="file" id="file"/>
                    </label>
                </td>
                <td>
                    <form:errors path="image" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Student"/>
                </td>
            </tr>

        </form:form>
    </table>
</div>
<p>&nbsp;</p>
</body>
</html>