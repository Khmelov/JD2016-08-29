<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=ADDQUESTION" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Добавить вопрос</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="TestName">Название теста</label>
            <div class="col-md-5">
                <input id="TestName" name="TestName" type="text" placeholder="Введите название теста..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="QuestionText">Текст вопроса</label>
            <div class="col-md-5">
                <input id="QuestionText" name="QuestionText" type="text" placeholder="Введите текст вопроса..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Balls">Баллы</label>
            <div class="col-md-4">
                <input id="Balls" name="Balls" type="text" placeholder="Введите баллы за вопрос..." class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="QuestionButton"></label>
            <div class="col-md-4">
                <button id="QuestionButton" name="QuestionButton" class="btn btn-success">Добавить</button>
            </div>
        </div>

    </fieldset>
</form>


<%@ include file="include/end-html.jsp" %>


