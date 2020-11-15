package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.BankDao;

@Service("bankService")
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao dao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String transferMoney(long srcAcno, long destAcno, double money) {
	     int count,count2;
	     count=dao.withdraw(srcAcno, money);
	     count2= dao.deposite(destAcno, money);
	     System.out.println(count +" :: "+count2 );
		 if(count==0||count2==0)
		    throw new RuntimeException("Problem in Money Transfer");
		else
		    return money+" Transfered from "+srcAcno+" to "+destAcno;
		
	}

}
