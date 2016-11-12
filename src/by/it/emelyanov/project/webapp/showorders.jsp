<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
     <b>
         <div class=col-md-1>ID</div>
         <div class=col-md-2>Login</div>
         <div class=col-md-2>Номер</div>
         <div class=col-md-2>Дата заселение</div>
         <div class=col-md-2>Дата выселения</div>
         <div class=col-md-3>Счет</div>
     </b>
    </div>
    <br>

    <c:forEach items="${orders}" var="order">
         <div class="row">
         <form class="form-order-${order.id}" action="do?command=ShowOrders" method=POST>

             <div class=col-md-1>
                 <input id="order_id_${order.id}" name="ID" type="text"
                 value="${order.id}" class="form-control input-md">
             </div>

             <div class=col-md-2>
              <select id="login" name="fk_User" class="form-control">
              <c:forEach items="${users}" var="user">
              <option value="${user.id}" user=${user.id} ${user.id==order.fK_User?"selected":""}>
              ${user.login}
              </option>
              </c:forEach>
              </select>
             </div>

             <div class=col-md-2>
             <select id="room_number" name="fk_Room" class="form-control">
             <c:forEach items="${rooms}" var="room">
             <option value="${room.id}" room=${room.id} ${room.id==order.fK_Room?"selected":""}>
             ${room.room_Number}
             </option>
             </c:forEach>
             </select>
             </div>

             <div class=col-md-2>
                 <input id="textinput" name="Arrive_Date" type="text"
                 value="${order.arrive_Date}" class="form-control input-md">
             </div>

             <div class=col-md-2>
                  <input id="textinput" name="Return_Date" type="text"
                  value="${order.return_Date}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                  <input id="textinput" name="Bill" type="text"
                  value="${order.bill}" class="form-control input-md">
             </div>

             <div class=col-md-1>
                 <button id="singlebutton" name="singlebutton" class="btn btn-success">
                     Обновить
                 </button>
             </div>

             <div class=col-md-1>
                 <button id="singlebutton" name="singlebutton"
                 class="btn btn-danger"
                 onclick="
                 document.getElementById('user_id_${user.id}').value=
                 -document.getElementById('user_id_${user.id}').value;
                 ">
                     Удалить
                 </button>
             </div>

         </form>
         </div>
    <br>
    </c:forEach>


<%@ include file="include/end-html.jsp" %>
