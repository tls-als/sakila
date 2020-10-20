package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	public void countStats() {
		statsDao = new StatsDao();
		final String URL = "";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			//
			Calendar today = Calendar.getInstance();	//오늘 날짜 구하기
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			String day = formater.format(today);	// 오늘 날짜를 해당 포맷 형태로 변환
			Stats stats = new Stats();
			stats.setDay(day);
			
			if(statsDao.selectDay(conn, stats)) {
				statsDao.updatStats(conn);
			}else {
				statsDao.insertStats(conn, stats);
			}
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback(); //트랜잭션을 사용할 수도 있으니깐
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
