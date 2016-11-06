<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Add" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Create Periodical</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="title">Title</label>
  <div class="col-md-8">
  <input id="title" name="title" placeholder="title of media" class="form-control input-md" required="" type="text">
  <span class="help-block">Use cyrillic letters. Max = 3 words</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="index">Index</label>
  <div class="col-md-5">
  <input id="index" name="index" placeholder="index of media" class="form-control input-md" required="" type="text">
  <span class="help-block">Five numbers</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="aud">Readership</label>
  <div class="col-md-5">
    <select id="aud" name="aud" class="form-control">
      ${readership}
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="add"></label>
  <div class="col-md-4">
    <button id="add" name="add" class="btn btn-primary">Add to catalogue</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
