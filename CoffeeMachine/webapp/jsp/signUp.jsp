<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty language ? language : 'ru'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Messages" var="msg" />
<jsp:include page="/META-INF/templates/head.jsp" />
<body>
<jsp:include page="/META-INF/templates/header.jsp" />
<div class="content">
    <form class="sign-up" id="form" method="post" action="/controller" onsubmit="return validSignUp(this);">
        <input type="hidden" name="command" value="registration" />
        <h1 class="sign-up-title"><fmt:message key="register.button.signUp" bundle="${msg}" /></h1>
        <label id="errorName" class="error"></label>
        <input type="text" name="name" class="sign-up-input" placeholder="<fmt:message key="login.label.username" bundle="${msg}" />" autofocus>
        <label id="errorEmail" class="error"></label>
        <input type="text" name="email" class="sign-up-input" placeholder="<fmt:message key="register.label.email" bundle="${msg}" />">
        <label id="errorPassword" class="error"></label>
        <input type="password" name="password" class="sign-up-input" placeholder="<fmt:message key="login.label.password" bundle="${msg}" />">
        <label id="errorRePassword" class="error"></label>
        <input type="Password" name="rePassword" class="sign-up-input" placeholder="<fmt:message key="register.label.repeatePassword" bundle="${msg}" />">
        ${error}
        <input type="submit" value="<fmt:message key="register.button.signUp" bundle="${msg}" />!"  class="sign-up-button">
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>

