<%--
  Created by IntelliJ IDEA.
  User: rachelcastaneda
  Date: 2/27/20
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <title>profile</title>
<body>
    <h1>welcome ${param.username}</h1>
    <p>username: ${param.username}</p>

    <h4>profile</h4><i class="fas fa-user"></i>
    <ul style="list-style: none">
        <li>username: </li>
        <li>contact: </li>
        <li>bio: </li>
    </ul>
    <%@ include file="partials/head.jsp" %>
</body>
</html>
