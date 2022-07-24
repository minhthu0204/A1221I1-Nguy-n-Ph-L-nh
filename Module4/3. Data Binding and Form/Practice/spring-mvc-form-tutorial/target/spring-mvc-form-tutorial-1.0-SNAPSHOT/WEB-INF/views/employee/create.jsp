<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form method="POST" action="addEmployee">
    <table>
        <tr>
            <td>Employee ID:</td>
            <td><input name="id"/></td>
        </tr>
        <tr>
            <td>Employee's name:</td>
            <td><input name="name"/></td>
        </tr>
        <tr>
            <td>Contact's number: </td>
            <td><input name="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>