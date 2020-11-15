package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.service.BankService;

public class DistributedTxManagerTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService service = null;

		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		service = ctx.getBean("bankService", BankService.class);
		try {
			System.out.println(service.transferMoney(1234, 12345, 7505));
		} catch (Exception e) {
			e.printStackTrace();
		}
      ((AbstractApplicationContext) ctx).close();
   }
}
