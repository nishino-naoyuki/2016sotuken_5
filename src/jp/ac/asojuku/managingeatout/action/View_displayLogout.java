package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * ログアウト画面_画面表示セクション
 */
public class View_displayLogout extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//セッション切断
		HttpSession ssn = req.getSession(true);
		ssn.invalidate();

		RequestDispatcher rd = req.getRequestDispatcher("view/Logout.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);
	}
}
