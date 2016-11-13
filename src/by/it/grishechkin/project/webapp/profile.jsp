<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

 <fieldset>

  <!-- Form Name -->
  <legend>Заказы ${user.login}</legend>
  <c:forEach items="${orders}" var="order">
    <div class="radio" style="width: 800px;">
     <label for="radios-${order.ID}">
      <input name="orderID" id="radios-${order.ID}" value="${order.ID}" type="radio">
      <div class="row">
       <div class="col-md-1">${order.term} </div>
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
       <div class="col-md-4">${order.pay==1?"Оплачено":"Не оплачено"}</div>
       <div class="col-md-4">${order.refund==1?"Возвращена":"Не возвращена"}</div>
      </div>
     </label>
    </div>
  </c:forEach>
  <br><br>
  <t:paginator step="5" count="${orderCount}" urlprefix="?command=PROFILE&startNumber="/>

  <!-- Button -->
  <br><br><br>
  <div class="form-group">
   <label class="col-md-1 control-label" for="LogoutButton"></label>
   <div class="col-md-2">
    <button id="LogoutButton" class="btn btn-success" formmethod="get">Завершить сеанс</button>
   </div>
   <div class="col-md-2">
   <button id="CreateOrder" class="btn btn-success" formaction="do?command=CREATEORDER">Оформить заказ</button>
   </div>
   <div class="col-md-2">
    <button id="PayOrder" class="btn btn-success" formaction="do?command=PAYORDER">Оплатить заказ</button>
   </div>
   <div class="col-md-2">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Обновить</button>   </div>
  </div>

 </fieldset>
</form>

<%@ include file="footer.jsp" %>
