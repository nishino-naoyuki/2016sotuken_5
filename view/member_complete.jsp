<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<title>会員更新完了画面</title>
</head>
<H1>会員情報更新完了画面</H1>
<body>

<form  action="<%=request.getContextPath() %>/member_update" method="POST">
会員情報の更新が完了しました

<button type="submit" style="width: 294px; height: 27px" >メニュー画面へ戻る</button>
</form>
<body>
</html>