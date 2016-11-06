<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <div class="row">
         <div class="col-md-1">ID</div>
         <div class="col-md-1">idCar</div>
         <div class="col-md-1">idUser</div>
         <div class="col-md-3">startDate</div>
         <div class="col-md-3">endDate</div>
         <div class="col-md-2">cost</div>
         <div class="col-md-1">paid</div>
      </div>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach items="${rents}" var="rent">
         <div class="row">
             <div class="col-md-1">${rent.id}</div>
             <div class="col-md-1">${rent.idCar}</div>
             <div class="col-md-1">${rent.idUser}</div>
             <div class="col-md-3">${rent.startDate}</div>
             <div class="col-md-3">${rent.endDate}</div>
             <div class="col-md-2">${rent.cost} USD</div>
             <div class="col-md-1">${rent.paid}</div>
         </div>
    </c:forEach>


<%@ include file="include/end-html.jsp" %>
