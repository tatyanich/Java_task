<?xml version="1.0" encoding="utf-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Super calculator</title>
    <!--<script src="Scripts/jquery-1.5.2.min.js"></script>-->
    <!--<script src="Scripts/jquery.validate.min.js"></script>-->
    <!--<script src="Scripts/Custom/validation.js"></script>-->
    <link href="css/site.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="existUser">
     <p>${exist}</p> <br/>
</div>

<form id="registrationLogin" action="/Home/reg" method="POST">
    <table>
        <tr>
            <th>First Name:</th>
            <th><input type="text" name="firstName" value="${user.firstName}"/></th>
            <th class="error">${errors.firstName}</th>
        </tr>
        <tr>
            <th>Second Name:</th>
            <th><input  type="text" name="lastName" value="${user.lastName}"/></th>
            <th class="error">${errors.lastName}</th>
        </tr>
        <tr>
            <th>Login:</th>
            <th><input  type="text" name="login" value="${user.loginName}"/></th>
            <th class="error">${errors.login}</th>
        </tr>
        <tr>
            <th>Password:</th>
            <th><input id="password_id" type="password" name="password" value="${user.password}"/></th>
            <th class="error">${errors.password}</th>
        </tr>
        <tr>
            <th>Confirm Password:</th>
            <th><input type="password" name="confirmPassword" value="${user.confirmPassword}"/></th>
            <th class="error">${errors.confirmPassword}</th>
        </tr>
        <tr>
            <th>Email:</th>
            <th><input  type="text" name="email" value="${user.email}"/></th>
            <th class="error">${errors.email}</th>
        </tr>
        <tr>
            <th>Male: <input type="radio" name="gender" value="${user.female}"/></th>
            <th>Female: <input type="radio" name="gender" value="${user.female}"/></th>
        </tr>
    </table>
    <input type="submit" value="Send request"/>
</form>
</body>
</html>