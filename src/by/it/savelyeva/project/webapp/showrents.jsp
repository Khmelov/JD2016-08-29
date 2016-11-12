<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<c:choose>
      <c:when test="${user==null || rentsCount==0}">
          ${message}
      </c:when>
      <c:otherwise>
           <div class="row">
            <b>
              <div class="row">
                 <div class="col-md-1">ID</div>
                 <div class="col-md-1">idCar</div>
                 <c:choose>
                       <c:when test="${user.idRole==1}">
                            <div class="col-md-1">user</div>
                       </c:when>
                 </c:choose>

                 <div class="col-md-3">startDate</div>
                 <div class="col-md-3">endDate</div>
                 <c:choose>
                       <c:when test="${user.idRole==1}">
                             <div class="col-md-2">cost</div>
                             <div class="col-md-1">paid</div>
                       </c:when>
                 </c:choose>
              </div>
            </b>
           </div>
           <br>
     </c:otherwise>
</c:choose>

   <c:forEach items="${rents}" var="rent">
        <div class="row">
        <form class="form-user-${rent.id}" action="do?command=ShowRents" method="POST">
            <div class=col-md-1>
                ${rent.id}
                <input id="rent_id_${rent.id}" name="id" type="hidden"
                value="${rent.id}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                    <select id="idCar" name="idCar" class="form-control">
                        <c:forEach items="${cars}" var="car">
                            <option value="${car.id}" car=${car.id} ${car.id==rent.idCar?"selected":""}>
                                 ${car.id}
                            </option>
                        </c:forEach>
                    </select>
            </div>


             <c:choose>
                   <c:when test="${user.idRole==1}">
                        <div class=col-md-1>
                                <select id="idUser" name="idUser" class="form-control">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.id}" user=${user.id} ${user.id==rent.idUser?"selected":""}>
                                             ${user.login}
                                        </option>
                                    </c:forEach>
                                </select>
                        </div>
                   </c:when>
                   <c:otherwise>

                            <input id="textinput" name="idUser" type="hidden"
                            value="${user.id}" class="form-control input-md">

                   </c:otherwise>
             </c:choose>

            <div class=col-md-2>
                <input id="textinput" name="startDate" type="text"
                value="${rent.startDate}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="endDate" type="text"
                value="${rent.endDate}" class="form-control input-md">
            </div>

<c:choose>
      <c:when test="${user.idRole!=1}">
            <div class=col-md-1>
                <input id="textinput" name="cost" type="hidden"
                value="${rent.cost}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                <input id="textinput" name="paid" type="hidden"
                value="${rent.paid}" class="form-control input-md">
            </div>
      </c:when>
      <c:otherwise>
            <div class=col-md-1>
                <input id="textinput" name="cost" type="text"
                value="${rent.cost}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                <input id="textinput" name="paid" type="text"
                value="${rent.paid}" class="form-control input-md">
            </div>
     </c:otherwise>
</c:choose>
            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Обновить
                </button>
            </div>

            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton"
                class="btn btn-danger"
                onclick="document.getElementById('rent_id_${rent.id}').value=-document.getElementById('rent_id_${rent.id}').value;"
                >
                    Удалить
                </button>
            </div>

        </form>
        </div>
   <br>
   </c:forEach>

<%@ include file="include/end-html.jsp" %>
