<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<form class="form-horizontal" action="do?command=SIGNUP" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Sign Up</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"></label>
            <div class="col-md-4">
                <input id="textinput" name="firstName" placeholder="first name" class="form-control input-md" required="" type="text">
                <span class="help-block">Enter your first name</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"></label>
            <div class="col-md-4">
                <input id="textinput" name="lastName" placeholder="last name" class="form-control input-md" required="" type="text">
                <span class="help-block">Enter your last name</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"></label>
            <div class="col-md-4">
                <input id="textinput" name="pasportNumber" placeholder="pasport number" class="form-control input-md" required="" type="text">
                <span class="help-block">Enter your pasport number</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput"></label>
            <div class="col-md-4">
                <input id="passwordinput" name="password" placeholder="password" class="form-control input-md" required="" type="password">
                <span class="help-block">Enter your password</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput"></label>
            <div class="col-md-4">
                <input id="textinput" name="login" placeholder="login" class="form-control input-md" required="" type="text">
                <span class="help-block">Enter your login</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Sign Up</button>
            </div>
        </div>

    </fieldset>
</form>
<%@ include file="footer.jsp" %>