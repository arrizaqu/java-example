#Java Transaction 

A transaction is a unit of work that has ACID (atomic, consistent, isolated and durable) properties. Atomic means that the changes all happen or nothing happens. If money is debited from an account and credited to another account, a transaction ensures that either both the debit and credit complete or neither completes. Consistent implies that the changes leave the data in a consistent state. Isolated implies that changes do not interfere with other changes. Durable implies that once the changes are committed, they stay committed

#Java Transaction with JDBC
this one example, how to implement Java Transaction with JDBC local transaction.

read more : 
https://examples.javacodegeeks.com/core-java/sql/jdbc-transaction-management-example/

#Java Transaction with DataSourceTransactionManager


read more : 
https://examples.javacodegeeks.com/enterprise-java/spring/jdbc/spring-transaction-management-example-with-jdbc-example/
