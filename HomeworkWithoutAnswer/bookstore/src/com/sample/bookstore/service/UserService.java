package com.sample.bookstore.service;

import java.util.Arrays;

import com.sample.bookstore.vo.User;

public class UserService {

	private User[] db = new User[100];
	private int position = 0;
	private int userSequence = 10001;
	
	public UserService() {
		User u1 = new User(userSequence++, "홍길동", "010-1111-2345", 100, false);
		User u2 = new User(userSequence++, "김유신", "010-2345-7839", 100, false);
		User u3 = new User(userSequence++, "강감찬", "010-1856-8953", 100, false);
		User u4 = new User(userSequence++, "이순신", "010-4386-5256", 100, false);
		User u5 = new User(userSequence++, "류관순", "010-2678-3468", 100, false);
		
		db[position++] = u1;
		db[position++] = u2;
		db[position++] = u3;
		db[position++] = u4;
		db[position++] = u5;
	}
	
	public void insertUser(User user) {
		user.no = userSequence;
		
		db[position] = user;
		position++;
		userSequence++;		
	}
	
	public User findUserByNo(int userNo) {
		User result = null;
		for (int i=0; i<position; i++) {
			if (db[i].no == userNo) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	public User[] getAllUsers() {
		return Arrays.copyOfRange(db, 0, position);
	}
		
}
