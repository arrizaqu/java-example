package com.javacodegeeks.springtx.jdbc.examples;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class SpringTranTemplateFundTransferTransaction extends FundManagerDao implements FundManager {
	private TransactionTemplate transactionTemplate;

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void transfer(final int accountNbr1, final int accountNbr2, final int amount)
			throws Exception {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				doTransfer(accountNbr1, accountNbr2, amount);
			}
		});
	}
}