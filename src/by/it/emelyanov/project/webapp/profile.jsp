<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

        <!-- Form Name -->
        <legend>Профиль пользователя</legend>
        <h3>User Data</h3>
        <p>${user}</p>
        <h3>Cookie value</h3>
        <p>${cookie}</p>

 <legend>Заказы ${user.login}</legend>
 <div class="row">
      <b>



          <div class=col-md-3>Дата заселение</div>
          <div class=col-md-3>Дата выселения</div>
          <div class=col-md-3>Счет</div>
          <div class=col-md-3>Номер</div>
      </b>
     </div>
     <br>
          <c:forEach items="${orders}" var="order">
             <br />
             <div class="row">
               <div class="col-md-3">${order.arrive_Date} </div>
               <div class="col-md-3">${order.return_Date}</div>
               <div class="col-md-3">${order.bill}</div>
             <div class=col-md-3>
             <select id="room_number" name="fk_Room" class="form-control">
             <c:forEach items="${rooms}" var="room">
             <option value="${room.id}" room=${room.id} ${room.id==order.fK_Room?"selected":""}>
             ${room.room_Number}
             </option>
             </c:forEach>
             </select>
             </div>

             </div>
          </c:forEach>
        <br><br>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Завершить сеанс</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
