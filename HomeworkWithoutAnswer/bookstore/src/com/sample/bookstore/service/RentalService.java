package com.sample.bookstore.service;

import java.util.Arrays;

import com.sample.bookstore.vo.Rental;

public class RentalService {

	private Rental[] db = new Rental[100];
	private int position = 0;
	private int rentalSequence = 50001;
	
	public void insertRental(Rental rental) {
		rental.no = rentalSequence;
		db[position] = rental;
		
		position++;
		rentalSequence++;
	}
	
	public Rental findRentalByNo(int rentalNo) {
		Rental result = null;
		for (int i=0; i<position; i++) {
			if (db[i].no == rentalNo) {
				result = db[i];
				break;
			}
		}
		return result;
	}
	
	public Rental[] getAllRentals() {
		return Arrays.copyOfRange(db, 0, position);
	}

	public Rental[] getRentalsByUserNo(int userNo) {
		Rental[] rentals = new Rental[position];
		
		int count = 0;
		for (int i=0; i<position; i++) {
			if (db[i].userNo == userNo) {
				rentals[count] = db[i];
				count++;
			}
		}
		
		return Arrays.copyOfRange(rentals, 0, count);
	}

	public Rental[] getRentalsByBookNo(int bookNo) {
		Rental[] rentals = new Rental[position];
		
		int count = 0;
		for (int i=0; i<position; i++) {
			if (db[i].bookNo == bookNo) {
				rentals[count] = db[i];
				count++;
			}
		}
		
		return Arrays.copyOfRange(rentals, 0, count);
	}
	
}
