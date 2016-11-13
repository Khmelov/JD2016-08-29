<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<p align="center">${jsp_message}</p>

<form class="form-horizontal" action="do?command=Catalogue" method="POST">
<fieldset>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="cat">${fullcat}</label>
  <div class="col-md-4">
    <select id="cat" name="cat" class="form-control" multiple="multiple">
          <c:forEach items="${periodicals}" var="periodical">
          <option value="${periodical.ID}">${periodical}</option>
          </c:forEach>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-8 control-label">
  <c:choose>
       <c:when test="${admin}">
            <a href="do?command=Add">
       </c:when>
       <c:otherwise>
            <a href="do?command=Catalogue">
       </c:otherwise>
  </c:choose>
  ${changeview}
  </a>
  </label>
</div>

<c:choose>
<c:when test="${admin}">
      <div class="row">
          <label class="col-md-4 control-label"></label>
          <div class="col-md-2">
              <select id="change" name="change" class="form-control">
                    <option value="1">Edit</option>
                    <option value="2">Delete</option>
              </select>
          </div>
          <div class="col-md-4">
              <button id="update" name="update" class="btn btn-primary">Update</button>
          </div>
      </div>
</c:when>
<c:when test="${user==null}">
    <p align=center>
       <a class="btn btn-primary" href="do?command=Signup" role="button">Register</a>
       <a class="btn btn-info" href="do?command=Login" role="button">Log in</a>
    </p>
</c:when>
<c:otherwise>
<!-- Button -->
    <div class="form-group">
    <label class="col-md-5 control-label" for="subscr"></label>
        <div class="col-md-4">
        <button id="subscr" name="subscr" class="btn btn-primary">Subscribe</button>
        </div>
    </div>
</c:otherwise>
</c:choose>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>