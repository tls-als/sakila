package sakila.dao;

import java.sql.Connection;
import sakila.vo.Staff;

public class StaffDao {
	
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception{ // id,pw를 Staff로 묶어서 받음, 	Exception=>모든 예외를 던짐
		Staff returnStaff = null;	// Staff 타입으로 리턴할 변수 생성
		
		return returnStaff;	// Staff 정보 리턴
	}
}
