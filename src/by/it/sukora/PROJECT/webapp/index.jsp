<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<!-- Основное содержимое -->
      <div class="page-header">
        <h1>Поиск1 объявлений</h1>
        <p class="lead">Готовим макет для вывода данных в виде таблицы</p>
      </div>

      <h3>Заголовок. Объявления о продаже</h3>
      <p>Строка делится на 12 частей. Для каждой колонки таблицы
         можно указать класс .col-md-N, где N-число частей</p>
<div class="row">
    <div class="col-md-4">Медецинская карточка</div>

</div>
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-3">Диагнос</div>
        <div class="col-md-2">Симптомы</div>
        <div class="col-md-1">Начало болезни</div>
        <div class="col-md-1">Окончание болезни</div>
        <div class="col-md-1">Рецепт</div>

      </div>



<%@ include file="include/end-html.jsp" %>