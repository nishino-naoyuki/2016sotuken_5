<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
<title>準備中</title>
</head>
<body>
<div id="background">
	<jsp:include page="Header.jsp" />
	<img id="con" src="${pageContext.request.contextPath}/view/const.png" alt="工事中" height="80px"><br>
	指定されたURLは只今準備中のため、表示できません。<br>
	お手数ですが、ブラウザの「戻る」ボタンでお戻りいただくか、<br>
	<a href="<%=request.getContextPath() %>/vdisho">トップページ</a>へお戻りください。
</div>
</body>
</html>