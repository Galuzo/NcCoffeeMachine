<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/META-INF/templates/head.jsp" />
<body>
    <jsp:include page="/META-INF/templates/header.jsp" />
    <div class="content">
        <h3>${user.login},Вы вошли в систему как пользователь</h3>
            <h1 id="h1_center">Assortiment</h1>
            <div >
                <table>
                    <caption>
                        Beverages
                    </caption>
                    <tr>
                        <th>id</th><th>Title</th><th>Cost</th><th>Count</th><th>Function</th>
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
                                    <input type="submit"  value="Add beverage in bill" >
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <div>
                <table>
                    <caption>
                        Ingredients
                    </caption>
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
            </div>
            <table>
                <caption>
                    Bill
                </caption>
                <tr>
                    <th>Beverage</th>
                    <th>Ingredient</th>
                    <th>Price,$.</th>
                    <th>Select Ingredient</th>
                    <th>Function</th>
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
                                        <input type="submit"  value="Add ingredient in bill" >
                                </form>
                                <form  method="post" action="controller">
                                    <input type="hidden" name="command" value="removeBeverageFromBill" />
                                    <input type="hidden" name="idBeverage" value="${beverage.key.id}" />
                                    <input type="hidden" name="idIngredient" value="${ingredient.id}" />
                                    <input type="submit"  value="Remove beverage" >
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
                                            <input type="submit"  value="Remove ingredient" >
                                        </form>
                                        <form  method="post" action="controller">
                                            <input type="hidden" name="command" value="removeBeverageFromBill" />
                                            <input type="hidden" name="idBeverage" value="${beverage.key.id}" />
                                            <input type="hidden" name="idIngredient" value="${ingredient.id}" />
                                            <input type="submit"  value="Remove beverage" >
                                        </form>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </table>
            <P id="generalCost">General cost:<fmt:formatNumber type="number" maxFractionDigits="2" value="${generalCost}"/></P>
            <form  id="form" method="post" action="controller">
                <input type="hidden" name="command" value="signOut" />
                <input type="submit" value="Sign Out" >
            </form>
    </div>
</body>
<jsp:include page="/META-INF/templates/footer.jsp" />
</html>