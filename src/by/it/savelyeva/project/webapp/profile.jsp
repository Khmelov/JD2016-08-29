<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<!--h4>Что реализовано:</h4>
<p><ul>
<li>Текущий пользователь редактируется, в случае успеха - открывается страница с сообщением.
Но т.к. не работает русская кодировка (хотя фильтр кодировки реализован),
то редактируется всегда пользователь,
который на латинице - например, с id=7
(список пользователей <a href="http://localhost:28080/savelyeva/do?command=ShowUsers">здесь</a>)</li>
<li>id пользователя - скрытое поле - значение из сессии</li>
</ul>
<h4>Что НЕ реализовано (TODO):</h4>
<p><ul>
<li>ВАЖНО: не работает фильтр кодировки (поэтому валидацию проходят только значения на латинице)</li>
<li>нет проверки, есть ли уже такой пользователь в базе</li>
<li>в форме не указываются адрес и водительские права (есть справочники, но с ними очень долго, снова же - будет через AJAX, а на проверку нужно показывать JAVA, поэтому пока не реализовывала) - по умолчанию ставится 0 и ZZ000000 соответственно</li>
<li>Пароли хранятся в чистом виде (пока)</li>
</ul-->

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>


        <!-- Form Name -->
        <legend>Профиль пользователя</legend>

        <input id="id" name="id" value="${user.id}" type="hidden"
         placeholder="" class="form-control input-md" required="">

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" value="${user.login}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" value="${user.password}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль не менее 8 символов</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">E-mail</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" value="${user.email}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите E-mail</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="lastName">Фамилия</label>
            <div class="col-md-4">
                <input id="lastName" name="lastName" type="text" value="${user.lastName}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите фамилию</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="firstName">Имя</label>
            <div class="col-md-4">
                <input id="firstName" name="firstName" type="text" value="${user.firstName}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите имя</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="middleName">Отчество</label>
            <div class="col-md-4">
                <input id="middleName" name="middleName" type="text" value="${user.middleName}" placeholder="" class="form-control input-md">
                <span class="help-block">Укажите отчество</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passport">Паспорт</label>
            <div class="col-md-4">
                <input id="passport" name="passport" type="text" value="${user.passport}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите серию и номер паспорта</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="dateOfBirth">Дата рождения</label>
            <div class="col-md-4">
                <input id="dateOfBirth" name="dateOfBirth" type="text" value="${user.dateOfBirth}" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите дату рождения (гггг-мм-дд)</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="idSex">Пол</label>
             <div class="col-md-4">
                 <select id="idSex" name="idSex" class="form-control">
                       <c:forEach items="${sex}" var="sex">
                            <option value="${sex.id}" sex=${sex.id} ${sex.id==user.idSex?"selected":""}>
                                ${sex.type}
                            </option>
                       </c:forEach>
                  </select>
              </div>
        </div>

        <input id="idAddress" name="idAddress" value="0" type="hidden"
         placeholder="" class="form-control input-md" required="">

        <input id="idDriverLicense" name="idDriverLicense" value="${user.idDriverLicense}" type="hidden"
        placeholder="" class="form-control input-md" required="">

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Сохранить изменения</button>
            </div>
        </div>

    </fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
