<%--
  Created by IntelliJ IDEA.
  User: exphuhong
  Date: 17-9-13
  Time: 上午10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--#{logInformation},--%>
<%--#{logDate},--%>
<%--#{imgPath},--%>
<%--#{userId},--%>
<%--#{surnameCount}--%>
    <form action="/comUpLog" method="post" enctype="multipart/form-data" >
        <input type="text" name="logInformation">
        <input type="text" name="logDate">
        <input type="text" name="imgPath">
        <input type="text" name="userId">
        <input type="text" name="surnameCount">
        <input type="file" value="">
        <input type="file" value="">
        <input type="submit" value="submit">
    </form>
</body>
</html>
