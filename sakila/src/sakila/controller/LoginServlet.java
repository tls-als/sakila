package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")	// 로그인 요청을 처리하는 서블릿
public class LoginServlet extends HttpServlet {
	// 로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	// 세션 가지고 오기
		if(session.getAttribute("loginStaff") != null) {	// 로그인 값이 있다면
			response.sendRedirect(request.getContentType() + "/auth/IndexServlet");	// 인덱스페이지로 이동(로그인이 되어 있는 페이지는 auth로 시작)
			return;
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	// 로그아웃이면 로그인 폼으로 이동.
	}
	// 로그인 액션으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
