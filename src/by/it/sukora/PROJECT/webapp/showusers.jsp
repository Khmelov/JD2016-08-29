<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-7>Email</div>
    </b>
   </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из сервлета UserForm -->
   <c:forEach items="${users}" var="user">
        <div class="row">
        <form class="form-horizontal" action=deleteUser method=POST>
            <div class=col-md-1>
                <input id="user_id_${user.id}" name="ID" type="text"
                value="${user.id}" class="form-control input-md">
            </div>
<!--
            <div class=col-md-2>
                <input id="textinput" name="FirsName" type="text"
                value="${user.FirsName}" class="form-control input-md">
            </div>-->
            <div class=col-md-2>
                <input id="textinput" name="LastName" type="text"
                value="${user.lastname}" class="form-control input-md">
            </div>
            <div class=col-md-3>
                             <input id="textinput" name="Email" type="text"
                              value="${user.email}" class="form-control input-md">
                        </div>
            <div class=col-md-1>
                <input id="user_id_logpass_${user.id_logpass}" name="id_logpass" type="text"
                value="${user.id_logpass}" class="form-control input-md">
            </div>
            <div class=col-md-1>
             <input id="user_id_role_${user.id_role}" name="id_logpass" type="text"
             value="${user.id_logpass}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                >
                    Удалить пользователя
                </button>
            </div>

            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Обновить пользователя
                </button>
            </div>
        </form>
        </div>
   <br>
   </c:forEach>



<p>${users}</p>

<%@ include file="include/end-html.jsp" %>
