package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.vo.Staff;

@WebServlet("/auth/IndexServlet")
public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 성공!!!");
		// 필터에서 검사후
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);	// 인덱스로 포워딩
	}
}
