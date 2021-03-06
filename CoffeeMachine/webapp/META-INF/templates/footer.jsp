<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Messages" var="msg" />
<div id="content-bottom-shadow"></div>
<div id="footer">
    <div id="footer-image"></div>
    <p id="footer-text">
        Copyright © 2017 Coffee Time<br /> <fmt:message key="footer.label.rights" bundle="${msg}" />
    </p>

</div>