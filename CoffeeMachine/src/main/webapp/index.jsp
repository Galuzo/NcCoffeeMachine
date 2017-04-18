<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="/META-INF/templates/head.jsp" />
<body>
<jsp:include page="/META-INF/templates/header.jsp" />
<div class="content">
    <form class="sign-up" id="form">
        <h1 class="sign-up-title">Sign in </h1>
        <label id="errorName" class="error"></label>
        <input type="text" name="name" class="sign-up-input" placeholder="What's your username?" autofocus>
        <label id="errorPassword" class="error"></label>
        <input type="password" name="password" class="sign-up-input" placeholder="Enter your password">
        <input type="button" value="Sign me in!" onclick="validSignIn(document.getElementById('form'))"  class="sign-up-button">
        <a href="jsp/signUp.jsp">Регистрация</a>
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>

