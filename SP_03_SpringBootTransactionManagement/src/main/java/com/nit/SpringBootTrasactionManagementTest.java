package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.dto.UserDetailsDTO;
import com.nit.service.BankService;

@SpringBootApplication
public class SpringBootTrasactionManagementTest {

	public static void main(String[] args) {

		UserDetailsDTO dto;
		BankService service;
		ApplicationContext ctx = SpringApplication.run(SpringBootTrasactionManagementTest.class, args);

		dto = new UserDetailsDTO();

		service = ctx.getBean("bankService", BankService.class);

		try {
			System.out.println(service.transferMoney(12345, 1234321, 40050));
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("---------------------------RUTIME EXCEPTION----------------------------");
			;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------------------------EXCEPTION ----------------------------");
			;
		}

		((ConfigurableApplicationContext) ctx).close();

	}
}
