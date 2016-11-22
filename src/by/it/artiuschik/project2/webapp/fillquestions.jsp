<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="do?command=ADDQUESTIONS" method="post">
    <!-- Form Name -->
    <legend>Добавить вопросы в тест</legend>
    <c:forEach var="number" begin="0" end="${questions_amount}">
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="QuestionText${number}">Текст вопроса</label>
            <div class="col-md-5">
                <input id="QuestionText${number}" name="QuestionText${number}" type="text"
                       placeholder="Введите текст вопроса..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Баллы</label>
            <div class="col-md-4">
                <input id="Balls" name="Balls${number}" type="text" placeholder="Введите баллы за вопрос..."
                       class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Вариант ответа</label>
            <div class="col-md-4">
                <input id="Varianta" name="Varianta${number}" type="text" placeholder="Введите вариант ответа..."
                       class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Вариант ответа</label>
            <div class="col-md-4">
                <input id="Variantb" name="Variantb${number}" type="text" placeholder="Введите вариант ответа..."
                       class="form-control input-md">

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Правильный ответ</label>
            <div class="col-md-4">
                <input id="Answer" name="Answer${number}" type="text" placeholder="Номер правильного варианта..."
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
