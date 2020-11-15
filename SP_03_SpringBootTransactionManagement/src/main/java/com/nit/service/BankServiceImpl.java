package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.BankDAO;
@Service("bankService")
public class BankServiceImpl implements BankService {
 
     @Autowired
    private BankDAO dao;	
	
	@Override
	//transactionManagement Property is not mandatory Here {By default name is also ="transactionManager"}
	//@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager")
	@Transactional(propagation=Propagation.REQUIRED)
	public String transferMoney(long srcAcno, long dstAcno, double money) {
		
	  if(dao.withdraw(srcAcno, money)!=0&&dao.deposite(dstAcno, money)!=0)
				return "SuccessFully Updated : Money tranfered from "+srcAcno+" to "+dstAcno;
		else
			  throw new RuntimeException("Problem in money transfer");
	   }//TransferMoney()
	}//class
