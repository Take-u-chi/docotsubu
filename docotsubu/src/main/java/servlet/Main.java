package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//つぶやきリストをアプリケーションスコープから取得
	ServletContext application = this.getServletContext();
	List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
//取得できなかった時、リストを新規作成してスコープに保存
	if(mutterList == null) {
		mutterList = new ArrayList<>();
		application.setAttribute("mutterList", mutterList);		
	}
//ログイン状態の確認（セッションスコープからユーザー情報を取得）
	HttpSession session = request.getSession();
	User loginUser = (User)session.getAttribute("loginUser");
	
	if(loginUser == null) {
		response.sendRedirect("/docotsubu/");
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
	
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
