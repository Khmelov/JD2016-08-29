<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



<form class="form-horizontal" action="do?command=Catalogue" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Catalogue</legend>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="cat">Subscribe to:</label>
  <div class="col-md-8">
    <select id="cat" name="cat" class="form-control" multiple="multiple">
          ${periodicals}
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="subscr"></label>
  <div class="col-md-4">
    <button id="subscr" name="subscr" class="btn btn-info">Subscribe</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>