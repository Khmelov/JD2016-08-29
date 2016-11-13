<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

    <form class="form-horizontal" action="do?command=CREATEACCOUNT" method="POST">
        <fieldset>

            <!-- Form Name -->
            <legend>Подтверждение платежа</legend>
                    <div>${user}</div>

            <!-- Text input-->
            <div class="form-group">
                  <label class="col-md-4 control-label" for="Amount">Введите сумму</label>
                  <div class="col-md-4">
                  <input id="amount" name="Amount" type="text" placeholder="01234" class="form-control input-md" required="">
                  <span class="help-block">введите сумму для пополнения счет</span>
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