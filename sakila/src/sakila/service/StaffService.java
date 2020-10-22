package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.commons.DBUtill;
import sakila.dao.StaffDao;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao;	// dao를 사용하기 위한 dao 객체변수
	// 로그인을 위한 직원 정보를 가져오기
	public Staff getSaffByKey(Staff staff) {	// id,pw 값 넘어옴
		Staff returnStaff = null;	// dao의 반환값(staff_id, username)을 담을 변수 생성
		Connection conn = null;	// 커넥션 변수 생성
		staffDao = new StaffDao();	// 쿼리 조회 결과을 가져오기 위한 staffDao 객체 생성
		try {
			DBUtill utill = new DBUtill();	// DBUtill(DB 연결 정보를 가진)객체 생성
			conn = utill.getConn();	// conn에 연결 정보 담기
			
			System.out.println(conn + "<= 커넥션 연결");	// 디버깅
			returnStaff = staffDao.selectStaffByKey(conn, staff);	// id,pw를 이용한 스태프 조회 결과 담기
			System.out.println("dao에서 가져온 스태프정보: "+returnStaff); // 디버깅
			conn.commit();	// 커밋
		} catch (Exception e1) {
			try {
				conn.rollback(); // 롤백
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			e1.printStackTrace();
		} finally {
			try {
				conn.close();	// 커넥션 닫기
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
		return returnStaff;
	}
}
