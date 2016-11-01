<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" style="width: 30%">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Birth Year</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" placeholder="birth year" class="form-control input-md" required="" type="text">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Username</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" placeholder="username" class="form-control input-md" required="" type="text">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" placeholder="password" class="form-control input-md" required="" type="password">

  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="radios">Sex</label>
  <div class="col-md-4">
    <label class="radio-inline" for="radios-0">
      <input name="radios" id="radios-0" value="1" checked="checked" type="radio">
      Male
    </label>
    <label class="radio-inline" for="radios-1">
      <input name="radios" id="radios-1" value="2" type="radio">
      Female
    </label>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-info">Register</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>


