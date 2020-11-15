package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.DepositeDAO;
import com.nit.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	 private WithdrawDAO withdrawDAO;
	@Autowired 
	private DepositeDAO depositeDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="jtaTxMgmr")
	public String transferMoney(long srcAccno, long dstAccno, double money) {
		
	       if(withdrawDAO.withdraw(srcAccno, money)==0 || depositeDAO.deposite(dstAccno, money)==0)
	    	   throw new IllegalArgumentException("Problem in Transfering  money");
	       else
	    	   return "Money ("+money+") Transfered from "+srcAccno+" to "+dstAccno;
	}

}
