<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">


    <title>会員情報更新</title>

</head>
<H1>会員情報更新確認画面</H1>
<body>

			<!-- 会員登録フォーム -->
			<form  action="<%=request.getContextPath() %>/memberFinish" method="POST">
			<table border="1" style="width: 362px; height: 312px">
			<tr>
				<tr>
					<td style="height: 25px; width: 226px">ユーザID</td>
					<td style="height: 25px; width: 10px"><%=session.getAttribute("userid")  %></td>
				</tr>
				<tr>
					<td style="width: 226px">氏名</td>
					<td style="width: 10px"><%=session.getAttribute("shimei")  %></td>
				</tr>
				<tr>
					<td style="width: 226px">生年月日</td>
					<td style="width: 10px"><%=session.getAttribute("birthday")  %></td>
				</tr>
				<tr>
					<td style="width: 226px">性別</td>
					<td style="width: 10px"><%=session.getAttribute("seibetsu")  %></td>
				</tr>
				<tr>
					<td style="width: 226px">メールアドレス</td>
					<td style="width: 10px"><%=session.getAttribute("mailadress") %></td>
				</tr>
				<tr>
				<td style="height: 55px; width: 226px">住所</td>
					<td style="width: 10px; height: 55px"><%=session.getAttribute("adress")  %></td>
				</tr>
				<tr>
					<td style="width: 226px">パスワード</td>
					<td style="width: 10px"><%=session.getAttribute("password")  %></td>

			</table>

				<button type="submit" style="width: 354px; height: 31px" >会員情報更新確定</button>
			</form>

</body>

</html>