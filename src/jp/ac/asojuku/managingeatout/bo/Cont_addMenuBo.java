package jp.ac.asojuku.managingeatout.bo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import jp.ac.asojuku.managingeatout.dto.Cont_LogonInfoDTO;

public class Cont_addMenuBo extends javax.servlet.http.HttpServlet{
	//SQL文発行を伴うメニュー追加処理

	private static final String SQL_GET_DATE =
			"SELECT curdate() AS currentdate";
	private static final String SQL_ADD_MENU =
			"INSERT INTO menu(mn_restid, mn_name, mn_cat, mn_price, mn_startdate, mn_enddate, mn_update, mn_manager)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, 0001)";
			//"SELECT us_name FROM user WHERE us_id=? AND us_pass=?";

	Cont_LogonInfoDTO logonInfo = null;

	/**
	 * ログイン処理を行う
	 * @param userName
	 * @param password
	 * @return ログイン情報（ログイン失敗時はnull）
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Cont_LogonInfoDTO login = null;

		//HttpSession ssn = req.getSession(true);






		try {
			//DBへ接続し、値を取得する
			logonInfo = setMenuByInput(req);
			//login = getMemberInfoByUserPassword(userName,passWord);

		} catch (NamingException e) {
			//TODO:ログをはくなどする

		} catch (SQLException e) {
			//TODO:ログをはくなどする

		}
		RequestDispatcher rd = req.getRequestDispatcher("/vdisho");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);


		return;
		//return login;
	}

	/**
	 * DBへ接続し、値を取得する
	 * @param userName
	 * @param passWord
	 * @return ログイン情報
	 * @throws SQLException
	 * @throws NamingException
	 */
	@SuppressWarnings("resource")
	private Cont_LogonInfoDTO setMenuByInput(HttpServletRequest req)
													throws SQLException, NamingException{

		//Cont_LogonInfoDTO logonInfo = null;
		Connection con = null;
		PreparedStatement ps = null;
		//RequestDispatcher rd = null;
		ResultSet rs = null;
		InitialContext ctx;

		//セッション確立再確認
		HttpSession ssn = req.getSession(true);
				//String loginName = "";

		String RN = (String)ssn.getAttribute("RN");
		String AM = (String)ssn.getAttribute("AM");
		String AP = (String)ssn.getAttribute("AP");
		String AC = (String)ssn.getAttribute("AC");
		String SD = (String)ssn.getAttribute("SD");
		String ED = (String)ssn.getAttribute("ED");

        try{
			ctx = new InitialContext();

        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/safres_data");

			// MySQLに接続
	        con = ds.getConnection();

    		// ステートメント生成
			ps = con.prepareStatement(SQL_GET_DATE);

			// SQLを実行(日付取得)
	        rs = ps.executeQuery();

	        //String CD = rs.getString("curdate()");
	        String CD = rs.getString("currentdate");




        	ps = con.prepareStatement(SQL_ADD_MENU);

        	// パラメータをセット
        	ps.setString(1,RN);
        	ps.setString(2,AM);
        	ps.setString(3,AP);
        	ps.setString(4,AC);
        	ps.setString(5,SD);
        	ps.setString(6,ED);
        	ps.setString(7,CD);


	        // SQLを実行
	        rs = ps.executeQuery();

	        //値を取り出す


	        /*if(loginName == null){
	        	String error = "IDまたはパスワードが間違っています。再度確認して入力してください";
	        	ssn.setAttribute("error", error);
	        }else{
	        	String error = "";
	        	ssn.setAttribute("error", error);
	        }*/

        }finally{
        	try{
		        // 接続を閉じる
	        	if( rs != null ){
		        	rs.close();
	        	}
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

		return logonInfo;
		//return login;
	}

	/*
	public static String nowDate(String args[]){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String dt = null;

		return dt;
	}
	*/


}
