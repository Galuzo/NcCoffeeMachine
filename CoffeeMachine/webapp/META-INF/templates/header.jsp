
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty language ? language : 'ru'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Messages" var="msg" />
<div id="status-bar">
    <form id="languageSelect" method="post" action="controller">
        <select id="language" name="language" onchange="this.form.submit()">
            <option value="ru" ${language == 'ru' ? 'selected' : ''} >Russian</option>
            <option value="en"  ${language == 'en' ? 'selected' : ''}>English</option>
        </select>
        <input type="hidden" name="command" value="changeLanguage" />
    </form>
    <div id="status-bar-content">
        <form action="#search" method="post" id="search-form">
            <p>
                <input type="text" name="query" placeholder="<fmt:message key="header.label.search" bundle="${msg}" />" />
                <input type="submit" name="submit" value="Search!" />
            </p>
        </form>

        <div id="status-bar-commands">
            <p id="welcome"><fmt:message key="header.label.welcome" bundle="${msg}" />,
                <c:choose>
                    <c:when test="${user eq null}">
                        <fmt:message key="header.label.guest" bundle="${msg}" />
                    </c:when>
                    <c:otherwise>
                        ${user.login}
                    </c:otherwise>
                </c:choose>
            </p>
            <p id="action-bar">
                <a id='login' href="#login "  title="Login"><fmt:message key="header.label.signIn" bundle="${msg}" /></a>
                <a href="#sitemap" title="Sitemap"><fmt:message key="header.label.about" bundle="${msg}" /></a>
                <a href="license.html" title="License"><fmt:message key="header.label.license" bundle="${msg}" /></a>
            </p>
        </div>

    </div>
</div>
<div id="main">
    <div id="header">
        <div id="logo">
            <h1><a href="#home" title="Home Page">Coffee</a></h1>
            <h2>Time</h2>
        </div>
    </div>

    <div id="navigation">
        <ul id="tabs">
            <li id="home" class="current">
                <a href="index.html" title="Home"><fmt:message key="menu.label.main" bundle="${msg}" /></a>		</li>
            <li id="menu">
                <a href="#menu" title="menu"><fmt:message key="menu.label.menu" bundle="${msg}" /></a>		</li>
            <li id="reviews">
                <a href="#reviews" title="reviews"><fmt:message key="menu.label.reviews" bundle="${msg}" /></a>		</li>
            <li id="promotions">
                <a href="#promotions" title="promotions"><fmt:message key="menu.label.shares" bundle="${msg}" /></a>		</li>
        </ul>
    </div>
</div>

<div id="content-top-shadow"></div>
