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
    <h3 id="role">  <fmt:message key="admin.label.welcomeRoleAdmin" bundle="${msg}" /></h3>
    <jsp:useBean id="coffeemachine" class="by.training.nc.dev3.services.CoffeeMachineService" scope="page"/>
    <c:set var="beverages" value="${coffeemachine.beveragesInMachine}" />
    <c:set var="ingredients" value="${coffeemachine.ingredientsInMachine}" />
    <h3><fmt:message key="client.label.beverage" bundle="${msg}" /></h3>
    <table>
    <tr>
        <th> <fmt:message key="client.label.id" bundle="${msg}" /></th>
        <th> <fmt:message key="client.label.title" bundle="${msg}" /></th>
        <th> <fmt:message key="client.label.cost" bundle="${msg}" /></th>
        <th> <fmt:message key="client.label.count" bundle="${msg}" /></th>
    </tr>
    <c:forEach items="${beverages}" var="beverage">
        <tr>
            <td><c:out value="${beverage.id}"/></td>
            <td><c:out value="${beverage.title}"/></td>
            <td><c:out value="${beverage.cost}"/></td>
            <td><c:out value="${beverage.count}"/></td>
        </tr>
    </c:forEach>
    </table>
    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="addExistBeverage" />
        <fmt:message key="client.label.beverage" bundle="${msg}" /> id: <input type="text" name="beverageId">
        <fmt:message key="client.label.count" bundle="${msg}" />: <input type="text" name="beverageCount">
        <input type="submit" value="<fmt:message key="admin.button.addExistBeverage" bundle="${msg}" />" >
    </form>
    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="addNewBeverage" />
        <fmt:message key="client.label.title" bundle="${msg}" />: <input type="text" name="newBeverageName">
        <fmt:message key="client.label.cost" bundle="${msg}" />: <input type="text" name="newBeverageCost">
        <fmt:message key="client.label.count" bundle="${msg}" />: <input type="text" name="newBeverageCount">
        <input type="submit" value="<fmt:message key="admin.button.addNewBeverage" bundle="${msg}" />" >
    </form>

    <h3><fmt:message key="client.label.ingredients" bundle="${msg}" /></h3>
    <table>
        <tr>
            <th> <fmt:message key="client.label.id" bundle="${msg}" /></th>
            <th> <fmt:message key="client.label.title" bundle="${msg}" /></th>
            <th> <fmt:message key="client.label.cost" bundle="${msg}" /></th>
            <th> <fmt:message key="client.label.count" bundle="${msg}" /></th>
        </tr>
        <c:forEach items="${ingredients}" var="ingredient">
            <tr>
                <td><c:out value="${ingredient.id}"/></td>
                <td><c:out value="${ingredient.title}"/></td>
                <td><c:out value="${ingredient.cost}"/></td>
                <td><c:out value="${ingredient.count}"/></td>
            </tr>
        </c:forEach>
    </table>

    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="addExistIngredient" />
        <fmt:message key="client.label.ingredient" bundle="${msg}" /> id: <input type="text" name="IngredientId">
        <fmt:message key="client.label.count" bundle="${msg}" />: <input type="text" name="IngredientCount">
        <input type="submit" value="<fmt:message key="admin.button.addExistIngredient" bundle="${msg}" />" >
    </form>
    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="addNewIngredient" />
        <fmt:message key="client.label.title" bundle="${msg}" />: <input type="text" name="newIngredientName">
        <fmt:message key="client.label.cost" bundle="${msg}" />: <input type="text" name="newIngredientCost">
        <fmt:message key="client.label.count" bundle="${msg}" />: <input type="text" name="newIngredientCount">
        <input type="submit" value="<fmt:message key="admin.button.addNewIngredient" bundle="${msg}" />" >
    </form>

    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="signOut" />
        <input type="submit" value="<fmt:message key="client.label.signOut" bundle="${msg}" />" >
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>