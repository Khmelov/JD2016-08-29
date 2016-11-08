<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=SIGNUP" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация нового пользователя</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Role">Роль</label>
            <div class="col-md-4">
                <select id="Role" name="Role" class="form-control">
                    <option value="1">Студент</option>
                    <option value="2">Тьютор</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Name">Имя</label>
            <div class="col-md-4">
                <input id="Name" name="Name" type="text" placeholder="Введите имя..." class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Surname">Фамилия</label>
            <div class="col-md-4">
                <input id="Surname" name="Surname" type="text" placeholder="Введите фамилию..." class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="Введите логин..." class="form-control input-md">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Пароль</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="Введите пароль..." class="form-control input-md">
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button1id"></label>
            <div class="col-md-8">
                <button id="button1id" name="button1id" class="btn btn-success">Зарегистрировать</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>


<%@ include file="include/end-html.jsp" %>
