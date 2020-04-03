package com.sample.school.vo;

/**
 * 개설과정 신청정보를 저장하는 객체를 위한 클래스다.<br />
 * 신청학생번호, 개설과정 번호, 취소여부, 해당 과정의 성적을 저장한다.
 * @author JHTA
 *
 */
public class Registration {

	private int no;
	private int studentNo;
	private int courseNo;
	private boolean isCancel;
	private int score;
	
	// 기본 생성자를 정의하시오.
	public Registration() {}

	// 모든 멤버변수를 초기화하는 생성자를 정의하시오.
	public Registration(int studentNo, int courseNo, boolean isCancel, int score) {
		super();
		this.studentNo = studentNo;
		this.courseNo = courseNo;
		this.isCancel = isCancel;
		this.score = score;
	}

	
	// getter, setter 메소드를 정의하시오
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public boolean isCancel() {
		return isCancel;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
		
	
}
