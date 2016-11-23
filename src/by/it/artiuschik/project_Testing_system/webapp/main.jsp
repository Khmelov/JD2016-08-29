<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="row">
    <b>
        <div class=col-md-1>Название</div>
        <div class=col-md-2>Предмет</div>
        <div class=col-md-2>Количество вопросов</div>
    </b>
</div>
<br>
<c:forEach items="${tests}" var="test">
    <div class="row">
        <form class="form-test-${test.ID}" action="do?command=ShowTests" method=post>
            <div class=col-md-2>
                <input id="textinput" name="Name" type="text"
                       value="${test.Name}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Subject" type="text"
                       value="${test.Subject}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Questions" type="text"
                       value="${test.Questions}" class="form-control input-md">
            </div>
            </select>

            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Обновить
                </button>
            </div>

            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton"
                        class="btn btn-danger"
                        onclick="document.getElementById('user_id_${test.ID}').value=-document.getElementById('test_id_${test.ID}').value;"
                >
                    Удалить
                </button>
            </div>

        </form>
    </div>
    <br>
</c:forEach>
<%@ include file="include/end-html.jsp" %>

