<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SHOWUSERS" method="GET">
<legend>Список пользователей(только для администора)</legend>

<div>
        <ul class="border">
          <li>${users}${accounts}</li>
          <li>${users}${accounts}</li>
          <li>${users}${accounts}</li>
          <li>${users}${accounts}</li>
        </ul>
</div>

</form>

<%@ include file="include/end-html.jsp" %>