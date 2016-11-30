<!DOCTYPE html>
<html>
	<!-- <%@ page contentType="text/html; charset=utf-8" %> -->
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
		<title>メニュー追加確認画面</title>
	</head>

	<body>
	<div id="background">
		<!-- 共通ヘッダ適用 -->
		<jsp:include page="Header.jsp" />
		<div id="pankuzu">
			管理者ホーム > メニュー登録画面 > メニュー確認画面
		</div>
		<div id="mainbody">
			<p>メニュー新規登録確認</p>
			以下の情報でメニューを登録します。<br>
			入力した情報に間違いが無いか確認してください。<br>

			<!-- テーブル形式で表示 -->
			<%
			String RN = (String)session.getAttribute("RN");
			String AM = (String)session.getAttribute("AM");
			String AP = (String)session.getAttribute("AP");
			String AC = (String)session.getAttribute("AC");
			String SD = (String)session.getAttribute("SD");
			String ED = (String)session.getAttribute("ED");
			%>

			<table>
				<tr><th>登録対象店舗</th><td><%=RN%></td></tr>
				<tr><th>登録メニュー名</th><td><%=AM%></td></tr>
				<tr><th>登録価格</th><td><%=AP%>円</td></tr>
				<tr><th>登録ジャンル</th><td><%=AC%></td></tr>
				<tr><th>販売期間</th><td>
				<%
				if((SD == null) && (ED == null)){
				%>設定なし
				<%
				}else{
				%><%=SD%>から<%=ED%>まで
				<%
				}
				%>

				</td></tr>
			</table>

			<div id="minibutton"><a href="">入力画面に戻る</a></div>
			<!-- メニュー登録処理.javaに飛ばす -->
			<div id="minibutton"><a href="<%=request.getContextPath() %>/caddmn">確認する</a></div>

		</div>
	</div>
	</body>
</html>