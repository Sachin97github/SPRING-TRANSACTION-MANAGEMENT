package com.nit.dao;

public interface BankDao {
 
	public int deposite(long accno,double money);
	public int withdraw(long accno,double money)	;
	 
}
