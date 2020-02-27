<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: rachelcastaneda
  Date: 2/27/20
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <title>login</title>
<body>

    <form action="login.jsp" method="post">
        <div class="container">
            <label for="username"><b>username</b></label>
            <input id="username" type="text" placeholder="enter username" name="username">
            <label for="password"><b>password</b></label>
            <input id="password" type="password" placeholder="enter password" name="password">
            <button type="submit">login</button>
        </div>
    </form>

    <%
        PrintWriter printer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            if (username.equals("user") && password.equals("password")) {
                response.sendRedirect("/profile.jsp?username="+username);
            } else {
                response.sendRedirect("/login.jsp");
            }
        }
    %>

    <%@ include file="/partials/head.jsp" %>
</body>

</html>
