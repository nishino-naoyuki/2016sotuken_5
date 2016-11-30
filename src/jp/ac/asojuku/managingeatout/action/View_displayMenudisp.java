package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * メニュー追加確認画面_画面表示セクション
 */
public class View_displayMenudisp extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession ssn = req.getSession(true);

		//入力画面からのデータ取り入れ処理
		/*String restId = req.getParameter("");
		String addMenu = req.getParameter("");
		String addPrice = req.getParameter("");
		String addCategory = req.getParameter("");
		String startDate = req.getParameter("");
		String endDate = req.getParameter("");*/
		String restId = "00000001";
		String addMenu = "もつ鍋";
		String addPrice = "850";
		String addCategory = "01";
		String startDate = null;
		String endDate = null;

		//店舗名照合
		/*Cont_searchRestname csrn = new Cont_searchRestname();
		String restName = (String)csrn.searchRN(restId,req,resp);*/


		//ssn.setAttribute("RN", restName);
		ssn.setAttribute("RN", restId);
		ssn.setAttribute("AM", addMenu);
		ssn.setAttribute("AP", addPrice);
		ssn.setAttribute("AC", addCategory);
		ssn.setAttribute("SD", startDate);
		ssn.setAttribute("ED", endDate);

		RequestDispatcher rd = req.getRequestDispatcher("view/AddMenuConfirm.jsp");
		// TODO 自動生成されたメソッド・スタブ
		rd.forward(req, resp);
	}
}
