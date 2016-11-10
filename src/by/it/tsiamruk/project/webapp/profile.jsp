<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

        <!-- Form Name -->
        <legend>Профиль пользователя, пожалуйста заполните поля для продолжения.</legend>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Name">Имя</label>
                    <div class="col-md-4">
                        <input id="name" name="Name" type="text" value="" placeholder="Имя" class="form-control input-md" required="">
                        <span class="help-block">Имя</span>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Lastname">Фамилия</label>
                    <div class="col-md-4">
                        <input id="lastname" name="Lastname" type="text" value="" placeholder="Фамилия" class="form-control input-md" required="">
                        <span class="help-block">Фамилия</span>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Age">Возраст</label>
                    <div class="col-md-4">
                        <input id="age" name="Age" type="text" value="" placeholder="Возраст" class="form-control input-md" required="">
                        <span class="help-block">Возраст</span>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="singlebutton" value="1" class="btn btn-success">Заполнить профиль</button>
                    </div>
                </div>

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
