<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Periodicals</title>
    <link href="css\bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>

<div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li><a href=".">Start Periodicals!</a></li>
            <li><a href="do?command=Catalogue">Catalogue</a></li>
            <c:choose>
               <c:when test="${user!=null}">
                    <li><a href="do?command=Profile">My Profile</a></li>
               </c:when>
               <c:otherwise>
                    <li><a href="do?command=Login">Log in</a></li>
               </c:otherwise>
            </c:choose>
          </ul>
        </nav>
      </div>
<div class="jumbotron">



