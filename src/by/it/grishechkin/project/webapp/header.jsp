<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Базовый шаблон для JSP</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <title>Leasing Auto</title>
</head>

<body class="container">
<div class="header">
    <div class="clear">
        <div class="head_left">
            <a href="#" data-toggle=".container" id="sidebar-toggle">
                <span class="bar"></span>
                <span class="bar"></span>
                <span class="bar"></span>
            </a>
            <a href="/grishechkin/" class="logo"> Prindiville Group</a>
            <ul class="menu">
                <li><a href="/grishechkin/do?command=login">Login</a></li>
                <li><a href="/grishechkin/do?command=signup">SignUp</a></li>
            </ul>
        </div>
        <div class="phone">
            <a href="tel:012.345.6789">012.345.6789</a>
        </div>
    </div>
</div>