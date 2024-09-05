<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
background-color: #EBB8DD;
text-align: center;
font-family:courier;
}

</style>
</head>
<body>

<form action='insertring' method="post">

<h2>RING DETAILS</h2>
<label>Ring Material:</label>
<input type="text" name="material"><br><br>
<label>Ring Price:</label>
<input type="text" name="price"><br><br>
<label>Rating:</label>
<input type="text" name="rating"><br><br>
<input type="submit" name="submit">

</form>
</body>
</html>