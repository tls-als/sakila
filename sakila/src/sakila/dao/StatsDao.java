package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	// 오늘 날짜가 있는지 없는지 확인. 날짜가 있으면 TRUE
	public boolean selectDay(Connection conn, Stats stats) throws Exception{
		boolean result = false;
			/*
			if(rs.next()) {
				return true; //업데이트가 실행
			}
			*/
			return result;	// 인서트 실행
	}
	//
	public void insertStats(Connection conn, Stats stats) throws Exception{
		
	}
	//
	public void updatStats(Connection conn) throws Exception{
		
	}
}
