<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<!-- Основное содержимое -->
      <div class="page-header">
        <h1>Медецинская карточка пациента</h1>
        <p class="lead">Отображение карточки пациента</p>
      </div>

      <h3>Медецинская карточка пациента</h3>
<div class="row">
    <div class="col-md-4">Медецинская карточка</div>

</div>
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-2">Диагнос</div>
        <div class="col-md-2">Симптомы</div>
        <div class="col-md-2">Начало болезни</div>
        <div class="col-md-2">Окончание болезни</div>
        <div class="col-md-2">Рецепт</div>
      </div>
<c:forEach items="${diagnosis}" var="user">
        <div class="row">

        <form class="form-horizontal" action=deleteUser method=POST>
        <div class="col-md-1"></div>
            <div class=col-md-2>
                <input id="textinput" name="Disease" type="text"
                value="${user.disease}" class="form-control input-md">
            </div>

            <div class=col-md-2>
                <input id="textinput" name="Siptomps" type="text"
                value="${user.siptomps}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="periodStart" type="text"
                value="${user.periodStart}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                             <input id="textinput" name="periodEnd" type="text"
                              value="${user.periodEnd}" class="form-control input-md">
                        </div>
            <div class=col-md-2>
                <input id="textinput" name="recipe" type="text"
                value="${user.recipe}" class="form-control input-md">
            </div>

        </form>
        </div>
   <br>
   </c:forEach>


<%@ include file="include/end-html.jsp" %>