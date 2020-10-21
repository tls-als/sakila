package sakila.service;

import sakila.dao.StaffDao;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao;	// dao를 사용하기 위한 dao 객체변수
	// 로그인을 위한 직원 정보를 가져오기
	public Staff getSaffByKey(Staff staff) {
		Staff returnStaff = null;
		return returnStaff;
	}
}
