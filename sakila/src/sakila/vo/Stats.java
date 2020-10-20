package sakila.vo;

public class Stats {	// 날짜와 카운트 데이터를 가지는 객체
	private String day;	// 날짜를 저장
	private long cnt;	// 카운터를 저장
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public long getCnt() {
		return cnt;
	}
	public void setCnt(long cnt) {
		this.cnt = cnt;
	}

}
