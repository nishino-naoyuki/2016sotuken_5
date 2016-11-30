package jp.ac.asojuku.food.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserAddBo {

	private static final String INSERT_MEMBER_SQL =
			"INSERT INTO user(us_id,us_name,us_birth,us_gender,us_mail,us_address,us_pass,us_mf,us_date)VALUES(?,?,?,?,?,?,?,'0','2016-11-02')";

	public void insertMemberInfo(String us_id,String us_name, String us_birth,String us_gender,String us_mail,String us_adderss,String us_pass)throws SQLException, NamingException{



		Connection con = null;
		PreparedStatement ps = null;
		InitialContext ctx;

		try {
			ctx = new InitialContext();
			DataSource ds =(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
			con = ds.getConnection();

			// ステートメント生成
			ps = con.prepareStatement(INSERT_MEMBER_SQL);


			// INSERT文に値を設定する
			ps.setString(1, us_id);
			ps.setString(2, us_name);
			ps.setString(3, us_birth);
			ps.setString(4, us_gender);
			ps.setString(5, us_mail);
			ps.setString(6, us_adderss);
			ps.setString(7, us_pass);



			// SQLを実行
			ps.executeUpdate();

			System.out.println("登録OK");
		} finally{
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
