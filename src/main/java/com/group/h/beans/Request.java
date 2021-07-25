package com.group.h.beans;

import java.sql.Date;

public class Request extends Book{
	
	private int requestId;
	private Date dueDate, returnDate;
	private int issuedBy;
	private String issuedTo;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(int issuedBy) {
		this.issuedBy = issuedBy;
	}
	public String getIssuedTo() {
		return issuedTo;
	}
	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}
}
