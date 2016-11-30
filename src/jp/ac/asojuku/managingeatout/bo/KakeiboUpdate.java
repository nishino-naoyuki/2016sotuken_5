package insyoku;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class KakeiboUpdate extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{


		String msg = "";
		Connection con = null;
		PreparedStatement ps = null;
		RequestDispatcher rd = null;
        try {

        	InitialContext ctx = new InitialContext();

        	DataSource ds =
        		(DataSource)ctx.lookup("java:comp/env/jdbc/myds");

			// MySQLに接続
	        con = ds.getConnection();

        	// int id = 0;
        	// int age = 0;
        	int itotalmoney = 0;

        	HttpSession session = request.getSession(true);
        	// dbdisp.jspからの情報を取得する
        	String adddate = (String)session.getAttribute("adddate");
        	String restname = (String)session.getAttribute("restname");
        	String totalmoney = (String)session.getAttribute("totalmoney");
        	// String adress = (String)session.getAttribute("adress");

        	//数値変換
        	if( totalmoney != null ){
        		itotalmoney = Integer.parseInt(totalmoney);
        	}

			// ステートメント生成
        	String sqlStr = "INSERT INTO book(bk_manageid,bk_userid,bk_restname,bk_add,bk_total) VALUES(null,?,?,?,?)";
	        ps = con.prepareStatement(sqlStr);

        	// パラメータをセット
        	ps.setString(1,"0000000001");
        	ps.setString(2,restname);
        	ps.setDate(3,new java.sql.Date(DateUtils.toDate(adddate).getTime()));
        	ps.setInt(4,itotalmoney);

	        // SQLを実行
	        ps.executeUpdate();

			//JSPファイルへフォワードする RequestDispatcher オブジェクト
			rd = request.getRequestDispatcher("./kakeibo_fin.jsp");
			rd.forward(request, response);
			return;

        } catch (Exception e){
			//例外発生時の処理
        	request.setAttribute("errMessage",e.getMessage());
			//JSPファイルへフォワードする RequestDispatcher オブジェクト
			rd = request.getRequestDispatcher("./kakeibo_error.jsp");
			rd.forward(request, response);
			return;
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
        		 msg = "closeに失敗しました";
        	}
        }
	}
}