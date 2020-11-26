<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/22
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>registered</title>
    <style type="text/css">
        .front{
            width: 100%;
            height: 550px;
            background-image: url("image/bg.jpg");
        }
        .table{
            width: 100%;
            height: 200px;
            background-color: #258687;
            margin: 0px auto;
        }
        .from{
            background-color: #609193;
            width: 400px;
            height: 400px;
            position:absolute;
            top: 300px;
            left: 200px;
        }
        .pic{
            position:absolute;
            top: 100px;
            left: 800px;
            width: 200px;
            height: 200px;
            background: url("image/pic.jpg");
        }
        .pic:hover{
            background: url("image/pic2.jpg");
        }
        .red{
            color:red;
        }

    </style>
    <script>
        function renew() {
            document.getElementById("CodeImg").src="/login/checkcode"+"?"+Math.random();// 刷新验证码
        }
    </script>
</head>
<body>
<div class="front"></div>
<div class="table"></div>
<div class="pic">
</div>
<div class="from">
    <p></p>
    <hr color="#154746">

    <form action="/login/regser" method="post">
        <table cellpadding="10px">
            <tr>
                <td>
                    姓名:
                </td>
                <td>
                    <input type="text" name="name" vialue="">
                    <div class="red"><%=request.getAttribute("nameerror")==null?"":request.getAttribute("nameerror")%></div>
                </td>
            </tr>
            <tr>
                <td>
                    密码:
                </td>
                <td>
                    <input type="password" name="password" vialue="">

                </td>
            </tr>
            <tr>
                <td>
                    性别:
                </td>
                <td>
                    男<input type="radio" name="sex" value="male">
                    女<input type="radio" name="sex" value="female"><br>
                </td>
            </tr>
            <tr>
                <%--<td>
                    兴趣：
                </td>
                <td>
                    <input type="checkbox" name="hobby" value="1">看电影
                    <input type="checkbox" name="hobby" value="2">敲代码
                    <input type="checkbox" name="hobby" value="3">打游戏
                </td>--%>
                <td>
                    年龄：
                </td>
                <td>
                    <input type="text" name="age" vialue="">
                </td>
            </tr>
            <tr>
                <td>
                    验证码:
                </td>
                <td>
                    <input type="text" name="validateCode" value=""><br/>
                    <div class="red"><%=request.getAttribute("codeerror")==null?"":request.getAttribute("codeerror")%></div>
                </td>

            </tr>
            <tr>
                <td>

                </td>
                <td>
                    <img  alt="验证码看不清，换一张" src="/login/checkcode" id="CodeImg" onclick="renew()">
                </td>
            </tr>
            <td colspan="2">
                    <span style="display:block; width:250px; text-align:center">
                        <input type="submit" value="提交">
                        <input type="reset" value="清除">
                    </span>
            </td>
        </table>
<%--        <% System.out.println(request.getAttribute("nameerror"));%>--%>
<%--        <% System.out.println(request.getAttribute("codeerror"));%>--%>

    </form>
    <hr color="#154746">

</div>

</body>
</html>
