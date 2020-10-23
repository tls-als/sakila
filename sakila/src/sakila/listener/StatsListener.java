package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {	// 처음 시작하면 구동(세션이 생길때)

    public StatsListener() {}
    private StatsService statsService;
    public void sessionCreated(HttpSessionEvent se)  {
    	System.out.println("StatsListener 실행");
         if(se.getSession().isNew()) {	// 세션 이벤트가 발생하면(새로 생성하면) 세션을 받아서 isNew()로 톰캣에서 처음 발생한 세션인지 다시 살아난 세션인지 검사
        	 statsService = new StatsService();
        	 statsService.countStats();
         }
    }
    public void sessionDestroyed(HttpSessionEvent se)  {}	
}
