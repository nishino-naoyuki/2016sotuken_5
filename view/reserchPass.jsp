<!DOCTYPE html>
<html>
	<!-- <%@ page contentType="text/html; charset=utf-8" %> -->
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css" type="text/css">
		<title>ログイン画面</title>
	</head>

	<body>
	<div id="background">
		<div id="header">
			<div id="indicate">
				<span class="logo">
					<img src="${pageContext.request.contextPath}/view/GRTS_logo.png" alt="" width=84px>
				</span>
				<span class="title">
					検定情報管理システム
				</span>
				<!-- ログアウトボタンは画像にする(しない) -->
				<form action="" method="get">
					<input class="logout" type="button" value="ログアウト">
				</form>


				<span class="status">
				<!-- セッションに保存してある(はずの)opr_flgを参照する -->
					製作中
				</span>
			</div>
			<div id="pankuzu">
				トップメニュー → 受験済検定検索画面
			</div>
		</div>
		<div id="mainbody">
			<p>検索条件を入力してください</p>
				<div class="em">
					<%
					String err = null;
					err = (String)session.getAttribute("input_errormessage");
					session.removeAttribute("input_errormessage");
					if((err != null) && (err != "ok")){
					%>
					<%= err %>
					<%
					}
					%>



				</div>

				<form action="<%=request.getContextPath() %>/cresps" method="GET">
					<div id="inputform">
					<table>
						<tr><th>検定名</th><td><input type="text" name="pass_nm" size="50" maxlength="50"></td></tr>
						<tr><th>検定ID</th><td><input type="text" name="pass_id" size="50" maxlength="50"></td></tr>
						<tr><th>検定実施日</th><td><select name="passdate_y">
								<option value="null">---</option>
								<option value="2000">2000</option>
								<option value="2001">2001</option>
								<option value="2002">2002</option>
								<option value="2003">2003</option>
								<option value="2004">2004</option>
								<option value="2005">2005</option>
								<option value="2006">2006</option>
								<option value="2007">2007</option>
								<option value="2008">2008</option>
								<option value="2009">2009</option>
								<option value="2010">2010</option>
								<option value="2011">2011</option>
								<option value="2012">2012</option>
								<option value="2013">2013</option>
								<option value="2014">2014</option>
								<option value="2015">2015</option>
								<option value="2016">2016</option>
							</select>年
						<select name="passdate_m">
								<option value="null">---</option>
								<option value="1">01</option>
								<option value="2">02</option>
								<option value="3">03</option>
								<option value="4">04</option>
								<option value="5">05</option>
								<option value="6">06</option>
								<option value="7">07</option>
								<option value="8">08</option>
								<option value="9">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>月
						<select name="passdate_d">
								<option value="null">---</option>
								<option value="1">01</option>
								<option value="2">02</option>
								<option value="3">03</option>
								<option value="4">04</option>
								<option value="5">05</option>
								<option value="6">06</option>
								<option value="7">07</option>
								<option value="8">08</option>
								<option value="9">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
							</select>日</td></tr>
						<tr><th>主催者名</th><td><input type="text" name="cert_nm" size="50" maxlength="50"></td></tr>
						<tr><th>合否</th><td><select name="cert_okng">
								<option value="ok">合格のみ</option>
								<option value="ng">不合格のみ</option>
								<option value="both">両方含む</option>
							</select>
						</td></tr>
						<tr><th>学籍番号</th><td><input type="text" name="user_id" size="7" maxlength="7"></td></tr>
					</table>
					</div>
					<button type="submit">検索</button>
				</form>
			</div>

	</div>
	</body>
</html>