<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<jsp:include page="/META-INF/templates/head.jsp" />
<body>
<jsp:include page="/META-INF/templates/header.jsp" />
<div class="content">
    <h3 id="role">${user.login},Вы вошли в систему как администратор</h3>
    <jsp:useBean id="coffeemachine" class="by.training.nc.dev3.services.CoffeeMachineService" scope="page"/>
    <c:set var="beverages" value="${coffeemachine.beveragesInMachine}" />
    <c:set var="ingredients" value="${coffeemachine.ingredientsInMachine}" />
    <h3>Beverages</h3>
    <table>
    <tr>
        <th>id</th><th>Title</th><th>Cost</th><th>Count</th>
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
        Beverage id: <input type="text" name="beverageId">
        Count: <input type="text" name="beverageCount">
        <input type="submit" value="Add exist Beverage" >
    </form>
    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="addNewBeverage" />
        Title: <input type="text" name="newBeverageName">
        Cost: <input type="text" name="newBeverageCost">
        Count: <input type="text" name="newBeverageCount">
        <input type="submit" value="Add new Beverage" >
    </form>

    <h3>Ingredients</h3>
    <table>
        <tr>
            <th>id</th><th>Title</th><th>Cost</th><th>Count</th>
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
        Ingredient id: <input type="text" name="IngredientId">
        Count: <input type="text" name="IngredientCount">
        <input type="submit" value="Add exist Ingredient" >
    </form>
    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="addNewIngredient" />
        Title: <input type="text" name="newIngredientName">
        Cost: <input type="text" name="newIngredientCost">
        Count: <input type="text" name="newIngredientCount">
        <input type="submit" value="Add new Ingredient" >
    </form>

    <form  id="form" method="post" action="controller">
        <input type="hidden" name="command" value="signOut" />
        <input type="submit" value="Sign Out" >
    </form>
</div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>