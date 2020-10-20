package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {	// 해당 리스너는 톰캣 실행시 마리아DB 드라이브 로딩 여부를 검사 
    public DBListener() {}

    public void contextDestroyed(ServletContextEvent sce)  {}

    public void contextInitialized(ServletContextEvent sce)  {	// 웹 어플리케이션 초기화시에 실행
    	System.out.println("DBListener.contextInitialized() 실행"); // 디버깅
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");	// DB 드라이브 로드
    		System.out.println("mariadb 드라이브로딩 성공");
    	}catch(ClassNotFoundException e) {
    		System.out.println("Class.forName()실행 실패");
    		e.printStackTrace();
    	}
    }
	
}
