<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 20.10.2020
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <style>
        .container {
            padding: 50px;
            position: fixed;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            background: white;
            outline: 2px solid #000;
            border-radius: 10px;
            text-align: center;
        }
    </style>
</head>
<body class="container">
<form action="<c:url value='/save'/>" method='POST'>
    <div class="form-group">
        <label for="nameAccident">Name accident:</label>
        <input type="text" class="form-control" name="name" id="nameAccident" aria-describedby="accidentHelp"
               placeholder="Enter name">
        <small id="accidentHelp" class="form-text text-muted">Please enter name of accident.</small>
    </div>
    <div class="form-group">
        <label for="descriptionArea">Description:</label>
        <textarea class="form-control" name="text" id="descriptionArea" rows="3"></textarea>
    </div>
    <div class="form-group">
        <label for="addressAccident">Address accident:</label>
        <input type="text" class="form-control" name="address" id="addressAccident" aria-describedby="addressHelp"
               placeholder="Enter address">
        <small id="addressHelp" class="form-text text-muted">Enter please address of accident.</small>
    </div>
    <div class="form-group">
        <label for="typeSelect">Select type</label>
        <select class="form-control" name="type.id" id="typeSelect">
            <c:forEach var="type" items="${types}">
                <option value="${type.id}">${type.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="articleSelect">Select article</label>
        <select class="form-control" name="rIds" id="articleSelect" multiple>
            <c:forEach var="rule" items="${rules}">
                <option value="${rule.id}">${rule.name}</option>
            </c:forEach>
        </select>
    </div>
    <input type="submit" class="btn btn-primary" value="Save"/>
</form>
</body>
</html>
