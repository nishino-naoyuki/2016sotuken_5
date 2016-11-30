<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">



    <title>会員情報更新</title>

</head>

<%
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");

String str2 = sdf1.format (request.getAttribute("birthday"));
%>

<body>
<h1>会員情報更新入力画面</h1>

			<!-- 会員登録フォーム -->
			<form  action="<%=request.getContextPath() %>/confirmEntrymenber" method="POST">
			<table border="1" style="width: 506px; height: 620px">
			<tr>
				<tr>
					<td style="width: 124px">ユーザID</td>
					<td><input name="userid" type="text"  ></td>
				</tr>
				<tr>
					<td style="width: 124px">氏名</td>
					<td>
					<input type="text" name="shimei"value="<%=request.getAttribute("shimei") %>" style="width: 223px" ></td>
				</tr>
				<tr>
					<td style="width: 124px">生年月日</td>
					<td><input type="text" name="birthday" value="<%=str2%>"style="width: 144px"></td>
				</tr>
				<tr>
				<td style="width: 124px">性別</td>
					<td><input type="radio" name="seibetsu" value="男" /> 男
						<input type="radio" name="seibetsu" value="女" /> 女</td>
				</tr>
				<tr>
					<td style="width: 124px">メールアドレス</td>
					<td>
					<input type="text" name="mailadress"  maxlength='256' value="<%=request.getAttribute("mailadress") %>" style="width: 278px; height: 31px"></td>
				</tr>

				<tr>
					<td style="width: 124px">住所</td>
					<td>
					<input type="text" name="adress" style="width: 306px; height: 59px"></td>
				</tr><tr>
				<tr>
					<td style="width: 124px">パスワード</td>
					<td>
					<input type="password" name="password" maxlength='16' style="width: 241px"></td>

			</table>

				<button type="submit" style="width: 294px; height: 27px" >更新確認画面へ</button>
			</form>

</body>

</html>