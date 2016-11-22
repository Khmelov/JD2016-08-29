<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

         <legend>Пофиль пользователя ${user.login}</legend>
                  <c:forEach items="${courses}" var="course">
                     <br />
                     <div class="row">
                       <div class="col-md-1">${name} </div>

                     </div>
                  </c:forEach>
                <br><br>
                <t:paginator step="5" count="${courseCount}" urlprefix="?command=PROFILE&startNumber="/>

                <!-- Button -->
                <br><br><br>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="LogoutButton"></label>
                    <div class="col-md-4">
                        <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Завершить сеанс</button>
                    </div>
                </div>


    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
