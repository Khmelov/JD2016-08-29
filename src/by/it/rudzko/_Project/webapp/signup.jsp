<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal" action="do?command=SIGNUP" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Registration</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="username">Username</label>
  <div class="col-md-8">
  <input id="username" name="username" placeholder="unique username" class="form-control input-md" required="" type="text">
  <span class="help-block">Use latin letters and arabic numbers. Length min=3, max=25</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-8">
    <input id="password" name="password" placeholder="password" class="form-control input-md" required="" type="password">
    <span class="help-block">Use latin letters and arabic numbers. Length min=6, max=25</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="birth">Birth Year</label>
  <div class="col-md-5">
  <input id="birth" name="birth" placeholder="birth year" class="form-control input-md" required="" type="text">
  <span class="help-block">Format 19?? or 200?</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sex">Sex</label>
  <div class="col-md-5">
    <select id="sex" name="sex" class="form-control">
      <option value="1">Male</option>
      <option value="2">Female</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="register"></label>
  <div class="col-md-4">
    <button id="register" name="register" class="btn btn-info">Create account</button>
  </div>
</div>

</fieldset>
</form>



<%@ include file="include/end-html.jsp" %>
