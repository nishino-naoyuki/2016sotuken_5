/**
 * 認証処理
 */
package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.asojuku.managingeatout.bo.Cont_LoginBo;
import jp.ac.asojuku.managingeatout.dto.Cont_LogonInfoDTO;

/**
 *
 * @author nishino
 *
 */
public class Cont_authUser extends HttpServlet {

	/* (非 Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = "";
		String passWord = "";
		//String loginName = "";

		//login.jspで入力されたユーザー名、パスワードを取得する
		userId = req.getParameter("userid");
		passWord = req.getParameter("pass");

		//セッション確立再確認
		//HttpSession ssn = req.getSession(true);

		// ログイン処理を実行する
		Cont_LoginBo login = new Cont_LoginBo();


		Cont_LogonInfoDTO loginInfo = login.login(userId, passWord, req, resp);


		if( loginInfo != null ){
			//セッション内にユーザー名を取り込む
			//ssn.setAttribute("loginName",loginName );	//userName

			//トップ画面に遷移(TopAction.javaを実行させる)
			RequestDispatcher rd = req.getRequestDispatcher("/vdisho");
			//req.setAttribute(userName, userName);
			rd.forward(req, resp);
			return;
		}else{
			//ログイン失敗時、メッセージを表示する
			RequestDispatcher rd = req.getRequestDispatcher("/vdisli");
			rd.forward(req, resp);
			return;
		}
	}

}
