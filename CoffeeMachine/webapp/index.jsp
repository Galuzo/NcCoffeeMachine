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
    <form class="sign-up" id="form" method="get" action="/controller" onsubmit="return validSignIn(this);">
        <input type="hidden" name="command" value="login" />
        <h1 class="sign-up-title"><fmt:message key="header.label.signIn" bundle="${msg}" /></h1>
        <label id="errorName" class="error"></label>
        <input type="text" name="name" class="sign-up-input" placeholder="<fmt:message key="login.label.username" bundle="${msg}" />" autofocus>
        <label id="errorPassword" class="error"></label>
        <input type="password" name="password" class="sign-up-input" placeholder="<fmt:message key="login.label.password" bundle="${msg}" />">
        ${error}
        <input type="submit" value="<fmt:message key="header.label.signIn" bundle="${msg}" />"  class="sign-up-button">
    </form>
    <form   id="buttonSignUp" method="post" action="controller">
        <input type="hidden" name="command" value="goToSignUp" />
        <input type="submit" value="<fmt:message key="register.button.signUp" bundle="${msg}" />" >
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>


