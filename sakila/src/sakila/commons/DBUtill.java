package sakila.commons;

import java.sql.*;

// DB 접속을 위한 코드
public class DBUtill {
	public Connection getConn() throws Exception {
		final String URL = "jdbc:mariadb://localhost:3306/sakila";	// 접속하는 데이터베이스 경로
		final String USER = "root";	// db사용자  id
		final String PASSWORD = "java1004";	// db사용자 pw
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		conn.setAutoCommit(false);
		return conn;
	}
}
