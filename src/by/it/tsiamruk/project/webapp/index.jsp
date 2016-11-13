<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1 align="center" style="margin:0 auto;">Welcome to Payment System</h1>
        <h2 class="lead" align="center" style="margin:0 auto;">The best system ever(no)</h2>
      </div>




      <legend align="center" style="margin:0 auto;">Для того, что-бы продолжить нажмите кнопку регистрация или войти</legend>

              <!-- Buttons -->
              <div class="col-md-12" align="center">
                          <div class="col-md-12">
                            <button id="LoginButton" name="LoginButton" class="btn btn-primary" value="1">
                              <a href="login.jsp" style="color:yellow">Войти</a>
                          </button>
                      </div>
              </div>
              <br>
              <br>
              <div class="col-md-12" align="center">
                      <div class="col-md-12">
                        <button id="SignupButton" name="SignupButton" class="btn btn-default" value="1" type="submit">
                          <a href="signup.jsp">Регистрация</a>
                        </button>
                      </div>
              </div>






<%@ include file="include/end-html.jsp" %>
