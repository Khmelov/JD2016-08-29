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
            <label class="col-md-4 control-label" for="QuestionsAmount">Количество вопросов</label>
            <div class="col-md-5">
                <input id="QuestionsAmount" name="Questions" type="text" placeholder="Введите количество вопросов..." class="form-control input-md">

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