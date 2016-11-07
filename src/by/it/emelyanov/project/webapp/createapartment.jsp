<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAPARTMENT" method="post">
    <fieldset>

      <!-- Form Name -->
      <legend>Form Name</legend>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="ID">ID</label>
        <div class="col-md-4">
        <input id="id" name="ID" type="text" placeholder="" class="form-control input-md">
        <span class="help-block">ID autoincrement</span>
        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="Floor">Floor</label>
        <div class="col-md-4">
        <input id="Floor" name="Floor" type="text" placeholder="placeholder" class="form-control input-md">
        <span class="help-block"></span>
        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="Room_Number">Room Number</label>
        <div class="col-md-4">
        <input id="Room_Number" name="Room_Number" type="text" placeholder="placeholder" class="form-control input-md">
        <span class="help-block"></span>
        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="Cost">Cost</label>
        <div class="col-md-4">
        <input id="Cost" name="Cost" type="text" placeholder="placeholder" class="form-control input-md">
        <span class="help-block"></span>
        </div>
      </div>

      <!-- Select Basic -->
      <div class="form-group">
        <label class="col-md-4 control-label" for="FK_Type">Room Type</label>
        <div class="col-md-4">
          <select id="FK_Type" name="FK_Type" class="form-control">
            <option value="1">Single Room</option>
            <option value="2">Double Room</option>
            <option value="3">Twin Room</option>
            <option value="4">Double Double Room</option>
          </select>
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
