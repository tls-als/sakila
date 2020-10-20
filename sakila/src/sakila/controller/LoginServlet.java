package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StatsService;
import sakila.vo.Stats;

@WebServlet("/LoginServlet")	// 로그인 요청을 처리하는 서블릿
public class LoginServlet extends HttpServlet {
	// 접속자 출력을 위한 StatsService 변수생성.
	private StatsService statsService;
	
	// 로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	// 세션 가지고 오기
		if(session.getAttribute("loginStaff") != null) {	// 로그인 값이 있다면
			response.sendRedirect(request.getContentType() + "/auth/IndexServlet");	// 인덱스페이지로 이동(로그인이 되어 있는 페이지는 auth로 시작)
			return;
		}
		statsService = new StatsService();	// statsService 객체 생성
		Map<String, Object> map = statsService.getStats();	// 해당 메서드의 결과 값을 map 변수에 담기
		Stats stats = (Stats)map.get("returnStats");	// map에 있는 오늘 방문자 수 가져오기
		Long totalCount = (Long)map.get("totalCount");
		request.setAttribute("stats", stats);	// 해당 데이터들을 request로 보내기
		request.setAttribute("totalCount", totalCount);	// 해당 데이터들을 request로 보내기
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	// 로그아웃이면 로그인 폼으로 이동.
	}
	// 로그인 액션으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
