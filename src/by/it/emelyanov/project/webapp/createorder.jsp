<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEORDER" method="post">
    <fieldset>

<!-- Form Name -->
<legend>Форма создания заказа</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ID">ID</label>
  <div class="col-md-4">
  <input id="ID" name="ID" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">ID autoincrement</span>
  </div>
</div>

<!-- Text input-->


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Room">FK Room</label>
  <div class="col-md-4">
  <input id="FK_Room" name="FK_Room" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Room id</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Arrive_Date">Arrive Date</label>
  <div class="col-md-4">
  <input id="Arrive_Date" name="Arrive_Date" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">yyyy-mm-dd</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Return_Date">Departure Date</label>
  <div class="col-md-4">
  <input id="Return_Date" name="Return_Date" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">yyyy-mm-dd</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Bill">Text Input</label>
  <div class="col-md-4">
  <input id="Bill" name="Bill" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">help</span>
  </div>
</div>

      <!-- Button -->
      <div class="form-group">
        <label class="col-md-4 control-label" for="singlebutton"></label>
        <div class="col-md-4">
          <button id="singlebutton" name="singlebutton" class="btn btn-primary">Create</button>
        </div>
      </div>

      </fieldset>
      </form>

     <%@ include file="include/end-html.jsp" %>