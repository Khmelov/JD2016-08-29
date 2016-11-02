<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1 align="center" style="margin:0 auto;">Welcome to Payment System</h1>
        <h2 class="lead" align="center" style="margin:0 auto;">The best system ever(no)</h2>
        <p align="center" style="margin:0 auto;">Для того, что-бы продолжить нажмите кнопку регистрация или войти</p>
      </div>

      <!-- Buttons -->
      <p>
            <div class="form-group" style="margin:0 auto" align="center">
              <div class="col-md-12">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">
                  <a href=do?command=SignUp style="color: white">Регистрация</a>
                </button>
              </div>
            </div>
      </p>
      <p>
          <div class="form-group" style="margin:0 auto" align="center">
                  <div class="col-md-12">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">
                      <a href="do?command=Login" style="color: white">Войти</a>
                  </button>
              </div>
          </div>
      </p>


<%@ include file="include/end-html.jsp" %>
