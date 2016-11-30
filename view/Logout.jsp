<!DOCTYPE html>
<html>
	<!-- <%@ page contentType="text/html; charset=utf-8" %> -->
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
		<title>ログアウト画面</title>
	</head>

	<body>
	<div id="background">
		<jsp:include page="Header.jsp" />
		<div id="pankuzu">
			ログアウト画面
		</div>
		<div id="mainbody">
			<p>ログアウト処理が完了しました。</p><br>


			<a href="<%=request.getContextPath() %>/vdisho">ホーム画面へ戻る</a>

		</div>
	</div>
	</body>
</html>