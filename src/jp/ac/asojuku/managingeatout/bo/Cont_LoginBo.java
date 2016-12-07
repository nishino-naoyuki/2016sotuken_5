package jp.ac.asojuku.managingeatout.bo;

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

import jp.ac.asojuku.managingeatout.dto.Cont_LogonInfoDTO;

public class Cont_LoginBo {
	// ユーザーIDとパスワードを指定してユーザー情報を取得する
	private static final String MEMBER_INFO_BY_UP_SQL =
			"SELECT us_id, us_name FROM user WHERE us_id=? AND us_pass=?";

	Cont_LogonInfoDTO logonInfo = null;

	/**
	 * ログイン処理を行う
	 * @param userName
	 * @param password
	 * @return ログイン情報（ログイン失敗時はnull）
	 * @throws IOException
	 * @throws ServletException
	 */
	public Cont_LogonInfoDTO login(String userName, String passWord, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Cont_LogonInfoDTO login = null;





		try {
			//DBへ接続し、値を取得する
			logonInfo = getMemberInfoByUserPassword(userName,passWord,req);
			//login = getMemberInfoByUserPassword(userName,passWord);

		} catch (NamingException e) {
			//TODO:ログをはくなどする

		} catch (SQLException e) {
			//TODO:ログをはくなどする

		}


		return logonInfo;
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
	private Cont_LogonInfoDTO getMemberInfoByUserPassword(String userName,String passWord, HttpServletRequest req)
													throws SQLException, NamingException{

		//Cont_LogonInfoDTO logonInfo = null;
		Connection con = null;
		PreparedStatement ps = null;
		//RequestDispatcher rd = null;
		ResultSet rs = null;
		InitialContext ctx;

		//セッション確立再確認
				HttpSession ssn = req.getSession(true);
				String loginName = "";
				String loginId = "";

        try{
			ctx = new InitialContext();

        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/safres_data");

			// MySQLに接続
	        con = ds.getConnection();

    		// ステートメント生成
			ps = con.prepareStatement(MEMBER_INFO_BY_UP_SQL);

        	// パラメータをセット
        	ps.setString(1,userName);
        	ps.setString(2,passWord);

	        // SQLを実行
	        rs = ps.executeQuery();

	        //値を取り出す
	        while(rs.next()){
	        	logonInfo = new Cont_LogonInfoDTO();
	            //logonInfoへ値を入れる
	        	logonInfo.setName(rs.getString("us_name"));
	        	loginName = rs.getString("us_name");
	        	loginId = rs.getString("us_id");
	        	ssn.setAttribute("loginName", loginName);
	        	ssn.setAttribute("loginId", loginId);



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

		return logonInfo;
		//return login;
	}
}
