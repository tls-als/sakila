package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// 전체 방문자 수를 가져오는 쿼리
	public Long selectTotalCount(Connection conn) throws Exception {
		Long total = null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.TOTAL_COUNT);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			total = rs.getLong("SUM(cnt)");
			System.out.println(total + "<-전체 방문자수");
		}
		return total;
	}
	
	// 오늘 날짜로 등록된 데이터가 있는지 없는지 쿼리 조회.(오늘 날짜의 카운트 값을 리턴)
	public Stats selectDay(Connection conn, Stats stats) throws Exception{
		Stats returnStats = null;	// 카운트 리턴 값을 담을 변수 생성
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);	// 오늘 날짜에 따른 데이터를 조회하는 쿼리 stmt에 담기
		stmt.setString(1, stats.getDay());
		ResultSet rs = stmt.executeQuery();	// 쿼리 실행
		System.out.println(stmt + "<- select 실행");
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCnt(rs.getLong("cnt"));
		}
		System.out.println(returnStats + "<- select 쿼리 리턴");
		return returnStats;
	}
	// 오늘 날짜로 등록된 데이터가 없으면 INSERT
	public void insertStats(Connection conn, Stats stats) throws Exception{
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
		System.out.println(stmt + "<- insert 실행");
	}
	// 오늘 날짜로 등록된 데이터 존재한다면 카운트 UPDATE
	public void updatStats(Connection conn, Stats stats) throws Exception{
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
		System.out.println(stmt + "<- update 실행");
	}
}
