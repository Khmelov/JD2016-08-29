<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<h4>Список автомобилей для аренды</h4>

<c:choose>
      <c:when test="${carsCount==0}">
          ${message}
      </c:when>
      <c:otherwise>
           <div class="row">
            <b>
              <div class="row">
                 <div class="col-md-1">ID</div>
                 <div class="col-md-1">Цена аренды за 1 день</div>
                 <div class="col-md-2">Производитель</div>
                 <div class="col-md-2">Модель</div>
                 <div class="col-md-2">Трансмиссия</div>
                 <div class="col-md-2">Цвет</div>
                 <div class="col-md-1">Год выпуска</div>
                 <div class="col-md-1">Полная цена с учетом износа</div>
              </div>
            </b>
           </div>
           <br>
     </c:otherwise>
</c:choose>

   <c:forEach items="${cars}" var="car">
        <div class="row">
            <div class=col-md-1>${car.id}</div>

            <div class=col-md-1>${car.dayPrice} USD</div>

            <div class=col-md-2>
                  <c:forEach items="${manufacturers}" var="manufacturer">
                      <c:forEach items="${models}" var="model">
                           ${manufacturer.id==model.idManufacturer && model.id==car.idModel? manufacturer.manufacturer:""}
                      </c:forEach>
                  </c:forEach>
            </div>

            <div class=col-md-2>
                  <c:forEach items="${models}" var="model">
                       ${model.id==car.idModel? model.model:""}
                  </c:forEach>
            </div>

            <div class=col-md-2>
                  <c:forEach items="${transmissions}" var="transmission">
                       ${transmission.id==car.idTransmission? transmission.type:""}
                  </c:forEach>
            </div>

            <div class=col-md-2>
                  <c:forEach items="${colors}" var="color">
                       ${color.id==car.idColor? color.color:""}
                  </c:forEach>
            </div>

            <div class=col-md-1>${car.year}</div>

            <div class=col-md-1>${car.fullPrice} USD</div>

     </div>
     <br>
   </c:forEach>


<%@ include file="include/end-html.jsp" %>
