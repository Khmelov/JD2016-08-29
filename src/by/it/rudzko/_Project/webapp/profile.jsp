<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<h2>Hello, ${user.name}!</h2>

<c:choose>
    <c:when test="${admin}">
        <p>${Readership_changed}</p>
        <p>You have added ${myadds} periodicals to <a href="do?command=Catalogue">catalogue</a>.</p>
        <p>You can update or delete them at any time.</p>
        <p>Follow next links to change other sections:</p>
        <p><a href="do?command=EditReadership">Edit Readership</a></p>
        <p><a href="do?command=EditUsers">Check Users</a></p>
    </c:when>
    <c:otherwise>
        <p>You are subscribed to ${myadds} periodicals.</p>
        <p></p>
        <p>If you want to remove any subscription just choose a periodical and press DELETE</p>

        <div class="row">
          <div class="col-md-5">
            <select id="subscr" name="subscr" class="form-control">
              <c:forEach items="${subscription}" var="periodical">
                <option value="${periodical.ID}">${periodical}</option>
              </c:forEach>
            </select>
          </div>
          <div class="col-md-4">
              <button id="delete" name="delete" value="2" class="btn btn-primary">DELETE</button>
          </div>
        </div>
    <p></p>
    <p>You also can subscribe to other periodicals from <a href="do?command=Catalogue">catalogue</a>.</p>
</c:otherwise>
</c:choose>


 <!-- Button -->
 <div class="form-group">
   <label class="col-md-4 control-label" for="logout"></label>
   <div class="col-md-4">
     <button id="logout" name="logout" value="1" class="btn btn-primary">Log out</button>
   </div>
 </div>
</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
