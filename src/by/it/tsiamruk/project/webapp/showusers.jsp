<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<table align="center" border ="1">
  <c:forEach var="user" items="${user.user}">
  <tr>
    <td>${user.login}</td>
    <td>${user.ID}</td>
    <td>${user.role}</td>
  </tr>
  </c:forEach>
</table>

<%@ include file="include/end-html.jsp" %>