<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="row">
     <b>
         <div class=col-md-1>Этаж</div>
         <div class=col-md-2>Номер</div>
         <div class=col-md-2>Стоимость</div>
         <div class=col-md-2>Тип</div>
     </b>
    </div>
    <br>

    <c:forEach items="${rooms}" var="room">
         <div class="row">
         <form class="form-room-${room.id}" action="do?command=Index" method=POST>

             <div class=col-md-1>
                 <input id="room_floor_${room.floor}" name="Room" type="text"
                 value="${room.floor}" class="form-control input-md">
             </div>


             <div class=col-md-2>
                 <input id="textinput" name="Room_Number" type="text"
                 value="${room.room_Number}" class="form-control input-md">
             </div>

             <div class=col-md-2>
                  <input id="textinput" name="Cost" type="text"
                  value="${room.cost}" class="form-control input-md">
             </div>
             <div class=col-md-2>
             <select id="room_number" name="fK_Type" class="form-control">
             <c:forEach items="${types}" var="type">
             <option value="${type.id}" type=${type.id} ${type.id==room.fK_Type?"selected":""}>
             ${type.room_type}
             </option>
             </c:forEach>
             </select>
             </div>

         </form>
         </div>
    <br>
    </c:forEach>


<%@ include file="include/end-html.jsp" %>
