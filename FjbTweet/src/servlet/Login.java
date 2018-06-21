package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*値の受け取り*/
		String userName = request.getParameter("userName");System.out.println("ユーザ名：" + userName);
		String password = request.getParameter("pass");System.out.println("パスワード："+password);
		HttpSession ses = request.getSession();
		/*パスワードのチェック*/
		if(password.equals("98765") | password.equals("Fjb51")){
			/*ログイン成功時の動き*/System.out.println("ログイン成功");
			User user = new User(userName,password);
			ses.setAttribute("USER", user);
		}else{
			/*ログイン失敗時の動き*/System.out.println("ログイン失敗");
			ses.removeAttribute("USER");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/loginResult.jsp");//送り先を変数に格納
		rd.forward(request, response);
		System.out.println("----Forward:loginResultにとぶ----");
	}

}
