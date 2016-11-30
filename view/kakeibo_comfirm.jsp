<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*"%>

<%!
// サーブレットのinitメソッドに相当
public void jspInit() {
    try {
        // JDBCドライバをロード
        Class.forName("com.mysql.jdbc.Driver");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家計簿確認画面</title>
</head>

<body>

<% request.setCharacterEncoding("UTF-8"); %>

<H2>家計簿追加内容</H2>

<p>※以下の内容に問題が無ければ、<br>「上記の内容で追加する」
	ボタンを押して下さい。
</p>

<%--  <form method="POST" action="./KakeiboUpdate"> --%>

<table border='1'>
	<tr>
		<th>記録日</th>
		<th>店舗名</th>
		<th>支出合計</th>
	</tr>

	<tr>
		<td><%=(String)session.getAttribute("adddate") %></td>
		<td><%=(String)session.getAttribute("restname") %></td>
		<td><%=(String)session.getAttribute("totalmoney") %></td>
	</tr>
</table>

<br><br>

<form method="POST" action="./kakeibo_main.jsp">
<input type="submit" value="戻る" />
</form>

<form method="POST" action="./KakeiboUpdate">
<input type="submit" value="上記の内容で追加する" />
</form>

</body>
</html>