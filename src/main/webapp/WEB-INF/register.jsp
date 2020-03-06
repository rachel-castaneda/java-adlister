<%--
  Created by IntelliJ IDEA.
  User: rachelcastaneda
  Date: 3/6/20
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
    <div class="container">
        <h1>please fill in your information</h1>
<%--        registration form--%>
        <form action="/register" method="post">
<%--            username input--%>
            <div class="form-group">
                <label for="username">username</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
<%--            email input--%>
            <div class="form-group">
                <label for="email">email</label>
                <input type="text" id="email" name="email" class="form-control">
            </div>
<%--            password input--%>
            <div class="form-group">
                <label for="password">password</label>
                <input type="text" id="password" name="password" class="form-control">
            </div>
<%--            confirm password input--%>
            <div class="form-group">
                <label for="confirm_password">confirm password</label>
                <input type="text" id="confirm_password" name="confirm_password" class="form-control">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
