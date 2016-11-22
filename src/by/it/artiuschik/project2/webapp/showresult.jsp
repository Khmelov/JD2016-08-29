<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h4>Тест ${test_name} </h4>
</div>
<c:forEach var="question" items="${questions}">
    <div class="row">
        <div class=col-md-12><h5><strong>Вопрос: </strong>${question.text}</h5></div>
        <div class=col-md-6>
            <c:choose>
                <c:when test="${question.answer==1}">
                    <h5>
                        <strong>Ответ: </strong>${question.varianta}
                    </h5>
                </c:when>
                <c:when test="${question.answer==2}">
                    <h5>
                        Ответ: ${question.variantb}
                    </h5>
                </c:when>
            </c:choose>
        </div>
    </div>
</c:forEach>
<div class="page-header">
    <h4>Ваши ответы </h4>
</div>
<c:forEach var="user_answer" items="${user_answers}">
    <div class="row">
        <div class=col-md-6>
            <h5>
                <strong>Ответ: </strong>${user_answer}
            </h5>
        </div>
        </div>
</c:forEach>
<div class="page-header" >
    <h4>Ваш результат: ${result} баллов!</h4>
</div>
<%@ include file="include/end-html.jsp" %>