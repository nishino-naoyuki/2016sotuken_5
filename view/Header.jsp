<!DOCTYPE html>
<html>
	<!-- <%@ page contentType="text/html; charset=utf-8" %> -->
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
		<title>共通ヘッダ</title>
	</head>
	<%
		HttpSession ssn = request.getSession(true);
		String LN = (String)ssn.getAttribute("loginName");
		String ref0;

		String ref2;
		String ref3;
		//以下URL設定
		//web.xmlの設定に従い書きなおすこと
		if(LN != null){
			ref0 = "vdissr";

			ref2 = "vdishr";
			ref3 = "vdisus";
		}else{
			ref0 = "vdisli";

			ref2 = "vdisli";
			ref3 = "vdisli";
		}
		String inout;
		String mb;
		String mbalt;
		if(LN != null){
			inout = "vdislo";
			mb = "out";
			mbalt = "ログアウト";
		}else{
			inout = "vdisli";
			mb = "in";
			mbalt = "ログイン";
		}
     %>
	<body>
	<div id="background">
		<div id="header">
			<div id="indicate">
				<span class="logo">
					<a href="<%=request.getContextPath() %>/vdisho">
						<img src="${pageContext.request.contextPath}/view/sarara_logo.png" alt="飲食店情報検索サービス「さらら」" height=100px>
					</a>
				</span>
				<span class="logout">
					<a href="<%=request.getContextPath() %>/<%=ref0%>">
						<img id="bb" src="${pageContext.request.contextPath}/view/mb01.png" alt="検索" height="50px"></a>

					<a href="<%=request.getContextPath() %>/<%=ref2%>">
						<img id="bb" src="${pageContext.request.contextPath}/view/mb07.png" alt="家計簿" height="50px"></a>
					<a href="<%=request.getContextPath() %>/<%=ref3%>">
						<img id="bb" src="${pageContext.request.contextPath}/view/mb04.png" alt="会員" height="50px"></a>

					<a href="<%=request.getContextPath() %>/<%=inout%>">
						<img id="bb" src="${pageContext.request.contextPath}/view/mb05<%=mb%>.png" alt="<%=mbalt%>" height="50px"></a>
				</span>
				<span class="status">
				<!-- ログインしていればユーザー名、
				     ログインしていなければ文言を表示する -->
				     <%
				     String sts;
				     if(LN != null){
				    	 sts = "ようこそ、" + LN + "さん。今日は何を調べますか?";
				     }else{
				    	 sts = "サービスを利用するには、ログインしてください。";
				     }
				     %>
					<%=sts%>
				</span>
			</div>
		</div>
	</div>
	</body>
</html>