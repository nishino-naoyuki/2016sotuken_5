<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家計簿確認画面</title>
</head>

<body>

<% request.setCharacterEncoding("UTF-8"); %>

<H2>エラーが発生しました</H2>

<p>入力内容をもう一度ご確認下さい。</p>

<ul>
	<li>記録日は西暦年月日を半角「/」で区切り入力してください。　入力例：1990/01/01</li>
	<li>店舗名は1文字～20文字以内で入力してください。</li>
	<li>支出合計は半角または全角で数字のみを入力してください。　入力例：1234</li>
</ul>

<form method="POST" action="./kakeibo_main.jsp">
<input type="submit" value="戻る" />
</form>

</body>

</html>