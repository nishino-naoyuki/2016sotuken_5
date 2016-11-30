<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=utf-8" %>
<head>
	<title>飲食店検索</title>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="kensaku.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="<%=request.getContextPath() %>/callapi" method="POST">
	<h1 id="no-01">飲食店検索</h1>
	<article>
	<p>検索したい店舗名を入力して下さい。</p>
	<table>
		<tr>
			<td>
				<select name="pref">
					 <option value="" selected>都道府県</option>
					 <option value="PREF01">北海道</option>
					 <option value="PREF02">青森県</option>
					 <option value="PREF03">岩手県</option>
					 <option value="PREF04">宮城県</option>
					 <option value="PREF05">秋田県</option>
					 <option value="PREF06">山形県</option>
					 <option value="PREF07">福島県</option>
					 <option value="PREF08">茨城県</option>
					 <option value="PREF09">栃木県</option>
					 <option value="PREF10">群馬県</option>
					 <option value="PREF11">埼玉県</option>
					 <option value="PREF12">千葉県</option>
					 <option value="PREF13">東京都</option>
					 <option value="PREF14">神奈川県</option>
					 <option value="PREF15">新潟県</option>
					 <option value="PREF16">富山県</option>
					 <option value="PREF17">石川県</option>
					 <option value="PREF18">福井県</option>
					 <option value="PREF19">山梨県</option>
					 <option value="PREF20">長野県</option>
					 <option value="PREF21">岐阜県</option>
					 <option value="PREF22">静岡県</option>
					 <option value="PREF23">愛知県</option>
					 <option value="PREF24">三重県</option>
					 <option value="PREF25">滋賀県</option>
					 <option value="PREF26">京都府</option>
					 <option value="PREF27">大阪府</option>
					 <option value="PREF28">兵庫県</option>
					 <option value="PREF29">奈良県</option>
					 <option value="PREF30">和歌山県</option>
					 <option value="PREF31">鳥取県</option>
					 <option value="PREF32">島根県</option>
					 <option value="PREF33">岡山県</option>
					 <option value="PREF34">広島県</option>
					 <option value="PREF35">山口県</option>
					 <option value="PREF36">徳島県</option>
					 <option value="PREF37">香川県</option>
					 <option value="PREF38">愛媛県</option>
					 <option value="PREF39">高知県</option>
					 <option value="PREF40">福岡県</option>
					 <option value="PREF41">佐賀県</option>
					 <option value="PREF42">長崎県</option>
					 <option value="PREF43">熊本県</option>
					 <option value="PREF44">大分県</option>
					 <option value="PREF45">宮崎県</option>
					 <option value="PREF46">鹿児島県</option>
					 <option value="PREF47">沖縄県</option>
					</select>
				<input type="text" name="shopname" value="" >
				<input type="submit" value="検索" >
			</td>
		</tr>
	</table>
	</article>
</form>

</body>

</html>
