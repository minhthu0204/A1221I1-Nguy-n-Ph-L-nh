<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Create</title>
    <style>
        .text1{
            width: 30vw;
            height: 250px;
            border: black 1px;
            margin: 20px;
        }
        .text1 input{
            display: block;
            margin-top: 5px;
            margin-bottom: 10px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="text1">
    <form method="post">
        <div class="id1">
            <label>Name</label>
            <input type="text" name="name" placeholder="Enter Name">
            <label>Email</label>
            <input type="text" name="email" placeholder="Enter Email">
            <label>Address</label>
            <input type="text" name="address" placeholder="Enter Address">
        </div>
        <button type="submit" class="btn btn-danger">
            Submit
        </button>
    </form>
</div>
<button type="button" class="btn btn-danger">
    <a href="/user" style="text-decoration: none; color: white">Back To List User</a>
</button>
</body>
</html>