package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmEntryMenuAction extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String menuid=req.getParameter("menuid");
		String menunamae=req.getParameter("menunamae");
		String kakaku=req.getParameter("kakaku");
		String genre=req.getParameter("genre");
		String kikan1=req.getParameter("kikan1");
		String kikan2=req.getParameter("kikan2");




		HttpSession session = req.getSession(true);


		session.setAttribute("menuid", menuid);
		session.setAttribute("menunamae", menunamae);
		session.setAttribute("kakaku", kakaku);
		session.setAttribute("genre", genre);
		session.setAttribute("kikan1", kikan1);
		session.setAttribute("kikan1", kikan2);




		RequestDispatcher rd = req.getRequestDispatcher("view/menu_confirm.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);

	}

}
