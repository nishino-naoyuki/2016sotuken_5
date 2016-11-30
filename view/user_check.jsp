<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=utf-8" %>
<head>
<title>会員登録確認画面</title>
</head>

<body>
<%
String user[] = new String[13];

user[0] = "mail";
user[1] = "pass";
user[2] = "userid";
user[3] = "names";
user[4] = "namem";
user[5] = "furis";
user[6] = "furim";
user[7] = "pref";
user[8] = "addr";
user[9] = "birthy";
user[10] = "birthm";
user[11] = "birthd";
user[12] = "sex";
%>

<%
String userInfo[] = new String[13];
%>

<%
for (int i= 0 ; i < 13 ; i++) {
	userInfo[i] = (String)request.getAttribute(user[i]);
}

session = request.getSession(true);

session.setAttribute("mail",userInfo[0]);
session.setAttribute("pass",userInfo[1]);
session.setAttribute("userid",userInfo[2]);
session.setAttribute("names",userInfo[3]);
session.setAttribute("namem",userInfo[4]);
session.setAttribute("furis",userInfo[5]);
session.setAttribute("furim",userInfo[6]);
session.setAttribute("pref",userInfo[7]);
session.setAttribute("addr",userInfo[8]);
session.setAttribute("birthy",userInfo[9]);
session.setAttribute("birthm",userInfo[10]);
session.setAttribute("birthd",userInfo[11]);
session.setAttribute("sex",userInfo[12]);
%>
<form action="<%=request.getContextPath() %>/usercomp" method="GET">
<table>
<tr>
<td>メールアドレス</td>
<td><%= userInfo[0] %></td>
</tr>

<tr>
<td>パスワード</td>
<td><%= userInfo[1] %></td>
</tr>


<tr>
<td>ユーザID</td>
<td><%= userInfo[2] %></td>
</tr>

<tr>
<td>名前</td>
<td>姓<%= userInfo[3] %></td>
<td>名<%= userInfo[4] %></td>
</tr>

<tr>
<td>フリガナ</td>
<td>セイ<%= userInfo[5] %></td>
<td>メイ<%= userInfo[6] %></td>
</tr>

<tr>
<td>都道府県</td>
<td><%= userInfo[7] %></td>
</tr>

<tr>
<td>住所</td>
<td><%= userInfo[8] %></td>
</tr>

<tr>
<td>生年月日</td>
<td><%= userInfo[9] %>年</td>
<td><%= userInfo[10] %>月</td>
<td><%= userInfo[11] %>日</td>
</tr>

<tr>
<td>性別</td>
<td><%= userInfo[12] %></td>
</tr>
</table>

<button>登録</button>
</form>
</body>
</html>