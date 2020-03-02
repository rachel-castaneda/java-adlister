<%--
  Created by IntelliJ IDEA.
  User: rachelcastaneda
  Date: 3/2/20
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%--ads index.jsp to show ads--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="viewing all the ads"/>
    </jsp:include>
    <title>view ads</title>
</head>
<body>

<jsp:include page="/partials/navbar.jsp" />

    <c:forEach var="ad" items="${ads}">
        <div class="ads">
            <h2>user ${ad.userId}</h2>
            <h2>title ${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>

</body>
</html>
