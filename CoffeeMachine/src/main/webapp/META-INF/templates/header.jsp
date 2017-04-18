<%--
  Created by IntelliJ IDEA.
  User: Win
  Date: 18.04.2017
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="status-bar">
    <div id="status-bar-content">
        <form action="#search" method="post" id="search-form">
            <p>
                <input type="text" name="query" placeholder="search" />
                <input type="submit" name="submit" value="Search!" />
            </p>
        </form>
        <div id="status-bar-commands">
            <p id="welcome">Добро Пожаловать,гость</p>
            <p id="action-bar">
                <a id='login' href="#login "  title="Login">Вход</a>
                <a href="#sitemap" title="Sitemap">О нас</a>
                <a href="license.html" title="License">Лицензия</a>
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
                <a href="index.html" title="Home">Главная</a>		</li>
            <li id="menu">
                <a href="#menu" title="menu">Меню</a>		</li>
            <li id="reviews">
                <a href="#reviews" title="reviews">Отзывы</a>		</li>
            <li id="promotions">
                <a href="#promotions" title="promotions">Акции</a>		</li>
        </ul>
    </div>
</div>

<div id="content-top-shadow"></div>
