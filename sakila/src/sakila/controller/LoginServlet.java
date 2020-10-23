package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;

@WebServlet({"/","/LoginServlet"})	// 로그인 요청을 처리하는 서블릿, "/" 어떤 요청도 로그인으로
public class LoginServlet extends HttpServlet{

	// 접속자 출력을 위한 StatsService 변수생성.
	private StatsService statsService;
	private StaffService staffService;
	
	// 로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	// 세션 가지고 오기
		if(session.getAttribute("loginStaff") != null) {	// 로그인 값이 있다면
			response.sendRedirect(request.getContentType()+"/auth/IndexServlet");	// 인덱스페이지로 이동(로그인이 되어 있는 페이지는 auth로 시작)
			return;
		}
		statsService = new StatsService();	// statsService 객체 생성
		Map<String, Object> map = statsService.getStats();	// 해당 메서드의 결과 값을 map 변수에 담기
		Stats stats = (Stats)map.get("returnStats");	// map에 있는 오늘 방문자 수 가져오기
		Long totalCount = (Long)map.get("totalCount");
		System.out.println(stats + "<== 서블릿으로 받은 오늘 방문자");
		System.out.println(totalCount + "<== 서블릿으로 받은 전체 방문자");
		request.setAttribute("stats", stats);	// 해당 데이터들을 request로 보내기
		request.setAttribute("totalCount", totalCount);	// 해당 데이터들을 request로 보내기
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");	// request에 stats, totalCount 정보를 담아서 보냄
		dispatcher.forward(request, response); 	// 로그아웃이면 로그인 폼으로 이동.
	}
	// 로그인 액션으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staffService = new StaffService();
		Staff staff = new Staff();	// Staff 타입을 사용하기 위한 객체 생성
		// request로 넘어온 값 받기
		staff.setEmail(request.getParameter("id"));
		System.out.println("서블릿에 넘어온 파라메터 id : "+request.getParameter("id")); // 디버깅
		staff.setPassword(request.getParameter("pw"));
		System.out.println("서블릿에 넘어온 파라메터 pw : "+request.getParameter("pw")); // 디버깅
		Staff returnStaff = staffService.getSaffByKey(staff);	// id,pw 가진 staff를 서비스로 보내어 반환값(staff_id, username)받기
		System.out.println("쿼리 조회한 스태프 정보 : "+returnStaff); // 디버깅
		// 세션 가져오기
		HttpSession session = request.getSession();	
		System.out.println("받은 세션: "+ session);
		if(returnStaff != null) {
			session.setAttribute("loginStaff", returnStaff); // 스태프 정보(staff_id, username) 세션에 값 담기. 어트리뷰트에는 map형태로 들어감
			// 스태프 결과 값이 있다면 IndexServlet으로 이동
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		System.out.println("로그인 실패!");
		// 스태프 정보가 없으면 LoginServlet 으로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/LoginServlet");	
	}
}
