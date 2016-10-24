<!DOCTYPE html>
<html>

<head>

<%@ page contentType="text/html; charset=utf-8" %>

    <title>会員情報更新</title>

</head>

<body>

			<!-- 会員登録フォーム -->
			<form  action="<%=request.getContextPath() %>/confirmEntrymenber" method="POST">
			<table border="1">
				<tr>
					<td>メールアドレス</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text"></td>
				</tr>
			</table>

				<button type="submit" >更新確認画面へ</button>
			</form>

</body>

</html>