<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*"%>
<html>
<body>

<h2>データの追加が完了しました。</h2>

<%session.removeAttribute("adddate");%>
<%session.removeAttribute("restname");%>
<%session.removeAttribute("totalmoney");%>

<form method="POST" action="./kakeibo_main.jsp">
<input type="submit" value="家計簿情報画面へ" />
</form>

</body>
</html>