package com.javacodegeeks.springtx.jdbc.examples;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class FundManagerDao extends JdbcDaoSupport implements FundManager {

	void doTransfer(int accountNbr1, int accountNbr2, int amount) {		
		verifyAccount(accountNbr1);				
		System.out.println("Transfer amount: " + amount);
		Integer account1Balance = getJdbcTemplate().queryForObject(
				"SELECT BALANCE FROM ACCOUNT WHERE ID = ?",
				new Object[] { accountNbr1 }, Integer.class);
		if (account1Balance < amount) {
			throw new RuntimeException("Cannot transfer, account doesn't have enough funds!");
		}
		int account1NewBalance = account1Balance - amount;			
		getJdbcTemplate().update(
				"UPDATE ACCOUNT SET BALANCE = ? WHERE ID = ?",
				account1NewBalance, accountNbr1);
		
		verifyAccount(accountNbr2);
		Integer account2Balance = getJdbcTemplate().queryForObject(
				"SELECT BALANCE FROM ACCOUNT WHERE ID = ?",
				new Object[] { accountNbr2 }, Integer.class);
		int account2NewBalance = account2Balance + amount;
		getJdbcTemplate().update(
				"UPDATE ACCOUNT SET BALANCE = ? WHERE ID = ?",
				account2NewBalance, accountNbr2);	
	}

	public int getBalance(int accountNbr) {
		return getJdbcTemplate().queryForObject("SELECT BALANCE FROM ACCOUNT WHERE ID = ?", new Object[]{accountNbr}, Integer.class);
	}

	public void verifyAccount(int accountNbr) {
		boolean acountExists = getJdbcTemplate().queryForObject("SELECT 1 FROM ACCOUNT WHERE ID = ?", new Object[]{accountNbr}, Integer.class) == 1;
		if (!acountExists) {
			throw new RuntimeException("Account " + accountNbr + " doesn't exists");
		}
	}

}
