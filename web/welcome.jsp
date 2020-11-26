<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/22
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome:${cookie.user.value}</title>
</head>
<body>
<%--<h1>
welcome:
<%
    out.println(session.getAttribute("user"));
%>
</h1>--%>
<table align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>gender</th>
        <th>age</th>
    </tr>
    <c:forEach items="${userlist}" var="stud">
        <tr>
            <td>${stud.id}</td>
            <td>${stud.name}</td>
            <td>${stud.gender}</td>
            <td>${stud.age}</td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="4" align="center">
            <a href="/login/recookie">注销登录</a>
        </td>
    </tr>
    <tr>
        <td colspan="4" align="center">
            <a href="/login/main.jsp">查询</a>
        </td>
    </tr>
</table>
</body>
</html>
