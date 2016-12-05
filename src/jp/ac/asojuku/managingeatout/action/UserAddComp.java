package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.asojuku.managingeatout.bo.UserAddBo;

public class UserAddComp extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		UserAddBo UAB = new UserAddBo();

		String us_mail = (String)session.getAttribute("mail");
		String us_pass = (String)session.getAttribute("pass");
		String us_id = (String)session.getAttribute("userid");
		String names = (String)session.getAttribute("names");
		String namem = (String)session.getAttribute("namem");
		String perf = (String)session.getAttribute("pref");
		String addr = (String)session.getAttribute("addr");
		String birthy = (String)session.getAttribute("birthy");
		String birthm = (String)session.getAttribute("birthm");
		String birthd = (String)session.getAttribute("birthd");
		String us_gender = (String)session.getAttribute("sex");

		String us_name = names + namem;
		String us_address = perf + addr;
		String us_birth = birthy + "-"+  birthm + "-" + birthd;

		try {
			UAB.insertMemberInfo(us_id,us_name,us_birth,us_gender,us_mail,us_address,us_pass);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("登録NGs");
			RequestDispatcher rd = req.getRequestDispatcher("view/user_add.jsp");
			rd.forward(req, resp);
			return;
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("登録NGn");
			RequestDispatcher rd = req.getRequestDispatcher("view/user_add.jsp");
			rd.forward(req, resp);
			return;
		}

		RequestDispatcher rd = req.getRequestDispatcher("view/user_comp.jsp");
		rd.forward(req, resp);
	}
}


