<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<c:choose>
      <c:when test="${user.idRole!=1}">
          ${message}
      </c:when>
      <c:otherwise>
           <div class="row">
            <b>
              <div class="row">
                 <div class="col-md-1">ID</div>
                 <div class="col-md-1">login</div>
                 <div class="col-md-1">password</div>
                 <div class="col-md-2">email</div>
                 <div class="col-md-1">idRole</div>
                 <div class="col-md-1">firstName</div>
                 <div class="col-md-1">lastName</div>
                 <div class="col-md-1">middleName</div>
                 <div class="col-md-1">dateOfBirth</div>
                 <div class="col-md-1">idSex</div>
                 <div class="col-md-1">passport</div>
              </div>
            </b>
           </div>
           <br>
     </c:otherwise>
</c:choose>

   <c:forEach items="${users}" var="user">
        <div class="row">
        <form class="form-user-${user.id}" action="do?command=ShowUsers" method="POST">
            <div class=col-md-1>
                ${user.id}
                <input id="user_id_${user.id}" name="id" type="hidden"
                value="${user.id}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="textinput" name="login" type="text"
                value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="textinput" name="password" type="text"
                value="${user.password}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="email" type="text"
                value="${user.email}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                    <select id="idRole" name="idRole" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.idRole?"selected":""}>
                                 ${role.role}
                            </option>
                        </c:forEach>
                    </select>
            </div>

            <div class=col-md-1>
                <input id="textinput" name="firstName" type="text"
                value="${user.firstName}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                <input id="textinput" name="lastName" type="text"
                value="${user.lastName}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                <input id="textinput" name="middleName" type="text"
                value="${user.middleName}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                <input id="textinput" name="dateOfBirth" type="text"
                value="${user.dateOfBirth}" class="form-control input-md">
            </div>

            <div class=col-md-1>
                    <select id="idSex" name="idSex" class="form-control">
                        <c:forEach items="${sex}" var="sex">
                            <option value="${sex.id}" sex=${sex.id} ${sex.id==user.idSex?"selected":""}>
                                 ${sex.type}
                            </option>
                        </c:forEach>
                    </select>
            </div>


            <div class=col-md-1>
                <input id="textinput" name="passport" type="text"
                value="${user.passport}" class="form-control input-md">
            </div>


        <input id="idAddress" name="idAddress" value="0" type="hidden"
         placeholder="" class="form-control input-md" required="">

        <input id="idDriverLicense" name="idDriverLicense" value="${user.idDriverLicense}" type="hidden"
        placeholder="" class="form-control input-md" required="">



            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Обновить
                </button>
            </div>

            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton"
                class="btn btn-danger"
                onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                >
                    Удалить
                </button>
            </div>

        </form>
        </div>
   <br>
   </c:forEach>

<%@ include file="include/end-html.jsp" %>