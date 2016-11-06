<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<h4>Что реализовано:</h4>
<p><ul>
<li>Объявления добавляются в базу, в случае успеха - открывается страница с сообщением</li>
<li>Форма поиска автомобиля по параметрам строится с помощью AJAX (сервлет находится в controller/AjaxServlet) - вытаскиваются модели в зависимости от производителей, цена в день в зависимости от id автомобиля и пр.)</li>
<li>Есть скрытые поля (цена за день, id автомобиля, id объявления) - javascript, ajax</li>
<li>Если разница дат аренды <=0 кнопка "Арендовать" исчезает</li>
<p></ul>
<ul>можно выбирать такие автомобили (список <a href="http://localhost:28080/savelyeva/do?command=ShowCars">здесь</a>):
<li>Toyota RAV4 Mechanic белый - 2 автомобиля</li>
<li>Suzuki SX4 Auto белый - 1 автомобиль</li>
<li>Nissan Qashqai Mechanic синий - 1 автомобиль</li>
</ul>

<h4>Что НЕ реализовано (TODO):</h4>
<p><ul>
<li>Id Userа пока берется фиксированно 1 (нужно брать из сессии)</li>
<li>Цена, посчитанная Javascriptом, не проверяется на сервере, но добавлю</li>
<li>Улучшить разметку страницы (список найденных автомобилей доступных для аренды)</li>
<li>Не отслеживается пока, занят ли автомобиль на заданный период времени,
т.е. можно арендовать несколько раз на те же самые или пересекающиеся промежутки времени.</li>
<li>При загрузке страницы не все динамические поля формы могут подтянуться - нужен фикс, но пока можно перезагружать страничку </li>
</ul>

<form class="form-horizontal" action="do?command=CREATERENT" method="POST">
    <fieldset>
        <input id="id" name="id" value="0" type="hidden">


        <!-- Form Name -->
        <legend>Поиск автомобиля по параметрам для запроса на аренду</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="idManufacturer">Производитель</label>
            <div class="col-md-4">
                <select id="idManufacturer" name="idManufacturer" class="form-control">
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="idModel">Модель</label>
            <div class="col-md-4">
                <select id="idModel" name="idModel" class="form-control">
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="idTransmission">Трансмиссия</label>
            <div class="col-md-4">
                <select id="idTransmission" name="idTransmission" class="form-control">
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="idColor">Цвет</label>
            <div class="col-md-4">
                <select id="idColor" name="idColor" class="form-control">
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="startDate">Начало аренды</label>
            <div class="col-md-4">
                <input id="startDate" name="startDate" type="text" value="2016-12-12" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите дату окончания аренды (гггг-мм-дд)о</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="endDate">Окончание аренды</label>
            <div class="col-md-4">
                <input id="endDate" name="endDate" type="text" value="2016-12-21" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите дату окончания аренды (гггг-мм-дд)</span>
            </div>
        </div>

        <input id="idCar" name="idCar" type="hidden" value="idCar" placeholder="" class="form-control input-md" required="">


        <input id="cost" name="cost" type="hidden" value="500" placeholder="" class="form-control input-md" required="">
        <!-- 500 is default for debug purpose:
         to have already filled in form I left default values for all fields,
         if any of endDate or startDate gets changed, cost value will be set properly
        TODO: set empty values, keep placeholders.
        -->

        <input id="dayPrice" name="dayPrice" type="hidden" value="dayPrice" placeholder="" class="form-control input-md" required="">
        <div id="rents" height="auto"></div>


        <!-- Button ->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
            </div>
        </div-->

    </fieldset>
</form>

<script language="Javascript">

$(document).ready(function() {

    $.get("ajaxservlet?dao=transmission", function(responseJson) {
        var $select = $("#idTransmission");
        $select.find("option").remove();
        objects = JSON.parse(responseJson)
        $.each(objects, function(index, value) {
             $("<option>").val(value.id).text(value.type).appendTo($select);
        });
    });

    $.get("ajaxservlet?dao=color", function(responseJson) {
        var $select = $("#idColor");
        $select.find("option").remove();
        objects = JSON.parse(responseJson)
        $.each(objects, function(index, value) {
             $("<option>").val(value.id).text(value.color).appendTo($select);
        });
    });

    $.get("ajaxservlet?dao=manufacturer", function(responseJson) {
         var $select = $("#idManufacturer");
         $select.find("option").remove();
         objects = JSON.parse(responseJson)
         $.each(objects, function(index, value) {
              $("<option>").val(value.id).text(value.manufacturer).appendTo($select);
         });
         $("#idManufacturer").change()
    });



    $(document).on("change", "#idManufacturer", function() {
        $.get("ajaxservlet?dao=model&field=idManufacturer&id=" + $("#idManufacturer").val(), function(responseJson) {
            var $select = $("#idModel");
            $select.find("option").remove();
            objects = JSON.parse(responseJson)
            $.each(objects, function(index, value) {
                $("<option>").val(value.id).text(value.model).appendTo($select);
            });
        });
    });

    $(document).on("change", "#idTransmission", function() {
        search();
    });

    $(document).on("change", "#idColor", function() {
        search();
    });

    $(document).on("change", "#startDate", function() {
        calculate();
        search();
    });

    $(document).on("change", "#endDate", function() {
        calculate();
        search();
    });

    function calculate() {
          startDate = document.getElementById("startDate").value;
          endDate = document.getElementById("endDate").value;
          cost = document.getElementById("dayPrice").value * Math.floor((Date.parse(endDate) - Date.parse(startDate) + 86400000) / 86400000);
          document.getElementById("cost").value = cost;
    }

    function search() {
        $.get("ajaxservlet?dao=car&idModel=" + $("#idModel").val() +
                            "&idTransmission=" + $("#idTransmission").val() +
                            "&idColor=" + $("#idColor").val(),
              function(responseJson) {
            objects = JSON.parse(responseJson)
            html = "";
            $.each(objects, function(index, value) {
                cost = document.getElementById("cost").value;
                if (cost <= 0) {
                    t = "hidden"
                }
                else {
                    t = "button"
                    document.getElementById("dayPrice").value = value.dayPrice
                }
                button = '<br>' +
                         '<input type="'+t+'" id="rent_' + value.id + '" name="rent_' + value.id + '" class="" ' +
                          'onclick="javascript:document.getElementById(\'idCar\').value=\'' + value.id + '\';' +
                          'javascript:document.getElementById(\'cost\').value=\'' + cost + '\';' +
                          'submit()" value="Арендовать" width="100">'
                description = $("#idManufacturer option:selected").text() + " " +
                                $("#idModel option:selected").text() + " " +
                                $("#idColor option:selected").text() + " " +
                                value.year + " " +
                                value.fullPrice + " " +
                                value.dayPrice + " " +
                                (value.comment == null ? "" : value.comment);
                html += description + button + "<hr>"
            });
            $("#rents").html(html);
        });
    };

});
</script>
<%@ include file="include/end-html.jsp" %>
