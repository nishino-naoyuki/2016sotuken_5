<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">



    <title>会員情報更新</title>

</head>

<body>
<h1>メニュー情報更新入力画面</h1>

			<!-- 会員登録フォーム -->
			<form  action="<%=request.getContextPath() %>/confirmEntrymenu" method="POST">
			<table border="1" style="width: 506px; height: 620px">
			<tr>
				<tr>
					<td style="width: 124px">メニューID</td>
					<td><input type="text" name="menuid" value="<%=request.getAttribute("mn_id") %>"></td>
				</tr>

			<tr>
				<tr>
					<td style="width: 124px">登録対象店舗</td>
					<td><input type="text" name="tenpoid"  value="<%=request.getAttribute("tenpoid") %>"></td>
				</tr>
				<tr>
					<td>登録メニュー名</td>

				<td><input type="text" name="menunnamae" value="<%=request.getAttribute("menunamae") %>" > </td>
				<tr>
					<td >価格</td>
					<td><input type="text" name="kakaku" value="<%=request.getAttribute("kakaku") %>" > </td>
				</tr>
				<tr>
					<td>カテゴリ</td>
					<td><input type="text" name="genre" value="<%=request.getAttribute("genre") %>" ></td>
				</tr>
				<tr>
					<td>販売期間</td>
				    <td><input type="text" name="kikan1" value="<%=request.getAttribute("kikan1") %>" ></td>
					<td><input type="text" name="kikan2" value="<%=request.getAttribute("kikan2") %>" ></td>
				</tr>


			</table>

				<button type="submit">メニュー更新確認画面へ</button>
			</form>

</body>

</html>