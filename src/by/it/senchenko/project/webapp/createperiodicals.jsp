<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="row">
    <b>
        <div class=col-md-3>Название издания</div>
        <div class=col-md-3>Издатель</div>
        <div class=col-md-6>Дата выхода издания</div>
    </b>
   </div>
   <c:forEach items="${periodicals}" var="periodicals">
           <div class="row">
           <form class="form-periodicals-${periodicals.id}" action="do?command=ShowPeriodicals" method=POST>x`x`
               <div class=col-md-2>
                   <input id="textinput" name="Name" type="text"
                   value="${periodicals.name}" class="form-control input-md">
               </div>
               <div class=col-md-2>
                   <input id="textinput" name="Autor" type="text"
                   value="${periodicals.autor}" class="form-control input-md">
               </div>
               <div class=col-md-2>
                   <input id="textinput" name="Date" type="text"
                   value="${periodicals.date}" class="form-control input-md">
               </div>

               <div class=col-md-1>
                   <button id="singlebutton" name="singlebutton" class="btn btn-success">
                       Обновить
                   </button>
               </div>

               <div class=col-md-1>
                   <button id="singlebutton" name="singlebutton"
                   class="btn btn-danger"
                   onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                   >
                       Удалить
                   </button>
               </div>

           </form>
           </div>
      <br>
      </c:forEach>

<%@ include file="include/end-html.jsp" %>