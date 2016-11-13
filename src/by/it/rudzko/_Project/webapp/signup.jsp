<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="POST">
<fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="username">Username</label>
  <div class="col-md-4">
  <input id="username" name="username" placeholder="unique username" class="form-control input-md" required="" type="text">
  <span class="help-block">Use latin letters and arabic numbers</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" placeholder="password" class="form-control input-md" required="" type="password">
    <span class="help-block">Use at least 6 latin letters and arabic numbers</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="birth">Birth Year</label>
  <div class="col-md-2">
  <input id="birth" name="birth" placeholder="birth year" class="form-control input-md" required="" type="text">
  <span class="help-block">Under 2010</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sex">Sex</label>
  <div class="col-md-2">
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
    <button id="register" name="register" class="btn btn-primary">Create account</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
