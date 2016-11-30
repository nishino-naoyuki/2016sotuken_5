package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


public class MemberFinishAction extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(true);

		String userid = (String)session.getAttribute("userid");
		String shimei = (String)session.getAttribute("shimei");
		String birthday =(String)session.getAttribute("birthday");
		String seibetsu = (String)session.getAttribute("seibetsu");
		String mailadress = (String)session.getAttribute("mailadress");
		String adress = (String)session.getAttribute("adress");
		String password = (String)session.getAttribute("password");

		try {
			updateMemberInfo(userid,shimei,birthday,seibetsu,mailadress,adress,password);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("view/member_complete.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);

	}

	/**
	 * DBに接続して登録をする
	 *
	 * @param mailAddress
	 * @param name
	 * @param password
	 * @param telNumber
	 * @param address
	 * @throws SQLException
	 * @throws NamingException
	 * @throws ParseException
	 */
	private void updateMemberInfo(String userid,String shimei,String birthday,String seibetsu,String mailadress,String adress,String password)
													throws SQLException, NamingException, ParseException{

		Connection con = null;
		PreparedStatement ps = null;
		InitialContext ctx;

        try {
			ctx = new InitialContext();

        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
	        con = ds.getConnection();

    		// ステートメント生成
			ps = con.prepareStatement("update user set us_name=?, us_birth=?, us_gender=?, us_mail=?, us_address=?, us_pass=? where us_id=?");


			// 変換対象の日付文字列

			SimpleDateFormat birthday2 = new SimpleDateFormat("yyyy/MM/dd");

			//Date型変換
			java.util.Date formatDate = birthday2.parse(birthday);

			Calendar cal = Calendar.getInstance();
			cal.setTime(formatDate);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());



        	// パラメータをセット
			// INSERT文に値を設定する


 			ps.setString(1, shimei);
			ps.setDate(2, d2);
	        ps.setString(3, seibetsu);
	        ps.setString(4, mailadress);
	        ps.setString(5, adress);
	        ps.setString(6, password);
	        ps.setString(7, userid);


	        // SQLを実行
	        ps.executeUpdate();

			System.out.println("登録OK");
        } finally {
        	try{
		        // 接続を閉じる
	        	if( ps != null ){
		        	ps.close();
	        	}
	        	if( con != null ){
		        	con.close();
	        	}
        	}catch( SQLException e ){
        		 ;//無処理（close処理のエラーは無視）
        	}

		}

	}

}
