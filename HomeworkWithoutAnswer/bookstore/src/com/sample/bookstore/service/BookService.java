package com.sample.bookstore.service;

import java.util.ArrayList;
import java.util.Arrays;

import com.sample.bookstore.vo.Book;

public class BookService {

	private Book[] db = new Book[100];
	private int position = 0;
	private int bookSequence = 20001;
	
	public BookService() {
		Book b1 = new Book(bookSequence++, "자바의 정석", "남궁성", 35000, 10000);
		Book b2 = new Book(bookSequence++, "머신러닝 입문", "안동현", 25000, 10000);
		Book b3 = new Book(bookSequence++, "스프링 입문", "박재성", 32000, 10000);
		Book b4 = new Book(bookSequence++, "JSP 입문", "백기선", 24000, 10000);
		Book b5 = new Book(bookSequence++, "알고리즘 연습", "백준", 37000, 10000);
		
		db[position++] = b1;
		db[position++] = b2;
		db[position++] = b3;
		db[position++] = b4;
		db[position++] = b5;
	}
	
	public void insertBook(Book book) {
		book.no = bookSequence;
		db[position] = book;
		
		position++;
		bookSequence++;
	}
	
	public Book findBookByNo(int bookNo) {
		Book result = null;
		for (int i=0; i<position; i++) {
			if (db[i].no == bookNo) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	public Book[] findBookByTitle(String title) {
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i=0; i<position; i++) {
			if (db[i].title.contains(title)) {
				books.add(db[i]);
			}
		}
		Book[] result = new Book[books.size()];
		books.toArray(result);
		
		return result;
	}
	
	public Book[] getAllBooks() {
		return Arrays.copyOfRange(db, 0, position);
	}
	
}
