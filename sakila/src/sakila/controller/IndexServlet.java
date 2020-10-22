package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.vo.Staff;

@SuppressWarnings("serial")
@WebServlet("/auth/IndexServlet")
public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("로그인 성공!!!");
		if(session.getAttribute("loginStaff") != null) {	// 스태프 등록 정보가 있다면
			request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);	// 인덱스로 포워딩
			return;
		}
		response.sendRedirect(request.getContextPath()+"/LoginServlet");	// 로그인 정보가 없다면 LoginServlet
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
