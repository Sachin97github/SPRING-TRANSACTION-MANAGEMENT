package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nit.service.BankService;

@SpringBootApplication
public class Sp06SpringBootDistributedTxMgmt1Application {

	public static void main(String[] args) {
		
		
		ApplicationContext ctx = null;
		BankService service = null;

		ctx = SpringApplication.run(Sp06SpringBootDistributedTxMgmt1Application.class, args); 
		service = ctx.getBean("bankService", BankService.class);
		try {
			System.out.println(service.transferMoney(1234, 12345, 7505));
		} catch (Exception e) {
			e.printStackTrace();
		}
      ((AbstractApplicationContext) ctx).close();
   }
	}

