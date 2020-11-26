<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/6
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="domain.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<form action="/login/studentser" method="post">
<%--    <input type="text" name="gender" value="">--%>
    男：<input type="radio" name="gender" value="male">
    女：<input type="radio" name="gender" value="female">
    <input type="submit" name="查询">
</form>
<table>
<c:forEach items="${userlist}" var="stud">
    <tr>
        <td>${stud.id}</td>
        <td>${stud.name}</td>
        <td>${stud.gender}</td>
        <td>${stud.age}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>
