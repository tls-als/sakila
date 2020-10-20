package sakila.query;

public class StatsQuery {
	public static final String SELECT_DAY = "SELECT * FROM stats WHERE day=?";
	public static final String INSERT_STATS = "INSERT INTO stats(day, count) VALUES(?,1)";
	public static final String UPDATE_STATS = "UPDATE STATS SET count=count+1 where day=?";
}
