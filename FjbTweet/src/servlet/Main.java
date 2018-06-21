package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tweet;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----メインページに飛びます-----");
		// ①ServletContext インスタンスの取得
		// ServletContext application = this.getServletContext();

		ServletContext app = getServletContext();

		ArrayList<Tweet> tweetArray = (ArrayList<Tweet>) app.getAttribute("TWEET");

		if (tweetArray == null) {
			System.out.println("tweetはありません");
			tweetArray = new ArrayList<Tweet>();
			Tweet tw = new Tweet("名前", "ツイート内容");
			tweetArray.add(tw);

			System.out.println(tweetArray.size());

		}

		app.setAttribute("TWEET", tweetArray);
		ServletContext err = getServletContext();
		String message = "つぶやきがあります";
		err.setAttribute("ERR", message);

		System.out.println("----更新----");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main.jsp");// 送り先を変数に格納
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("-----Main:Post-----");
		HttpSession ses = request.getSession();
		ServletContext application = getServletContext();
		ArrayList<Tweet> tweet = (ArrayList<Tweet>) application.getAttribute("TWEET");

		String come = request.getParameter("come");
		System.out.println(come);
		
		
		if(come.equals("") ){
			//エラーメッセージ
			System.out.println("コメントが入力されていません");
			ServletContext err = getServletContext();
			String message = "つぶやきが空です";
			err.setAttribute("ERR", message);
		}else{
			System.out.println("コメントが入力されています");
			ServletContext err = getServletContext();
			String message = "つぶやきがあります";
			err.setAttribute("ERR", message);
			User user = (User) ses.getAttribute("USER");
			// tweetインスタンスに”名前”と”コメント”を追加。
			Tweet tw = new Tweet(user.getUserName(), come);
			/* TweetインスタンスをArrayリストに追加 */
			System.out.println("-----つぶやきを追加-------");
			tweet.add(tw);	
		}
		
		/* アプリケーションスコープにArrayリストを追加 */
		application.setAttribute("TWEET", tweet);

		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main.jsp");// 送り先を変数に格納
		rd.forward(request, response);
	}

}
