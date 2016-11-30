package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.ac.asojuku.managingeatout.DTO.MenuInfoDTO;

public class MenuUpdateAction extends HttpServlet {

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mn_id = "00000002";


		try {
			MenuInfoDTO menuInfo = getMemberInfoByUserPassword(mn_id);

			req.setAttribute("mn_id", mn_id);
			req.setAttribute("tenpoid", menuInfo.getMn_restid());
			req.setAttribute("menunamae", menuInfo.getMn_name());
			req.setAttribute("kakaku",menuInfo.getMn_price());
			req.setAttribute("genre", menuInfo.getMn_cat());
			req.setAttribute("kikan1", menuInfo.getMn_startdate());
			req.setAttribute("kikan2", menuInfo.getMn_enddate());

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		RequestDispatcher rd = req.getRequestDispatcher("view/menu_update.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward (req, resp);
	}

	//private MenuInfoDTO getMemberInfoByUserPassword(String menuid,String password)
	private MenuInfoDTO getMemberInfoByUserPassword(String mn_id)
			throws SQLException, NamingException{


		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InitialContext ctx;
		MenuInfoDTO menuinfo = null;

		try {
			ctx = new InitialContext();

			DataSource ds =
			(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
			con = ds.getConnection();

			// ステートメント生成
			ps = con.prepareStatement("select * from menu where mn_id =?");

			// パラメータをセット
	        ps.setString(1, mn_id);


			// SQLを実行
			rs = ps.executeQuery();

			//値を取り出す
			while(rs.next()){
				menuinfo = new MenuInfoDTO();
				menuinfo.setMn_id( rs.getString("mn_id") );
				menuinfo.setMn_restid( rs.getString("mn_restid"));
				menuinfo.setMn_name( rs.getString("mn_name") );
				menuinfo.setMn_price( rs.getInt("mn_price"));
				menuinfo.setMn_cat( rs.getString("mn_cat") );
				menuinfo.setMn_startdate(rs.getDate("mn_startdate") );
				menuinfo.setMn_enddate( rs.getDate("mn_enddate") );

				//logonInfo = new LogonInfoDTO();
				//logonInfoへ値を入れる
				//logonInfo.setName(rs.getString("NAME"));

			}

		} finally{
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

		return menuinfo;

	}
}
