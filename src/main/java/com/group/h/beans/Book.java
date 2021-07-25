package com.group.h.beans;

public class Book {
	private String Author, Title;
	private int bookId;
	private boolean availabe;
	private float price;
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isAvailabe() {
		return availabe;
	}
	public void setAvailabe(boolean availabe) {
		this.availabe = availabe;
	}
}
