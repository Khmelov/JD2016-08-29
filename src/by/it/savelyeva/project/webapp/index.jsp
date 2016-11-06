<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<h4>Что реализовано:</h4>
<p><ul>
<li>Все ссылки верхнего меню, кроме "Войти", "Выйти"</li>
<li>Регистрация пользователя и редактирование профиля</li>
<li>Создание объявлений (выбор доступного автомобиля по параметрам) - формы готовятся с участием jQuery, Ajax и AjaxServlet</li>
<li>см. также пометки к страницам по ссылкам из верхнего меню</li>
</ul>
<h4>Что НЕ реализовано (TODO):</h4>
<p><ul>
<li>Сессии</li>
<li>Редактирование объявлений</li>
<li>Отображение списка доступных для аренды автомобилей в удобочитаемом виде с учетом дат аренды</li>
<li>см. также пометки к страницам по ссылкам из верхнего меню</li>
</ul>
<hr>
      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Поиск объявлений</h1>
        <p class="lead">Готовим макет для вывода данных в виде таблицы</p>
      </div>

      <h3>Список автомобилей для аренды</h3>

      <div class="row">
        <div class="col-md-1">Цена аренды за 1 день</div>
        <div class="col-md-2">Производитель</div>
        <div class="col-md-2">Модель</div>
        <div class="col-md-2">Трансмиссия</div>
        <div class="col-md-1">Цвет</div>
        <div class="col-md-1">Год выпуска</div>
        <div class="col-md-1">Полная цена с учетом износа</div>
        <div class="col-md-2">Комментарий</div>
      </div>

        <p><ol>Справочники (это для отладки, разметка будет добавлена только в те вьюшки, которые будут нужны)
              <li><a href="do?command=ShowRoles">Роли</a></li>
              <li><a href="do?command=ShowCountries">Страны</a></li>
              <li><a href="do?command=ShowCities">Города</a></li>
              <li><a href="do?command=ShowStreets">Улицы</a></li>
              <li><a href="do?command=ShowAddresses">Адреса</a></li>
              <li><a href="do?command=ShowSexTypes">Полы</a></li>
              <li><a href="do?command=ShowDlCategories">Водительские категории</a></li>
              <li><a href="do?command=ShowDriverLicenses">Водительские удостоверения</a></li>
              <li><a href="do?command=ShowCars">Автомобили</a></li>
              <li><a href="do?command=ShowManufacturers">Производители</a></li>
              <li><a href="do?command=ShowModels">Модели</a></li>
              <li><a href="do?command=ShowTransmissions">Трансмиссии</a></li>
              <li><a href="do?command=ShowColors">Цвета</a></li>
        </ol>
<%@ include file="include/end-html.jsp" %>
