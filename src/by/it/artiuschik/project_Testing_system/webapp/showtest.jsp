<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>${test.name}</h1>
    </div>
  <br>
<form class="form-horizontal" action="do?command=SHOWRESULT" method="post">
<c:forEach items="${questions}" var="question">
    <div class="row">
    <div class=col-md-4>${question.text}</div>
            <!-- Multiple Checkboxes -->
            <div class="form-group">
                <div class="col-md-4">
                    <div class="checkbox">
                        <label for="checkboxGroup-0">
                            <input type="checkbox" name="checkboxGroup${question.ID}" id="checkboxGroup-0" value="1">
                            ${question.varianta}
                        </label>
                    </div>
                    <div class="checkbox">
                        <label for="checkboxGroup-1">
                            <input type="checkbox" name="checkboxGroup${question.ID}" id="checkboxGroup-1" value="2">
                            ${question.variantb}
                        </label>
                    </div>
                </div>
            </div>
        </div>
</c:forEach>
    <div class="form-group">
        <br>
        <button id="singlebutton" name="singlebutton" class="btn btn-success">
            Отправить
        </button>
    </div>
</form>
