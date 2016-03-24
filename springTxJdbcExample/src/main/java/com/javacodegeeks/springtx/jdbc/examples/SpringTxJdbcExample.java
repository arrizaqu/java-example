package com.javacodegeeks.springtx.jdbc.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTxJdbcExample {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FundManager fundManager = (FundManager) context.getBean("fundTransferTranTemplate");
		try {
			int amount = 200;
			printAccountDetails(fundManager);
			fundManager.transfer(1, 2, amount);
			System.out.println("Fund transfered");
			printAccountDetails(fundManager);
			fundManager.transfer(1, 2, fundManager.getBalance(1) + 1);
			printAccountDetails(fundManager);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		printAccountDetails(fundManager);
	}
	
	private static void printAccountDetails(FundManager fundManager) {
		System.out.println("Account 1 has " + fundManager.getBalance(1) + ", account 2 has " + fundManager.getBalance(2));
	}
}
