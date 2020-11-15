package com.nit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDao")
public class BankDaoImpl implements BankDao {

	private static String WITHDRAW_QUERY = "UPDATE BANK SET BALANCE=BALANCE - ? WHERE ACCNO=?";
	private static String DEPOSITE_QUERY = "UPDATE BANK SET BALANCE=BALANCE + ?  WHERE ACCNO=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int deposite(long accno, double money) {
           return jt.update(DEPOSITE_QUERY,money,accno);
     }

	@Override
	public int withdraw(long accno, double money) {
	  return jt.update(WITHDRAW_QUERY,money,accno);
	}

}
