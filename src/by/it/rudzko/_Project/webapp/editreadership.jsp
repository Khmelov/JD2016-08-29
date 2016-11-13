<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=EditReadership" method="POST">
<fieldset>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="oldaud">Choose to update:</label>
  <div class="col-md-5">
    <select id="oldaud" name="oldaud" class="form-control">
      <option value=0>-----</option>
      <c:forEach items="${readership}" var="audience">
      <option value="${audience.ID}">${audience.group}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="newaud">New readership</label>
  <div class="col-md-5">
  <input id="newaud" name="newaud" placeholder="new readership" class="form-control input-md" type="text">

  </div>
</div>

<!-- Select Basic -->
<div class="row">
  <label class="col-md-4 control-label" for="editaud"></label>
  <div class="col-md-2">
    <select id="editaud" name="editaud" class="form-control">
      <option value="1">Add</option>
      <option value="2">Edit</option>
      <option value="3">Delete</option>
    </select>
  </div>
  <div class="col-md-4">
      <button id="update" name="update" class="btn btn-primary">Update</button>
    </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>