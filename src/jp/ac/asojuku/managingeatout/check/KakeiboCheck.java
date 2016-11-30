package jp.ac.asojuku.managingeatout.check;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakeiboCheck extends HttpServlet {

	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
				throws ServletException, IOException {

		//入力エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		//入力パラメータの取得
		String  adddate   = request.getParameter("adddate");
		String  restname   = request.getParameter("restname");
		String  totalmoney   = request.getParameter("totalmoney");

		//文字数チェック
		int r = stringLengthCheck(restname , 1, 20);

		if(r != 0){
			RequestDispatcher rd = request.getRequestDispatcher("./kakeibo_error.jsp");
			rd.forward(request, response);
			return;
		}

	/**	isNumMatch(totalmoney); */


		//Int型に変換して整数チェック
		try{
			int i = Integer.parseInt(totalmoney);
		}catch(NumberFormatException e){
			RequestDispatcher rd = request.getRequestDispatcher("./kakeibo_error.jsp");
			rd.forward(request, response);
			return;
		}

	// System.out.println("doPost");
	/**checkDate(adddate); */

	//日付チェック
	Date d = DateUtils.toDate(adddate);

	if(d == null){
		RequestDispatcher rd = request.getRequestDispatcher("./kakeibo_error.jsp");
		rd.forward(request, response);
		return;
	}

	//セッションと遷移処理
	HttpSession session = request.getSession(true);
	session.setAttribute("adddate",adddate);
	session.setAttribute("restname",restname);
	session.setAttribute("totalmoney",totalmoney);
	RequestDispatcher rd = request.getRequestDispatcher("./kakeibo_comfirm.jsp");
	rd.forward(request, response);

	}

	/**
	 * 日付の妥当性チェックを行います。
	 * 指定した日付文字列（yyyy/MM/dd or yyyy-MM-dd）が
	 * カレンダーに存在するかどうかを返します。
	 * @param strDate チェック対象の文字列
	 * @return 存在する日付の場合true
	 */
	/** public static boolean checkDate(String strDate) {
	    if (strDate == null || strDate.length() != 10) {
	        throw new IllegalArgumentException(
	                "引数の文字列["+ strDate +"]" +
	                "は不正です。");
	    }
	    strDate = strDate.replace('-', '/');
	    DateFormat format = DateFormat.getDateInstance();
	    // 日付/時刻解析を厳密に行うかどうかを設定する。
	    format.setLenient(false);
	    try {
	        format.parse(strDate);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}

	*/


	/**static boolean isNumMatch(String number) {
	    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[0-9]*$");
	    java.util.regex.Matcher matcher = pattern.matcher(number);
	    return matcher.matches();
	} */

	public boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}

	/**
	 * 文字列中の文字数を半角文字基準でチェックする
	 *
	 * @param input チェック対象の文字列
	 * @param min 許容最小文字数
	 * @param max 許容最大文字数
	 * @return チェック結果。0なら許容内。負の値なら不足分。正の値なら超過分。
	 */
	static public int stringLengthCheck(String input, int min, int max) {
	    // 全角の場合の対処も考慮して、何バイト分の長さであるかを取得
	    int length = input.getBytes().length;
	    if(length < min) { // 最小文字数よりも少なかった場合
	        return length - min;
	    }
	    if(length > max) { // 最大文字数よりも多かった場合
	        return length - max;
	    }
	    return 0; // 許容内であった場合
	}

}
