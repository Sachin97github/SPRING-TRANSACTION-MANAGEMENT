package com.nit.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.service.BankService;

public class TransactionalManagementTest {
	public static void main(String[] args) {

		ApplicationContext ctx = null;
		BankService proxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		proxy = ctx.getBean("bankService", BankService.class);

		System.out.println(
				"CLASS NAME " + proxy.getClass().getName() + " SUPER CLASS NAME " + proxy.getClass().getSuperclass()
						+ " INTERFACES " + Arrays.deepToString(proxy.getClass().getInterfaces()));

		try {
			proxy.transferMoney(101,105,4500d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
	}

}
