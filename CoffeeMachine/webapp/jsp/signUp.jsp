<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/META-INF/templates/head.jsp" />
<body>
<jsp:include page="/META-INF/templates/header.jsp" />
<div class="content">
    <form class="sign-up" id="form" method="post" action="/controller" onsubmit="return validSignUp(this);">
        <input type="hidden" name="command" value="registration" />
        <h1 class="sign-up-title">Sign up in seconds</h1>
        <label id="errorName" class="error"></label>
        <input type="text" name="name" class="sign-up-input" placeholder="What's your username?" autofocus>
        <label id="errorEmail" class="error"></label>
        <input type="text" name="email" class="sign-up-input" placeholder="Enter your email">
        <label id="errorPassword" class="error"></label>
        <input type="password" name="password" class="sign-up-input" placeholder="Enter your password">
        <label id="errorRePassword" class="error"></label>
        <input type="Password" name="rePassword" class="sign-up-input" placeholder="Repeat your password">
        ${error}
        <input type="submit" value="Sign me up!"  class="sign-up-button">
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>

