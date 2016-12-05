package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.asojuku.managingeatout.check.UserAddCheck;
import jp.ac.asojuku.managingeatout.dto.UserCheckStock;

public class UserAddCheckAction extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserCheckStock UCS = new UserCheckStock();
		UserAddCheck UAC = new UserAddCheck();

		UCS.setMail(req.getParameter("mail"));
		UCS.setRe_mail(req.getParameter("re_mail"));
		UCS.setUseid(req.getParameter("use_ID"));
		UCS.setPass(req.getParameter("passward"));
		UCS.setRe_pass(req.getParameter("re_passward"));
		UCS.setName_sei(req.getParameter("name_sei"));
		UCS.setName_mei(req.getParameter("name_mei"));
		UCS.setFuri_sei(req.getParameter("furi_sei"));
		UCS.setFuri_mei(req.getParameter("furi_mei"));
		UCS.setPref(req.getParameter("pref"));
		UCS.setAddr(req.getParameter("address"));
		UCS.setBirth_y(req.getParameter("birth_y"));
		UCS.setBirth_m(req.getParameter("birth_m"));
		UCS.setBirth_d(req.getParameter("birth_d"));
		UCS.setSex(req.getParameter("sex"));

		List<String> list = UAC.user(UCS);

		if(list.size() == 0){
			req.setAttribute("mail",req.getParameter("mail") );
			req.setAttribute("pass",req.getParameter("passward") );
			req.setAttribute("userid",req.getParameter("use_ID") );
			req.setAttribute("names",req.getParameter("name_sei") );
			req.setAttribute("namem",req.getParameter("name_mei") );
			req.setAttribute("furis",req.getParameter("furi_sei") );
			req.setAttribute("furim",req.getParameter("furi_mei") );
			req.setAttribute("pref",req.getParameter("pref") );
			req.setAttribute("addr",req.getParameter("address") );
			req.setAttribute("birthy",req.getParameter("birth_y") );
			req.setAttribute("birthm",req.getParameter("birth_m") );
			req.setAttribute("birthd",req.getParameter("birth_d") );
			req.setAttribute("sex",req.getParameter("sex") );

			RequestDispatcher rd = req.getRequestDispatcher("view/user_check.jsp");
			rd.forward(req, resp);
			return;
		}else{
			req.setAttribute("error_msg","入力が正しくありません。再度入力してください" );

			req.setAttribute("LIST", list);

			RequestDispatcher rd = req.getRequestDispatcher("view/user_add.jsp");
			rd.forward(req, resp);
			return;
		}


	}
}
