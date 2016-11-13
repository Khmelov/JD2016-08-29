<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<legend>Список пользователей(только для администора)</legend>

   <div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-3>Кол-во денег</div>
        <div class=col-md-3>Статус</div>
    </b>
   </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
   <c:forEach items="${accounts}" var="account">
        <div class="row">
        <form class="form-user-${user.id}" action="do?command=ShowUserAccounts" method="POST">

            <div class=col-md-1>
                <input id="account_id_${account.id}" name="ID" type="text"
                value="${account.id}" class="form-control input-md">
            </div>
            <div class=col-md-3>
                <input id="textinput" name="Amount" type="text"
                value="${account.amount}" class="form-control input-md">
            </div>
            <div class=col-md-3>
                <input id="textinput" name="Status" type="text"
                value="${account.status}" class="form-control input-md">
            </div>
            <!-- <div class=col-md-2>
                <input id="textinput" name="Users_ID" type="text"
                value="${account.users_ID}" class="form-control input-md">
            </div> -->
            <!--Ссылается на другую страницу где совершаются платежи (только для пользователей)
            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    <a href="error.jsp" style="color:white">Платить</a>
                </button>
            </div>
            -->
            <!--Меняет статус счета-->
            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton"
                class="btn btn-danger"
                value="${account.id}"
                >
                    Заблокировать
                </button>
            </div>
        </form>
        </div>
   <br>
   </c:forEach>


<%@ include file="include/end-html.jsp" %>