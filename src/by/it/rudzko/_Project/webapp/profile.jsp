<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>My Profile</legend>

 ${subscription}
 ${addlink}

 <!-- Button -->
 <div class="form-group">
   <label class="col-md-4 control-label" for="logout"></label>
   <div class="col-md-4">
     <button id="logout" name="logout" value="1" class="btn btn-warning">Log out</button>
   </div>
 </div>
</fieldset>
</form>
<%@ include file="include/end-html.jsp" %>
