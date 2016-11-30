package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmEntrymenberAction extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userid=req.getParameter("userid");
		String shimei=req.getParameter("shimei");
		String birthday=req.getParameter("birthday");
		String seibetsu=req.getParameter("seibetsu");
		String mailadress=req.getParameter("mailadress");
		String adress=req.getParameter("adress");
		String password=req.getParameter("password");




		HttpSession session = req.getSession(true);


		session.setAttribute("userid", userid);
		session.setAttribute("shimei", shimei);
		session.setAttribute("birthday", birthday);
		session.setAttribute("seibetsu", seibetsu);
		session.setAttribute("mailadress", mailadress);
		session.setAttribute("adress", adress);
		session.setAttribute("password", password);




		RequestDispatcher rd = req.getRequestDispatcher("view/member_confirm.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);

	}

}
