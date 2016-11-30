<!DOCTYPE html>
<html>
	<!-- <%@ page contentType="text/html; charset=utf-8" %> -->
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
		<title>ログイン画面</title>
	</head>
	<%
		HttpSession ssn = request.getSession(true);
		String LN = (String)ssn.getAttribute("loginName");
	%>
	<body>
	<div id="background">
		<jsp:include page="Header.jsp" />
		<div id="pankuzu">
			ログイン画面
		</div>
		<div id="mainbody">
			<p>ログイン</p>
			ユーザーID、パスワードを入力してください。<br>
			<!-- エラーメッセージ表示 -->
			<div class="em">
				<%
				String err = null;
				err = (String)session.getAttribute("error");
				session.removeAttribute("error");
				if(err != null){
				%>
				<%= err %>
				<% } %>
			</div>
			<form action="<%=request.getContextPath() %>/cautus" method="post">
				<table>
					<tr><th>ユーザーID</th><td><input type="text" name="userid" size="20" maxlength="16"></td></tr>
					<tr><th>パスワード</th><td><input type="password" name="pass" size="36" maxlength="32"></td></tr>
				</table>
				<button type="submit" name="submit" value="ログイン">ログイン</button>
			</form>
			<div id="newcomer">
			会員登録がまだお済みでない方は<br>
				<a href="<%=request.getContextPath() %>/vdisua">新規会員登録</a>
			</div>
		</div>
	</div>
	</body>
</html>