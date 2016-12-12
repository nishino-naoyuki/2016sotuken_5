<!DOCTYPE html>
<html>
	<!-- <%@ page contentType="text/html; charset=utf-8" %> -->
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
		<title>ホーム画面</title>
	</head>
	<%
		HttpSession ssn = request.getSession(true);
		String LN = (String)ssn.getAttribute("loginName");
		String ref0;
		String ref1;
		String ref2;
		String ref3;
		//以下URL設定
		//web.xmlの設定に従い書きなおすこと
		if(LN != null){
			ref0 = "vdissr";
			ref1 = "vdisab";
			ref2 = "vdisus";
			ref3 = "vdisuo";
		}else{
			ref0 = "vdisli";
			ref1 = "vdisli";
			ref2 = "vdisli";
			ref3 = "vdisli";
		}
		String inout;
		if(LN != null){
			inout = "vdislo";
		}else{
			inout = "vdisli";
		}
     %>

	<body>
	<div id="background">

		<jsp:include page="Header.jsp" />
		<div id="pankuzu">
			ホーム画面
		</div>

		<div id="mainbody">

			<div id="button"><a href="<%=request.getContextPath() %>/<%=ref0%>">
				<img id="bb" src="${pageContext.request.contextPath}/view/bb01.png" alt="検索" height="80px"></a></div><br>
			<!-- お気に入り跡地 -->
			<div id="button"><a href="<%=request.getContextPath() %>/<%=ref1%>">
				<img id="bb"src="${pageContext.request.contextPath}/view/bb07.png" alt="家計簿" height="80px"></a></div><br>
			<div id="button"><a href="<%=request.getContextPath() %>/<%=ref2%>">
				<img id="bb"src="${pageContext.request.contextPath}/view/bb05.png" alt="会員情報変更" height="80px"></a></div><br>
			<div id="button"><a href="<%=request.getContextPath() %>/<%=ref3%>">
				<img id="bb"src="${pageContext.request.contextPath}/view/bb06.png" alt="退会" height="80px"></a></div><br>

		</div>

	</div>
	</body>
</html>