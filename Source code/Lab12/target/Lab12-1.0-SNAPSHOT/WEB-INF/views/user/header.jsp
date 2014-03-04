<%--
  Created by IntelliJ IDEA.
  User: Dto
  Date: 2/3/13
  Time: 1:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
<c:when test="${sessionScope.userSession.name != null}">
    user name: ${sessionScope.userSession.name}
    ${sessionScope.date}
</c:when>
<c:otherwise>
        no user register
</c:otherwise>
</c:choose>
