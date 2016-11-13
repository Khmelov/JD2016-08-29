<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<form class="form-horizontal" action="/grishechkin/do?command=ADMIN" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Admin Panel</legend>

        <!-- Multiple Radios -->
        <div class="form-group">
            <label class="col-md-4 control-label">Select Auto</label>
            <!--<div class="col-md-4">-->
                <c:forEach items="${orders}" var="order">
                    <c:if test="${order.refund==0}">
                        <div class="radio" style="width: 600px;">
                            <label for="radios-${order.ID}">
                                <input name="orderID" id="radios-${order.ID}" value="${order.ID}" type="radio">
                                <div class="row">
                                    <div class="col-md-3">${order.term} </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${autos}" var="auto" end="1">
                                            <c:if test="${auto.ID==order.FK_Auto}">
                                                ${auto.mark}
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-1">
                                        <c:forEach items="${autos}" var="auto" end="1">
                                            <c:if test="${auto.ID==order.FK_Auto}">
                                                ${auto.model}
                                            </c:if>
                                        </c:forEach>
                                    </div>

                                    <div class="col-md-1">
                                        <c:forEach items="${autos}" var="auto" end="1">
                                            <c:if test="${auto.ID==order.FK_Auto}">
                                                ${auto.year}
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="col-md-2">${order.pay==1?"Оплачено":"Не оплачено"}</div>
                                    <div class="col-md-4">${order.refund==1?"Возвращена":"Не возвращена"}</div>
                                </div>
                            </label>
                        </div>
                    </c:if>
                </c:forEach>
           <!-- </div>-->
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Refund</button>
            </div>
        </div>

        <div class=col-md-1>
            <button id="singlebutton" name="singlebutton" class="btn btn-success" style="margin-top: -85px; margin-left: 500px;">
                Обновить
            </button>
        </div>

    </fieldset>
</form>
<%@ include file="footer.jsp" %>