package jp.ac.asojuku.managingeatout.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.ac.asojuku.managingeatout.dto.HistoryDto;

public class HistoryBo {
	private static final String SELECT_History_SQL = "select hs_add,hs_restid FORM history WHERE hs_userid = ?";

	public HistoryDto HistoryUserCheck(String us_id)throws SQLException, NamingException{

		HistoryDto historyDTO = null;
		Connection con = null;
		PreparedStatement ps = null;
		InitialContext ctx;
		ResultSet rs = null;

		try {
			ctx = new InitialContext();
			DataSource ds =(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
			con = ds.getConnection();

			// ステートメント生成
			ps = con.prepareStatement(SELECT_History_SQL);


			// INSERT文に値を設定する
			ps.setString(1, us_id);


			// SQLを実行
			rs = ps.executeQuery();

			while(rs.next()){
				historyDTO = new HistoryDto();
				historyDTO.setHs_add(rs.getString("hs_add"));
			}

			System.out.println("OK");
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

		return historyDTO;

	}



}
