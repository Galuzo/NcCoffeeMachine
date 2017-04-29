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
        <h3><fmt:message key="client.label.welcomeRoleUser" bundle="${msg}" /></h3>
            <h1 id="h1_center"><fmt:message key="client.label.assortiment" bundle="${msg}" /></h1>
            <div >
                <table>
                    <caption>
                        <fmt:message key="client.label.beverages" bundle="${msg}" />
                    </caption>
                    <tr>
                        <th> <fmt:message key="client.label.id" bundle="${msg}" /></th>
                        <th> <fmt:message key="client.label.title" bundle="${msg}" /></th>
                        <th> <fmt:message key="client.label.cost" bundle="${msg}" /></th>
                        <th> <fmt:message key="client.label.count" bundle="${msg}" /></th>
                        <th> <fmt:message key="client.label.function" bundle="${msg}" /></th>
                    </tr>
                    <c:forEach items="${beverages}" var="beverage">
                        <tr>
                            <td><c:out value="${beverage.id}"/></td>
                            <td><c:out value="${beverage.title}"/></td>
                            <td><c:out value="${beverage.cost}"/></td>
                            <td><c:out value="${beverage.count}"/></td>
                            <td><form  method="post" action="controller">
                                    <input type="hidden" name="command" value="addBeverageInBill" />
                                    <input type="hidden" name="id" value="${beverage.id}" />
                                    <input type="submit"  value="<fmt:message key="client.button.addBeverageInBill" bundle="${msg}" />" >
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <div>
                <table>
                    <caption>
                        <fmt:message key="client.label.ingredients" bundle="${msg}" />
                    </caption>
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
            </div>
            <table>
                <caption>
                    <fmt:message key="client.label.bill" bundle="${msg}" />
                </caption>
                <tr>
                    <th><fmt:message key="client.label.beverage" bundle="${msg}" /></th>
                    <th><fmt:message key="client.label.ingredient" bundle="${msg}" /></th>
                    <th><fmt:message key="client.label.price" bundle="${msg}" />,$.</th>
                    <th><fmt:message key="client.label.selectIngredient" bundle="${msg}" /></th>
                    <th><fmt:message key="client.label.function" bundle="${msg}" /></th>
                </tr>
                ${ingredientError}
                <c:forEach items="${billMap}" var="beverage">
                    <c:forEach items="${beverage.value}" var="ingredient">
                        <tr>
                            <td>${beverage.key.title}</td>
                            <td>${ingredient.title}</td>
                            <td> <fmt:formatNumber type="number" maxFractionDigits="2" value="${beverage.key.cost + ingredient.cost}"/></td>
                            <c:choose>
                            <c:when test="${ingredient.title eq null}">
                                <form  method="post" action="controller">
                                    <td><select name="selectedIngredient">
                                        <c:forEach items="${ingredients}" var="ingredient">
                                            <option>${ingredient.title}</option>
                                        </c:forEach>
                                    </select></td>
                                    <td>
                                        <input type="hidden" name="command" value="addIngredientInBill" />
                                        <input type="hidden" name="idBeverage" value="${beverage.key.id}" />
                                        <input type="submit"  value="<fmt:message key="client.button.addIngredientInBill" bundle="${msg}" />" >
                                </form>
                                <form  method="post" action="controller">
                                    <input type="hidden" name="command" value="removeBeverageFromBill" />
                                    <input type="hidden" name="idBeverage" value="${beverage.key.id}" />
                                    <input type="hidden" name="idIngredient" value="${ingredient.id}" />
                                    <input type="submit"  value="<fmt:message key="client.button.removeBeverageFromBill" bundle="${msg}" />" >
                                </form>
                                </td>
                            </c:when>
                                <c:otherwise>
                                    <td></td>
                                    <td>
                                        <form  method="post" action="controller">
                                            <input type="hidden" name="command" value="removeIngredientFromBill" />
                                            <input type="hidden" name="idBeverage" value="${beverage.key.id}" />
                                            <input type="hidden" name="idIngredient" value="${ingredient.id}" />
                                            <input type="submit"  value="<fmt:message key="client.button.removeIngredientFromBill" bundle="${msg}" />" >
                                        </form>
                                        <form  method="post" action="controller">
                                            <input type="hidden" name="command" value="removeBeverageFromBill" />
                                            <input type="hidden" name="idBeverage" value="${beverage.key.id}" />
                                            <input type="hidden" name="idIngredient" value="${ingredient.id}" />
                                            <input type="submit"  value="<fmt:message key="client.button.removeBeverageFromBill" bundle="${msg}" />" >
                                        </form>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </table>
            <P id="generalCost"><fmt:message key="client.label.generalCost" bundle="${msg}" />:<fmt:formatNumber type="number" maxFractionDigits="2" value="${generalCost}"/></P>
            <form  id="form" method="post" action="controller">
                <input type="hidden" name="command" value="signOut" />
                <input type="submit" value="<fmt:message key="client.label.signOut" bundle="${msg}" />" >
            </form>
    </div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>