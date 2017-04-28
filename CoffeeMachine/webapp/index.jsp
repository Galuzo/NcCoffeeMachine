<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/META-INF/templates/head.jsp" />
<body>
<jsp:include page="/META-INF/templates/header.jsp" />
<div class="content">
    <form class="sign-up" id="form" method="post" action="/controller" onsubmit="return validSignIn(this);">
        <input type="hidden" name="command" value="login" />
        <h1 class="sign-up-title">Sign in </h1>
        <label id="errorName" class="error"></label>
        <input type="text" name="name" class="sign-up-input" placeholder="What's your username?" autofocus>
        <label id="errorPassword" class="error"></label>
        <input type="password" name="password" class="sign-up-input" placeholder="Enter your password">
        ${error}
        <input type="submit" value="Sign me in!"  class="sign-up-button">
        <a href="jsp/signUp.jsp">Регистрация</a>
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>


