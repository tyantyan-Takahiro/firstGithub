<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<%
HttpSession ses = request.getSession();
User user = (User)ses.getAttribute("USER");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやき掲示板</title>
</head>
<body>
<h1>つぶやき掲示板</h1>
<h2>まずはログインしてね!</h2>
<%if(user == null){ %>
ログイン失敗...<br>
<br>
<a href="index.jsp">トップに戻る</a>

<%}else{ %>
ログインに成功！<br>
<br>
ようこそ<%=user.getUserName() %>さん<br>
<br>
<a href="/FjbTweet/Main">つぶやきの投稿・閲覧はこちら</a>
<%} %>

</body>
</html>