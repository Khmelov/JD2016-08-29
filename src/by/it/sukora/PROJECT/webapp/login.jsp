<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=LOGIN" method="POST">

<fieldset>

<!-- Form Name -->
<legend>Authorization</legend>

<!-- Text input-->
<div class="form-group">
  
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-2">
  <input id="login" name="login" type="text" placeholder="login" class="form-control input-md">
    
  </div>
</div>
<br>
<!-- Appended checkbox -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password</label>
  <div class="col-md-2">
    <div class="input-group">
      <input id="password" name="password" class="form-control" type="text" placeholder="password">
	        <span class="input-group-addon">     
          <input type="checkbox">     
      </span>
    </div>
    
  </div>
</div>
<br>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="in"></label>
  <div class="col-md-4">
    <button id="in" name="in" class="btn btn-primary">LogIn</button>
  </div>
</div>

</fieldset>
</form>



<%@ include file="include/end-html.jsp" %>