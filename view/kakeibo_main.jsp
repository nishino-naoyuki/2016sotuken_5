<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.sql.*"%>


<%String s = (String)session.getAttribute("loginName"); %>

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
<title>家計簿</title>
</head>

<body>

<% request.setCharacterEncoding("UTF-8"); %>

<H2>家計簿情報を表示しました</H2>

	・記録日は西暦年月日を半角「/」で区切り入力してください。　入力例：1990/01/01<br>
	・店舗名は1文字～20文字以内で入力してください。<br>
	・支出合計は半角または全角で数字のみを入力してください。　入力例：1234<br><br>


<form method="POST" action="./KakeiboCheck">

記録日<input type="text" name="adddate" value="" />
店舗名<input type="text" name="restname" value="" />
支出合計<input type="text" name="totalmoney" value="" />

<input type="submit" value="追加確認画面へ" />
</form>

<br>

<table border='1'><tr><th>記録日</th><th>店舗名</th><th>支出合計</th> </tr>

<%
        // データベースへのアクセス開始
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // データベースに接続するConnectionオブジェクトの取得
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost/safres_data",
                "test1", "tes10");
            // データベース操作を行うためのStatementオブジェクトの取得
            stmt = con.createStatement();
            // SQL()を実行して、結果を得る
            rs = stmt.executeQuery(
              "select bk_add, bk_total, bk_restname from book,user where bk_userid = us_id");

             // 得られた結果をレコードごとに表示
            while (rs.next()) {
%>

<%-- <h2><%= rs.getString("us_name") %>さんの家計簿情報</h2> --%>

                <tr>

                <%-- レコードの記録日フィールドを表示 --%>
                <td><%= rs.getDate("bk_add")%></td>
                <%-- レコードの店舗名フィールドを表示 --%>
                <td><%= rs.getString("bk_restname")%></td>
				<%-- レコードの支出合計フィールドを表示 --%>
                <td><%= rs.getInt("bk_total")%></td>

                </tr>

                <%
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースとの接続をクローズ
            try { rs.close(); } catch (Exception e) {}
            try { stmt.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
%>

		</table>

<br><br>

<form method="POST" action="Mypage.jsp">
<input type="submit" value="マイページへ戻る" />
</form>

</body>

</html>