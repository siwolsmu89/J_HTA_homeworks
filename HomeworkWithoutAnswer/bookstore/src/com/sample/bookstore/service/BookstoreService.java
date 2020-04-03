package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookstoreService {

	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
	
	public void retrieveUserInfo(int userNo) {
		User user = userService.findUserByNo(userNo);
		if (user == null) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("========= 회원정보 =========");
		System.out.println("회원번호: " + user.no);
		System.out.println("회원이름: " + user.name);
		System.out.println("전화번호: " + user.tel);
		System.out.println("포 인 트 : " + user.point);
		System.out.println("탈퇴여부: " + user.isDisabled);
	}
	
	public void modifyUserInfo(User user) {
		User savedUser = userService.findUserByNo(user.no);
		if (savedUser == null) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		
		savedUser.name = user.name;
		savedUser.tel = user.tel;
	}
	
	public void disabledUser(int userNo) {
		User user = userService.findUserByNo(userNo);
		if (user == null) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		
		user.isDisabled = true;
		this.returnBooksByUserNo(userNo);
	}
	
	public void retrieveAllUsers() {
		User[] users = userService.getAllUsers();
		if (users.length == 0) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("======================================");
		System.out.println("회원번호	회원이름	전화번호	포인트 	탈퇴여부");
		System.out.println("======================================");
		for (User user : users) {
			System.out.print(user.no + "\t");
			System.out.print(user.name + "\t");
			System.out.print(user.tel + "\t");
			System.out.print(user.point + "\t");
			System.out.println(user.isDisabled);
		}
		System.out.println("======================================");
	}
	
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 100;
		
		bookService.insertBook(book);
	}
	
	public void searchBooks(String title) {
		Book[] books = bookService.findBookByTitle(title);
		if (books.length == 0) {
			System.out.println("검색된 책정보가 없습니다.");
			return;
		}
		
		System.out.println("===================================");
		System.out.println("도서번호	책제목	책저자	도서가격	재고");
		System.out.println("===================================");
		
		for (Book book : books) {
			System.out.print(book.no + "\t");
			System.out.print(book.title + "\t");
			System.out.print(book.writer + "\t");
			System.out.print(book.price + "\t");
			System.out.println(book.stock);
		}
		System.out.println("===================================");
	} 
	
	public void modifyBook(Book book) {
		Book savedBook = bookService.findBookByNo(book.no);
		if (savedBook == null) {
			System.out.println("책정보가 존재하지 않습니다.");
			return;
		}
		
		savedBook.title = book.title;
		savedBook.writer = book.writer;
		savedBook.price = book.price;
	}
	
	public void retrieveAllBooks() {
		Book[] books = bookService.getAllBooks();
		if (books.length ==  0) {
			System.out.println("책정보가 존재하지 않습니다.");
			return;
		}
	}
	
	public void rentBook(int userNo, int bookNo) {
		User user = userService.findUserByNo(userNo);
		Book book = bookService.findBookByNo(bookNo);
		
		if (user == null) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		if (user.isDisabled) {
			System.out.println("탈퇴처리된 회원입니다.");
			return;
		}
		if (book == null) {
			System.out.println("책정보가 존재하지 않습니다.");
			return;
		}
		
		Rental rental = new Rental();
		rental.userNo = userNo;
		rental.bookNo = bookNo;
		rental.isRent = true;
		
		rentalService.insertRental(rental);
		book.stock--;
	}
	
	public void returnBook(int rentalNo) {
		Rental rental = rentalService.findRentalByNo(rentalNo);
		if (rental == null) {
			System.out.println("대여정보가 존재하지 않습니다.");
			return;
		}
		
		if (!rental.isRent) {
			System.out.println("이미 반납처리된 도서입니다.");
			return;
		}
		
		User user = userService.findUserByNo(rental.userNo);
		Book book = bookService.findBookByNo(rental.bookNo);
		
		rental.isRent = false;
		user.point += (int) (book.price * 0.01);
		book.stock++;
	}
	
	public void returnBooksByUserNo(int userNo) {
		User user = userService.findUserByNo(userNo);
		if (user == null) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		
		Rental[] rentals = rentalService.getRentalsByUserNo(userNo);
		for (Rental rental : rentals) {
			if (rental.isRent) {
				Book book = bookService.findBookByNo(rental.bookNo);
				
				rental.isRent = false;
				user.point += (int) (book.price * 0.01);
				book.stock++;				
			}
		}
	}

	public void retrieveAllRentals() {
		Rental[] rentals = rentalService.getAllRentals();
		this.printRentals(rentals);
	}

	public void retrieveRentalsByUserNo(int userNo) {
		Rental[] rentals = rentalService.getRentalsByUserNo(userNo);
		this.printRentals(rentals);
	}

	public void retrieveRentalsByBookNo(int bookNo) {
		Rental[] rentals = rentalService.getRentalsByBookNo(bookNo);
		this.printRentals(rentals);
	}

	private void printRentals(Rental[] rentals) {
		if (rentals.length == 0) {
			System.out.println("대여정보가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("==============================================");
		System.out.println("대여번호	도서번호	책제목	회원번호	회원이름	대여상태");
		System.out.println("==============================================");
		
		for (Rental rental : rentals) {
			User user = userService.findUserByNo(rental.userNo);
			Book book = bookService.findBookByNo(rental.bookNo);

			System.out.print(rental.no + "\t");
			System.out.print(book.no + "\t");
			System.out.print(book.title + "\t");
			System.out.print(user.no + "\t");
			System.out.print(user.name + "\t");
			System.out.println(rental.isRent);
		}
		System.out.println("==============================================");
	}
	
}
