<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=EditUsers" method="POST">
<fieldset>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="olduser">Choose User:</label>
  <div class="col-md-5">
    <select id="olduser" name="olduser" class="form-control">
      <c:forEach items="${fullcat}" var="user">
      <option value="${user.ID}">${user}</option>
      </c:forEach>
      </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="newname">New Username</label>
  <div class="col-md-5">
  <input id="newname" name="newname" placeholder="new username" class="form-control input-md" type="text">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="newrole">New Role</label>
  <div class="col-md-5">
    <select id="newrole" name="newrole" class="form-control">
      <c:forEach items="${roles}" var="role">
            <option value="${role.ID}">${role.participant}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="row">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2">
    <select id="edituser" name="edituser" class="form-control">
      <option value="1">Edit</option>
      <option value="2">Delete</option>
    </select>
  </div>
  <div class="col-md-4">
    <button id="update" name="update" class="btn btn-primary">Update</button>
  </div>
</div>


<div class="form-group">
  <label></label>
</div>
<div class="form-group">
  <label class="col-md-9 control-label">Administrators: ${admins}</label>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>