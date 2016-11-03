<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Payment System</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <style>
           .border {
               list-style: none;
               padding: 0;
               }
               .border li {
               font-family: "Trebuchet MS", "Lucida Sans";
               padding: 7px 20px;
               margin-bottom: 10px;
               border-radius: 5px;
               border-left: 10px solid #f05d22;
               box-shadow: 2px -2px 5px 0 rgba(0,0,0,.1),
                    -2px -2px 5px 0 rgba(0,0,0,.1),
                   2px 2px 5px 0 rgba(0,0,0,.1),
                   -2px 2px 5px 0 rgba(0,0,0,.1);
               font-size: 20px;
               letter-spacing: 2px;
               transition: 0.3s all linear;
           }
           .border li:nth-child(2){border-color: #8bc63e;}
           .border li:nth-child(3){border-color: #fcba30;}
           .border li:nth-child(4){border-color: #1ccfc9;}
           .border li:nth-child(5){border-color: #493224;}
           .border li:hover {
           border-left: 10px solid transparent;
           }
           .border li:nth-child(1):hover {
           border-right: 10px solid #f05d22;
           }
           .border li:nth-child(2):hover {
           border-right: 10px solid #8bc63e;
           }
           .border li:nth-child(3):hover {
           border-right: 10px solid #fcba30;
           }
           .border li:nth-child(4):hover {
           border-right: 10px solid #1ccfc9;
           }
           .border li:nth-child(5):hover {
           border-right: 10px solid #493224;
           }
    </style>
</head>
<body>

<div class="container">

      <!-- Static navbar, смотрите пример тут: http://bootstrap-3.ru/examples/navbar/ -->

      <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=".">Главная</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="do?command=CreateAccount">Создать счёт</a></li>
              <li><a href="do?command=ShowUsers">Список пользователей</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <!-- <li><a href="do?command=SignUp">Зарегистрироваться</a></li> -->
              <!-- <li><a href="do?command=Login">Войти</a></li> -->
              <li><a href="do?command=Logout">Выход</a></li>
              <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>


