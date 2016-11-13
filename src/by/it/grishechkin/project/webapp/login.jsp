<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<form class="form-horizontal" action="/grishechkin/do?command=login" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Login</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"></label>
            <div class="col-md-4">
                <input id="textinput" name="Login" placeholder="login" class="form-control input-md" required="" type="text">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput"></label>
            <div class="col-md-4">
                <input id="passwordinput" name="Password" placeholder="password" class="form-control input-md" required="" type="password">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Login</button>
            </div>
        </div>

    </fieldset>
</form>
<%@ include file="footer.jsp" %>
