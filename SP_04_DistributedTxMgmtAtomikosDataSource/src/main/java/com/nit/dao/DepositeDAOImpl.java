package com.nit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements DepositeDAO {
 
	private static final String DEPOSITE_QUERY="UPDATE BANKMYSQL SET BALANCE = BALANCE+? WHERE ACCNO=?";
	
	@Autowired
	@Qualifier("mysqlJt")
	private JdbcTemplate jt;
	
	@Override
	public int deposite(long accno, double money) {
		return jt.update(DEPOSITE_QUERY,money,accno);
	}

}
