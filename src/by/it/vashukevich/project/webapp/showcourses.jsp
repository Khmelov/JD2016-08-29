<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


   <div class="row">
    <b>
        <div class=col-md-1>№</div>
        <div class=col-md-8>Название курса</div>
        <div class=col-md-3></div>
    </b>
   </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
  <!-- ${users}-->
   <c:forEach items="${courses}" var="course">
        <div class="row">
        <form class="form-course-${course.id}" action="do?command=ShowCourses" method=POST>
            <div class=col-md-1>
                <input id="user_course_${course.id}" name="Id" type="text"
                value="${course.id}" class="form-control input-md">
            </div>
            <div class=col-md-8>
                <input id="textinput" name="Name" type="text"
                value="${course.name}" class="form-control input-md">
            </div>
            <div class=col-md-3>
            <p><a href="#">записаться на курс</a> </p>
            </div>




</form>
        </div>
   <br>
   </c:forEach>


<%@ include file="include/end-html.jsp" %>