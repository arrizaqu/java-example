package com.javacodegeeks.springtx.jdbc.examples;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SpringTranManagerFundTransferTransaction extends FundManagerDao implements FundManager {
	private PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager txManager) {
		this.transactionManager = txManager;
	}

	public void transfer(int accountNbr1, int accountNbr2, int amount) throws Exception {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus txStatus = transactionManager.getTransaction(txDef);
		try {
			doTransfer(accountNbr1, accountNbr2, amount);
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			throw e;
		}
	}
}
