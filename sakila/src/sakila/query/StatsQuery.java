package sakila.query;

public class StatsQuery {	// 오늘 방문자를 조회, 방문자 카운트 등을 수행
	public static final String SELECT_DAY = "SELECT * FROM stats WHERE day=?";	// 오늘 날짜의 방문자 count하기
	public static final String TOTAL_COUNT = "SELECT SUM(cnt) FROM stats";	// 전체 방문자 수 출력
	public static final String INSERT_STATS = "INSERT INTO stats(day, cnt) VALUES(?,1)";	// 오늘 날짜로 등록된 데이터가 없으면 DB에 삽입
	public static final String UPDATE_STATS = "UPDATE STATS SET cnt=cnt+1 where day=?";	// 오늘 날짜가 있으면 카운트 +1
}
