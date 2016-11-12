<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
     <b>
         <div class=col-md-1>ID</div>
         <div class=col-md-2>Этаж</div>
         <div class=col-md-2>Номер</div>
         <div class=col-md-2>Стоимость</div>
         <div class=col-md-5>Тип</div>
     </b>
    </div>
    <br>

    <c:forEach items="${rooms}" var="room">
             <div class="row">
             <form class="form-room-${room.id}" action="do?command=ShowApartments" method=POST>

                <div class=col-md-1>
                    <input id="room_id_${room.id}" name="ID" type="text"
                    value="${room.id}" class="form-control input-md">
                    </div>

             <div class=col-md-2>
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
             <div class=col-md-3>
             <select id="room_number" name="fK_Type" class="form-control">
             <c:forEach items="${types}" var="type">
             <option value="${type.id}" type=${type.id} ${type.id==room.fK_Type?"selected":""}>
             ${type.room_type}
             </option>
             </c:forEach>
             </select>
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
