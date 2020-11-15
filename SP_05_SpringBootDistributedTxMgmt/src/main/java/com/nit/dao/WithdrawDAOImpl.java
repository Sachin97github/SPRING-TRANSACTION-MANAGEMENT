package com.nit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithdrawDAOImpl implements WithdrawDAO {
 
	private static final String WITHDRAW_QUERY="UPDATE BANKORACLE SET BALANCE = BALANCE-? WHERE ACCNO=?";
	
	@Autowired
	@Qualifier("oracleJt")
	private JdbcTemplate jt;
	
	@Override
	public int withdraw(long accno, double money) {
		return jt.update(WITHDRAW_QUERY,money,accno);
	}

}
