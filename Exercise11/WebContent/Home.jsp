<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Break:</h4>
<form action="HomeServlet" method="get">
From:
<br>
<input type="text" name="start">
<br>
End:
<br>
<input type="text" name="end">
<br>
<input type="checkbox" name="line" value="Line">Line</input>
<br>
<input type="text" name="textLine">
<br>
<input type="checkbox" name="station" value="Station">Station</input>
<br>
<input type="text" name="textStation">
<br>
<!-- <input type="text" name="breakLineValue">-->
<input type="submit" name="submit" value="submit">
</form>
</body>
</html>