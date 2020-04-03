package com.sample.bookstore.vo;

public class User {

	public int no;
	public String name;
	public String tel;
	public int point;
	public boolean isDisabled;		// false:사용가능 고객, true:탈퇴처리된 고객
	
	public User() {}
	
	public User(int no, String name, String tel, int point, boolean isDisabled) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.point = point;
		this.isDisabled = isDisabled;
	}
	
	
}
