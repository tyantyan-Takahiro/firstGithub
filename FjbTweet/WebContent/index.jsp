<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやき掲示板　Top画面</title>
</head>
<body>
<h1>つぶやき掲示板</h1>
<h2>まずはログインしてね!</h2>
<form method="post" action="/FjbTweet/Login">
ユーザ名：<input type="text" name="userName"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="送信">
</form>
</body>
</html>