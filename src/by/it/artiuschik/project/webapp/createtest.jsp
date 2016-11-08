<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=CREATETEST" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Создать тест</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Name">Название</label>
            <div class="col-md-5">
                <input id="Name" name="Name" type="text" placeholder="Введите название теста..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Subject">Предмет</label>
            <div class="col-md-5">
                <input id="Subject" name="Subject" type="text" placeholder="Введите предмет..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Q1">Текст вопроса</label>
            <div class="col-md-5">
                <input id="Q1" name="Q1" type="text" placeholder="Введите текст вопроса..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Q1Balls">Баллы за вопрос</label>
            <div class="col-md-5">
                <input id="Q1Balls" name="Q1Balls" type="text" placeholder="Введите баллы..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Q2Text">Текст вопроса</label>
            <div class="col-md-5">
                <input id="Q2Text" name="Q2Text" type="text" placeholder="Введите текст вопроса..." class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Q2Balls">Баллы за вопрос</label>
            <div class="col-md-5">
                <input id="Q2Balls" name="Q2Balls" type="text" placeholder="Введите баллы..." class="form-control input-md">

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
