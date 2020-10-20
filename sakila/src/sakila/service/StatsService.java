package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sakila.commons.DBUtill;
import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	// 컨트롤은 여러 dao를 부를 수 없고 service는 여러 dao를 호출할 수 있다
	// 오늘의 방문자 수 DAO 메서드 호출 Stats + 총 방문자 수 dao 메서드 호출 int -> Map
	
	// 오늘 날짜를 구하는 메서드
	private Stats getToday() {
		Calendar today = Calendar.getInstance();	//오늘 날짜 구해서 가져오기
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");	// 날짜 출력하는 포맷
		String day = formater.format(today.getTime());	// Calendar -> String 형태로 변환
		Stats stats = new Stats();	// Stats 객체 생성
		stats.setDay(day);	// 오늘 날짜를 stats 데이터 객체에 담기
		System.out.println(day+"<-현재 날짜");
		return stats;
	}
	// 전체 방문자 수를 구하는 메서드
	
	// 오늘 날짜의 데이터가 있는지 여부를 조회한 쿼리 결과를 리턴하는 메서드(오늘 방문자수 조회)
	public Map<String,Object> getStats() {	// public Map<String,Object> getStats
		Map<String, Object> map = new HashMap<String, Object>();
		Stats returnStats;	// 오늘 방문자 수를 담을 변수
		Long totalCount;	// 전체 방문자 수를 담는 변수
		Connection conn = null;
		statsDao = new StatsDao();	// dao 객체 생성
		try {
			DBUtill dbUtill = new DBUtill();
			conn = dbUtill.getConn();
			Stats stats = this.getToday();	// 오늘 날짜 구하는 메서드 실행하여 stats 변수에 담기
			returnStats = statsDao.selectDay(conn, stats);	// 오늘 방문자 여부를 조회하여 returnStats에 결과 담기
			totalCount = statsDao.selectTotalCount(conn);	// 총 방문자 수를 조회하여 변수에 담기
			System.out.println(returnStats + "<- 오늘 방문자 수");
			System.out.println(totalCount + "<- 전체 방문자 수");
			map.put("returnStats", returnStats);
			map.put("totalCount", totalCount);
			conn.commit(); // 커밋이나 롤백은 데이터 변경이 있을 때 사용. select라 커밋이나 롤백은 필요없음.(트랜잭션 대비)
		}catch(Exception e) {	// 예외 발생시
			try {
				conn.rollback();	// 작업 취소
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			e.printStackTrace();
		}finally {
			try {
				conn.close();	// 커넥션 종료
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;	// 쿼리 결과 값을 담은 내용을 리턴
	}
	
	// 오늘 날짜로 등록된 데이터의 여부를 확인하여 삽입 또는 업데이트 실행하는 메서드(데이터 변경)
	public void countStats() {
		statsDao = new StatsDao();	// dao 객체 생성
		Connection conn = null;
		try {
			DBUtill dbUtill = new DBUtill();
			conn = dbUtill.getConn();
			Stats stats = this.getToday(); // 오늘 날짜를 가져와서 Stats 객체에 담음
			
			if(statsDao.selectDay(conn, stats) == null) {	// DB에 오늘 날짜로 등록된 데이터가 없다면
				statsDao.insertStats(conn, stats);	// 오늘 날짜로 데이터 삽입
			}else {
				statsDao.updatStats(conn, stats);	// 데이터가 존재한다면 카운트를 증가시키는 쿼리 호출
			}
			conn.commit();	// 커밋
		}catch(Exception e) {
			try {
				conn.rollback(); // 작업 취소
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
