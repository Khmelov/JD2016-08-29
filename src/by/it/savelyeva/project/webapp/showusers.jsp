<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <div class="row">
         <div class="col-md-1">ID</div>
         <div class="col-md-1">login</div>
         <div class="col-md-1">password</div>
         <div class="col-md-2">email</div>
         <div class="col-md-1">idRole</div>
         <div class="col-md-1">firstName</div>
         <div class="col-md-1">lastName</div>
         <div class="col-md-1">middleName</div>
         <div class="col-md-1">dateOfBirth</div>
         <div class="col-md-1">idSex</div>
         <div class="col-md-1">passport</div>
      </div>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach items="${users}" var="user">
         <div class="row">
            <div class="col-md-1">${user.id}</div>
            <div class="col-md-1">${user.login}</div>
            <div class="col-md-1">${user.password}</div>
            <div class="col-md-2">${user.email}</div>
            <div class="col-md-1">${user.idRole}</div>
            <div class="col-md-1">${user.firstName}</div>
            <div class="col-md-1">${user.lastName}</div>
            <div class="col-md-1">${user.middleName}</div>
            <div class="col-md-1">${user.dateOfBirth}</div>
            <div class="col-md-1">${user.idSex}</div>
            <div class="col-md-1">${user.passport}</div>
         </div>
    </c:forEach>

<%@ include file="include/end-html.jsp" %>