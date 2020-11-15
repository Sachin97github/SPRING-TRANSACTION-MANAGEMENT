package com.nit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {

	@Bean("userTxService")
	public UserTransactionImp createUserTxService() throws Exception {
		UserTransactionImp userTxService = new UserTransactionImp();
		userTxService.setTransactionTimeout(60);
		return userTxService;
	}

	@Bean("userTxManager")
	public UserTransactionManager createUserTxManager() {
		UserTransactionManager userTxManager = new UserTransactionManager();
		userTxManager.setForceShutdown(true);
		return userTxManager;
   }
	
	@Bean("jtaManager")
	public JtaTransactionManager createJtaTxManager() throws Exception
	{
		JtaTransactionManager jtaManager=new JtaTransactionManager();
		//Set UserTxService
	    jtaManager.setUserTransaction(createUserTxService());
		//Set UserTxManger
		jtaManager.setTransactionManager(createUserTxManager());
		
		return jtaManager; 	
	}

}
