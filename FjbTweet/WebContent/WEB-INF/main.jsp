<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<%@page import="model.Tweet" %>
<%@page import="java.util.ArrayList"%>

<%
ServletContext app = getServletContext();
ArrayList<Tweet> tweetArray =(ArrayList<Tweet>)app.getAttribute("TWEET");
String message =(String)app.getAttribute("ERR");
HttpSession ses = request.getSession();
User user = (User)ses.getAttribute("USER");

%>

   
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>つぶやき掲示板</title>
</head>
<body>
<h1>つぶやき掲示板</h1>
<%if(message.equals("つぶやきが空です")) {%>
<br><h2><%=message %></h2>
<%} %>

<%=user.getUserName()%>さんは現在ログイン中です！

<form method="post" action="/FjbTweet/Main">
<input type="text" name="come">
<input type="submit" value="つぶやく">
</form>

<%for(int i=1 ;  i < tweetArray.size()  ; i++){ %>
<br><%=(tweetArray.get(i)).getName()%>さん：<%=(tweetArray.get(i)).getCome()%>

<%} %>



<br>
<a href="/FjbTweet/Main">更新</a>
<br>
<br>
<a href="/FjbTweet/Logout">ログアウト</a>

</body>
</html>