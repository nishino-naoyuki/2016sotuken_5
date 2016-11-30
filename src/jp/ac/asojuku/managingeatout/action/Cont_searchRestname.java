package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class Cont_searchRestname {
	//店舗IDから店舗名へ変換
	private static final String SQL_GET_NAME =
			"SELECT re_name FROM restaurant WHERE re_id = ?";

			//"SELECT us_name FROM user WHERE us_id=? AND us_pass=?";

	String IDtoNAME = null;


	public String searchRN(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//DBへ接続し、値を取得する
			IDtoNAME = (String)getMemberInfoByUserPassword(id,req,resp);
			//login = getMemberInfoByUserPassword(userName,passWord);

		} catch (NamingException e) {
			//TODO:ログをはくなどする

		} catch (SQLException e) {
			//TODO:ログをはくなどする

		}


		return IDtoNAME;
		//return login;
	}

	/**
	 * DBへ接続し、値を取得する
	 * @param userName
	 * @param req
	 * @return ログイン情報
	 * @throws SQLException
	 * @throws NamingException
	 */
	//@SuppressWarnings("resource")
	private String getMemberInfoByUserPassword(String id,HttpServletRequest req, HttpServletResponse resp)
													throws SQLException, NamingException{

		//Cont_LogonInfoDTO logonInfo = null;
		Connection con = null;
		PreparedStatement ps = null;
		//RequestDispatcher rd = null;
		ResultSet rs = null;
		InitialContext ctx;

		//セッション確立再確認
		HttpSession ssn = req.getSession(true);
		//String IDtoNAME = "";

		//String UD;

        try{
			ctx = new InitialContext();

        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/safres_data");

			// MySQLに接続
	        con = ds.getConnection();

    		// ステートメント生成
			ps = con.prepareStatement(SQL_GET_NAME);





        	// パラメータをセット
        	ps.setString(1,id);

	        // SQLを実行
	        rs = ps.executeQuery();

	        //値を取り出す
	        IDtoNAME = rs.getString("re_name");


	        if(IDtoNAME == null){
	        	IDtoNAME = "該当なし";
	        	ssn.setAttribute("error", IDtoNAME);
	        }

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
        //ssn.setAttribute("RN", IDtoNAME);

		return IDtoNAME;
		//return login;
	}


}
