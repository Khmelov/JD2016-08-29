<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<h4>Что реализовано:</h4>
<p><ul>
<li>Пользователи добавляются в базу (список <a href="http://localhost:28080/savelyeva/do?command=ShowUsers">здесь</a>)</li>
<li>id пользователя - скрытое поле</li>
</ul>
<h4>Что НЕ реализовано (TODO):</h4>
<p><ul>
<li>ВАЖНО: не реализован еще фильтр кодировки (поэтому валидацию проходят только значения на латинице)</li>
<li>нет проверки, есть ли уже такой пользователь в базе</li>
<li>в форме не указываются адрес и водительские права (есть справочники, но с ними очень долго, снова же - будет через AJAX, а на проверку нужно показывать JAVA, поэтому пока не реализовывала) - по умолчанию ставится 0 и ZZ000000 соответственно</li>
<li>Форма не вытаскивает значения полов из базы - указаны сразу в select (но можно так и оставить)</li>
<li>Пароли хранятся в чистом виде (пока)</li>
</ul>

<form class="form-horizontal" action="do?command=SIGNUP" method="POST">
    <fieldset>
        <input id="id" name="id" value="0" type="hidden"
         placeholder="" class="form-control input-md" required="">


        <!-- Form Name -->
        <legend>Регистрация нового пользователя</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" value="ivan12345" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" value="ivan12345" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль не менее 8 символов</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">E-mail</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" value="email@gmail.com" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите E-mail</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="lastName">Фамилия</label>
            <div class="col-md-4">
                <input id="lastName" name="lastName" type="text" value="Ivanov" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите фамилию</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="firstName">Имя</label>
            <div class="col-md-4">
                <input id="firstName" name="firstName" type="text" value="Ivan" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите имя</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="middleName">Отчество</label>
            <div class="col-md-4">
                <input id="middleName" name="middleName" type="text" value="" placeholder="" class="form-control input-md">
                <span class="help-block">Укажите отчество</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passport">Паспорт</label>
            <div class="col-md-4">
                <input id="passport" name="passport" type="text" value="AZ010101" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите серию и номер паспорта</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="dateOfBirth">Дата рождения</label>
            <div class="col-md-4">
                <input id="dateOfBirth" name="dateOfBirth" type="text" value="1990-12-21" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите дату рождения (гггг-мм-дд)</span>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="idSex">Пол</label>
            <div class="col-md-4">
                <select id="idSex" name="idSex" class="form-control">
                    <option value="1">Male</option>
                    <option value="2">Female</option>
                    <option value="3">Transgendered to Male</option>
                    <option value="4">Transgendered to Female</option>
                </select>
            </div>
        </div>

        <input id="idAddress" name="idAddress" value="0" type="hidden"
         placeholder="" class="form-control input-md" required="">

        <input id="idDriverLicense" name="idDriverLicense" value="ZZ000000" type="hidden"
        placeholder="" class="form-control input-md" required="">

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
