<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<form class="form-horizontal" action="/grishechkin/do?command=CREATEORDER" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Create Order</legend>

        <!-- Multiple Radios -->
        <div class="form-group">
            <label class="col-md-4 control-label">Select Auto</label>
            <br><br>
            <div class="col-md-6">
                <c:forEach items="${autos}" var="auto">
                    <c:if test="${auto.availability==1}">
                        <br class="radio">
                            <label for="radios-${auto.ID}">
                                <input name="autoID" id="radios-${auto.ID}" value="${auto.ID}" type="radio">
                                <div class="row">
                                <div class="col-md-3">${auto.mark} </div>
                                <div class="col-md-3">${auto.model} </div>
                                <div class="col-md-3">${auto.year} </div>
                                </div>
                                <div class="col-md-5">
                                    <input id="textinput" name="Term" placeholder="term" class="form-control input-md" type="text">
                                </div>
                            </label>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Order</button>
            </div>
        </div>

    </fieldset>
</form>
<%@ include file="footer.jsp" %>