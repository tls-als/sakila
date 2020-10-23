package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/auth/*")	// auth로 시작되는 모든 요청을 받음. 로그인 세션을 확인하는 필터(로그아웃 상태는 리턴) -> 필터는 AOP 기법
public class LoginFilter implements Filter {

    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	// 서블릿은 웹 요청만 처리하기에 여러 프로토콜로 들어오는 요청을 처리위해 자식타입으로 형변환하는 것(다형성)
		System.out.println("LoginFilter 실행 : session 검사");	// 디버깅
		HttpSession session = ((HttpServletRequest)request).getSession();	// 자식타입인 HttpServletRequest로 형변환. ServletRequest > HttpServletRequest의 부모 타입.
		if(session.getAttribute("loginStaff") == null) {	// 로그아웃 상태라면
			System.out.println("==============세션 값 없음");
			((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet");	// request.getServletContext().getContextPath()이 원칙.
			return;	// 로그인 안 되어 있으면 종료
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
