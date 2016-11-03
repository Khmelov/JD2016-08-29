<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

    <form class="form-horizontal" action="do?command=CREATEACCOUNT" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Подтверждение платежа</legend>

            <!-- Text input-->
            <div class="form-group">
                  <label class="col-md-4 control-label" for="amount">Введите сумму</label>
                  <div class="col-md-4">
                  <input id="amount" name="amount" type="text" placeholder="01234" class="form-control input-md" required="">
                  <span class="help-block">введите сумму для пополнения счет</span>
                  </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="password">Password</label>
              <div class="col-md-4">
                <input id="Password" name="Password" type="password" placeholder="password" class="form-control input-md" required="">
                <span class="help-block">Введите пароль для подтверждения создания счета</span>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Создать счет</button>
                </div>
            </div>

        </fieldset>
    </form>

<%@ include file="include/end-html.jsp" %>