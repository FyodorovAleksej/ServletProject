<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 14.02.2018
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<html lang=${language}>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Result</title>
</head>
<body>
<h1 class="alert-info"><fmt:message key="result" />:</h1>
<br/>
<table border="1">
    <caption><fmt:message key="flower.header"/></caption>
    <br/>
    <tr>
        <th><fmt:message key="flower.id"/></th>
        <th><fmt:message key="flower.name"/></th>
        <th><fmt:message key="flower.soil"/></th>
        <th><fmt:message key="flower.origin"/></th>
        <th><fmt:message key="flower.stalk"/></th>
        <th><fmt:message key="flower.leaf"/></th>
        <th><fmt:message key="flower.size"/></th>
        <th><fmt:message key="flower.temperature"/></th>
        <th><fmt:message key="flower.lighting"/></th>
        <th><fmt:message key="flower.watering"/></th>
        <th><fmt:message key="flower.multiplying"/></th>
    </tr>
    ${res}
</table>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
