<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <b>
        <div class=col-md-2>Фамилия</div>
        <div class=col-md-2>Имя</div>
        <div class="col-md-1">Логин</div>
        <div class=col-md-1>Пароль</div>
        <div class="col-md-1">Баллы</div>
        <div class="col-md-2">Роль</div>
        <div class=col-md-1></div>
        <div class=col-md-1></div>
    </b>
</div>
<br>
<c:forEach items="${users}" var="user">
    <div class="row">
        <form class="form-user-${user.ID}" action="do?command=ShowUsers" method=POST>
            <div class=col-md-2>
                <input id="textinput" name="Surname" type="text" value="${user.surname}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Name" type="text" value="${user.name}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="textinput" name="Login" type="text" value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="textinput" name="Password" type="text" value="${user.password}" class="form-control input-md">
            </div>
            <div class="col-md-1">
                <input id="textinput" name="Balls" type="text" value="${user.balls}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <select id="role" name="fk_Role" class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.ID}" role=${role.ID} ${role.ID==user.FK_ROLE?"selected":""}>
                                ${role.role_name}
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
                        onclick="document.getElementById('user_id_${user.ID}').value=-document.getElementById('user_id_${user.ID}').value;"
                >
                    Удалить
                </button>
            </div>
            <div class=col-md-1>
                <input id="user_id_${user.ID}" name="ID" type="hidden"
                       value="${user.ID}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="test_id_${user.tests_amount}" name="Tests" type="hidden"
                       value="${user.tests_amount}" class="form-control input-md">
            </div>

        </form>
    </div>
</c:forEach>
<br>
<%@ include file="include/end-html.jsp" %>
