<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 08.11.2015
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/Home/log" method="POST">
  <table>
    <tr>
      <th>Login:</th>
      <th><input type="text" name="login" value = "${user.loginName}"/></th>
      <th class="error">${errors.login}</th>
    </tr>
    <tr>
      <th>Password:</th>
      <th><input type="text" name="password" value = "${user.password}"/></th>
      <th class="error">${errors.password}</th>
    </tr>
  </table>
  <input type="submit" value="Send request"/>
</form>
</body>
</html>
