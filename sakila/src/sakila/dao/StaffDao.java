package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception{ // id,pw를 Staff로 묶어서 받음, 	Exception=>모든 예외를 던짐
		Staff returnStaff = null;	// Staff 타입으로 리턴할 변수 생성
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);	// select 결과  stmt에 담기
		stmt.setString(1, staff.getEmail());	// 첫 번째 파라메터에 스태프번호 설정
		System.out.println(staff.getEmail() + "==> 스태프 DAO 받은 이메일");
		stmt.setString(2, staff.getPassword()); // 두 번째 파라메터에 비밀번호 설정
		ResultSet rs = stmt.executeQuery();	// 업데이트 등에 쓰이는 것이 롤백
		if(rs.next()) {	// 결과 값이 없으면 null
			returnStaff = new Staff();	// 데이터를 담기 위해 Staff 객체 생성
			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setUserName(rs.getString("username"));
			System.out.println(rs.getString("email") + " => 쿼리 조회한 email");
			System.out.println(rs.getString("username") + " => 쿼리 조회한 username");
		}
		return returnStaff;	// Staff 정보 리턴
	}
}
