<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/5
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        body{
            background-image: url("image/710132.jpg");
            background-repeat:no-repeat;
        }
        #name{
            position:absolute;
            background-color: aliceblue;
            top: 270px;
            left: 1000px;
            height: 200px;
            width: 250px;
        }
    </style>
    <script type="text/javascript">
        function renew() {
            document.getElementById("CodeImg").src="/login/checkcode"+"?"+Math.random();// 刷新验证码
        }
        <%--<%
            String flag=(String) request.getAttribute("loginerror");
            System.out.println(flag);
            if (flag.equals("error")){
        %>
            alert("错误")；
        <%
            }
        %>--%>
        <c:if test="${loginerror=='error'}">
            alert("用户名或密码错误")
        </c:if>
    </script>
    <title>登录</title>
</head>
<body>

<div id="name">
    <form action="/login/checklogin" method="post">
        <table>
            <tr>
                <td>
                    用户名：
                </td>
                <td>
                    <input type="text" name="username" value="${cookie.user.value}">
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password" value="${cookie.pass.value}">
                </td>
            </tr>
            <tr>
                <td>
                    验证码：
                </td>
                <td>
                    <input type="text" name="checkword" value="">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <img  alt="验证码看不清，换一张" src="/login/checkcode" id="CodeImg" onclick="renew()"><br/>
                </td>
            </tr>
            <td colspan="2">
                    <span style="display:block; width:250px; text-align:center">
                        <input type="submit" value="登录">
                        <input type="reset" value="清除">
                    </span>
            </td>
        </table>
    </form>
<a href="/login/registered.jsp">没有账号，注册一个！</a>
</div>

</body>
</html>
