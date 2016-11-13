<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>Тесты для выполнения</h1>
</div>
<div class="row">
    <b>
        <div class="col-md-3" align="center">Название теста</div>
        <div class="col-md-1" align="center">Предмет</div>
        <div class="col-md-3" align="center">Количество вопросов</div>
    </b>
</div>
<br>
<c:forEach items="${tests}" var="test">
    <div class="row">
        <form class="form-test-${test.ID}" action="do?command=DoTest" method=POST>
            <div class="col-md-3" align="center">${test.name} </div>
            <div class="col-md-1" align="center">${test.subject}</div>
            <div class="col-md-3" align="center">${test.questions}</div>
            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Пройти тест
                </button>
            </div>
        </form>
    </div>
    <br>
</c:forEach>
<%@ include file="include/end-html.jsp" %>
