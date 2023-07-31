<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%User loginUser = (User)session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>docotsubu</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<% if(loginUser != null){ %>
<p>ログイン成功</p>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<a href="/docotsubu/Main">メインページへ</a>
<%}else{ %>
<p>ログインに失敗しました</p>
<a href="/docotsubu/">TOPへ</a>
<% } %>
</body>
</html>