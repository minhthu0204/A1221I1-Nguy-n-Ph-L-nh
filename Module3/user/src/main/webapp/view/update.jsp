<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<form method="post">
    <div class="id1">
        <label>Name</label>
        <input type="text" name="name" placeholder="Enter New Name">
        <label>Email</label>
        <input type="text" name="email" placeholder="Enter New Email">
        <label>Address</label>
        <input type="text" name="address" placeholder="Enter New Address">
    </div>
    <button type="submit" class="btn btn-danger">
        Update
    </button>
</form>
<button type="button" class="btn btn-danger">
    <a href="/user" style="text-decoration: none; color: white">Back To List User</a>
</button>
</body>
</html>