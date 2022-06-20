<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<%--<html>--%>
<%--<style type="text/css">--%>
<%--    .login {--%>
<%--        height:180px; width:230px;--%>
<%--        margin:0;--%>
<%--        padding:10px;--%>
<%--        border:1px #CCC solid;--%>
<%--    }--%>
<%--    .login input {--%>
<%--        padding:5px; margin:5px--%>
<%--    }--%>
<%--</style>--%>
<%--<body>--%>
<%--<form method="post" action="/login">--%>
<%--    <div class="login">--%>
<%--        <h2>Login</h2>--%>
<%--        <input type="text" name="username" size="30"  placeholder="username" />--%>
<%--        <input type="password" name="password" size="30" placeholder="password" />--%>
<%--        <input type="submit" value="Sign in"/>--%>
<%--    </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Simple Dictionary</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
</form>
</body>
</html>