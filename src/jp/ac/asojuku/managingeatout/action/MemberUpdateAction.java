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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import jp.ac.asojuku.managingeatout.DTO.UserInfoDTO;

public class MemberUpdateAction extends HttpServlet {

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(true);


		String us_id = (String) session.getAttribute("loginId");


		try {
			UserInfoDTO userInfo = getMemberInfoByUserPassword("us_id");

			req.setAttribute("us_id",us_id);
			req.setAttribute("mailadress", userInfo.getUs_mail());
			req.setAttribute("shimei", userInfo.getUs_name());
			req.setAttribute("birthday", userInfo.getUs_birth());
			req.setAttribute("seibetsu", userInfo.getUs_gender());
			req.setAttribute("adress", userInfo.getUs_address());
			req.setAttribute("password", userInfo.getUs_pass());

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		RequestDispatcher rd = req.getRequestDispatcher("view/member_update.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward (req, resp);
	}

	//private UserInfoDTO getMemberInfoByUserPassword(String userName,String password)
	private UserInfoDTO getMemberInfoByUserPassword(String us_id)
			throws SQLException, NamingException{


		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InitialContext ctx;
		UserInfoDTO userinfo = null;

		try {
			ctx = new InitialContext();

			DataSource ds =
			(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
			con = ds.getConnection();

			// ステートメント生成
			ps = con.prepareStatement("select * from user where us_id =?");

			// パラメータをセット
	        ps.setString(1, us_id);


			// SQLを実行
			rs = ps.executeQuery();

			//値を取り出す
			while(rs.next()){
				userinfo = new UserInfoDTO();
				userinfo.setUs_mail( rs.getString("us_mail") );
				userinfo.setUs_name( rs.getString("us_name") );
				userinfo.setUs_birth( rs.getDate("us_birth") );
				userinfo.setUs_gender( rs.getString("us_gender") );
				userinfo.setUs_address(rs.getString("us_address") );
				userinfo.setUs_pass( rs.getString("us_pass") );

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

		return userinfo;

	}
}