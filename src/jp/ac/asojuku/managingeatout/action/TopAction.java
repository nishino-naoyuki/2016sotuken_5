package jp.ac.asojuku.gurunabiapi.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopAction extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// top.jspを表示
		RequestDispatcher rd = req.getRequestDispatcher("view/top.jsp");
		rd.forward(req, resp);
	}
}
