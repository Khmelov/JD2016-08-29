<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="do?command=ADDQUESTIONS" method="post">
    <!-- Form Name -->
    <legend>Добавить вопросы в тест</legend>
    <c:forEach items="${questions}" var="question">
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="QuestionText${question.ID}">Текст вопроса</label>
            <div class="col-md-5">
                <input id="QuestionText${question.ID}" name="QuestionText${question.ID}" type="text"
                       placeholder="Введите текст вопроса..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Баллы</label>
            <div class="col-md-4">
                <input id="Balls" name="Balls${question.ID}" type="text" placeholder="Введите баллы за вопрос..."
                       class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Вариант ответа</label>
            <div class="col-md-4">
                <input id="Varianta" name="Varianta${question.ID}" type="text" placeholder="Введите вариант ответа..."
                       class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Вариант ответа</label>
            <div class="col-md-4">
                <input id="Variantb" name="Variantb${question.ID}" type="text" placeholder="Введите вариант ответа..."
                       class="form-control input-md">

            </div>
        </div>
    </c:forEach>
    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="QuestionButton"></label>
        <div class="col-md-4">
            <button id="QuestionButton" name="QuestionButton" class="btn btn-success">Добавить</button>
        </div>
    </div>


</form>
