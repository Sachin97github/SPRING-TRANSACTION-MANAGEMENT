package com.nit.dao;

public interface BankDAO {
	
	public int withdraw(long acno,double money);
	public int deposite(long acno,double money);

}
