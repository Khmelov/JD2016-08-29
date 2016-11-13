<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=DeleteSub" method="POST">
<fieldset>

<h3>Are you sure you want to delete subscription to</h3>

<h2>${delete_sub.title}?</h2>

<div class="form-group">
<label class="col-md-4"><a href="do?command=Profile">Back to profile</a></label>
</div>
<!-- Button -->
<div class="form-group">
  <div class="col-md-4">
    <button id="delete" name="delete" class="btn btn-primary">Delete</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>