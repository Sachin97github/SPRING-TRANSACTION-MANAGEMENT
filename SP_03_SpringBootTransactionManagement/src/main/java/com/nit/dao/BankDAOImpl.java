package com.nit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BankDAOImpl implements BankDAO {

	@Autowired
	private JdbcTemplate jt;
	
	private static final String WITHDRAW_QUERY="UPDATE BANKLIST SET BALANCE=BALANCE - ? WHERE ACCNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKLIST SET BALANCE=BALANCE + ? WHERE ACCNO=?";
	
	@Override
	public int withdraw(long acno, double money) {
	  return jt.update(WITHDRAW_QUERY,money,acno);
	}

	@Override
	public int deposite(long acno, double money) {
		return jt.update(DEPOSITE_QUERY, money,acno);
	}

}
