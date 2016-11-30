<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.List" %>
<body>
<form action="<%=request.getContextPath() %>/usercheck" method="GET">
<%
String st_addmsg = (String)request.getAttribute("error_msg");
List<String> get = (List<String>)request.getAttribute("LIST");
	if( st_addmsg != null ){
%>
		<h2><%= st_addmsg %></h2>
<% for(int i=0; i<get.size(); i++){ %>
		<% String list_p = get.get(i); %>
		<%= list_p %><br>
	<%} %>
	<hr>

<% } %>

<table>
<tr>
<td>メールアドレス</td>
<td>【必須】</td>
<td><input type="text" name="mail"></td>
<td>(半角英数)</td>
</tr>
<tr>
<td></td>
<td></td>
<td>※確認のため再度入力お願いします</td>
</tr>
<tr>
<td></td>
<td></td>
<td><input type="text" name="re_mail"></td>
<td>(半角英数)</td>
</tr>



<tr>
<td>ユーザID</td>
<td>【必須】</td>
<td><input type="text" name="use_ID"></td>
<td>(6文字以上半角英数)</td>
</tr>



<tr>
<td>パスワード</td>
<td>【必須】</td>
<td><input type="text" name="passward"></td>
<td>(6文字以上半角英数)</td>
<tr>
<td></td>
<td></td>
<td>※確認のため再度入力お願いします</td>
</tr>
<tr>
<td></td>
<td></td>
<td><input type="text" name="re_passward"></td>
<td>(6文字以上半角英数)</td>
</tr>



<tr>
<td>氏名</td>
<td>【必須】</td>
<td>(姓)<input type="text" name="name_sei"></td>
<td>(名)<input type="text" name="name_mei"></td>
</tr>



<tr>
<td>フリガナ</td>
<td>【必須】</td>
<td>(セイ)<input type="text" name="furi_sei"></td>
<td>(メイ)<input type="text" name="furi_mei"></td>
</tr>



<tr>
<td>都道府県</td>
<td></td>
<td><select name="pref">
<option value="" selected>都道府県
<option value="北海道">北海道
<option value="青森県">青森県
<option value="岩手県">岩手県
<option value="宮城県">宮城県
<option value="秋田県">秋田県
<option value="山形県">山形県
<option value="福島県">福島県
<option value="茨城県">茨城県
<option value="栃木県">栃木県
<option value="群馬県">群馬県
<option value="埼玉県">埼玉県
<option value="千葉県">千葉県
<option value="東京都">東京都
<option value="神奈川県">神奈川県
<option value="新潟県">新潟県
<option value="富山県">富山県
<option value="石川県">石川県
<option value="福井県">福井県
<option value="山梨県">山梨県
<option value="長野県">長野県
<option value="岐阜県">岐阜県
<option value="静岡県">静岡県
<option value="愛知県">愛知県
<option value="三重県">三重県
<option value="滋賀県">滋賀県
<option value="京都府">京都府
<option value="大阪府">大阪府
<option value="兵庫県">兵庫県
<option value="奈良県">奈良県
<option value="和歌山県">和歌山県
<option value="鳥取県">鳥取県
<option value="島根県">島根県
<option value="岡山県">岡山県
<option value="広島県">広島県
<option value="山口県">山口県
<option value="徳島県">徳島県
<option value="香川県">香川県
<option value="愛媛県">愛媛県
<option value="高知県">高知県
<option value="福岡県">福岡県
<option value="佐賀県">佐賀県
<option value="長崎県">長崎県
<option value="熊本県">熊本県
<option value="大分県">大分県
<option value="宮崎県">宮崎県
<option value="鹿児島県">鹿児島県
<option value="沖縄県">沖縄県
</select>
</td>
</tr>



<tr>
<td>住所</td>
<td></td>
<td colspan =3><input type="text" name="address"></td>
</tr>



<tr>
<td>生年月日</td>
<td></td>
<td><input type="text" name="birth_y">年</td>
<td><input type="text" name="birth_m">月</td>
<td><input type="text" name="birth_d">日</td>
</tr>



<tr>
<td>性別</td>
<td>【必須】</td>
<td><input type="radio" name="sex" value="M" checked>男性</td>
<td><input type="radio" name="sex" value="F">女性</td>
</tr>
</table>
<button> 次へ</button>
</form>
</body>
</html>