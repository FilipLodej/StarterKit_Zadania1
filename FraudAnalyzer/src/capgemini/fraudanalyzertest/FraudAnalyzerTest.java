package capgemini.fraudanalyzertest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.omg.IOP.TransactionService;

import capgemini.fraudanalyzer.FraudAnalyzer;
import capgemini.fraudanalyzer.Transaction;
import capgemini.fraudanalyzer.TransactionList;
import capgemini.fraudanalyzer.User;

public class FraudAnalyzerTest {
	User suspectUser1 = new User(542);
	User suspectUser2 = new User(1052);
	User suspectUser3 = new User(2103);
	User normalUser1 = new User(150);
	User normalUser2 = new User(120);
	User normalUser3 = new User(450);
	List<User> users;

	FraudAnalyzer analyzer;

	@Before
	public void setUp() {
		users = new ArrayList<User>();
		users.add(normalUser1);
		users.add(normalUser2);
		users.add(normalUser3);
		users.add(suspectUser1);
		users.add(suspectUser2);
		users.add(suspectUser3);
		
	}

	@Test
	public void shouldFindSuspectTransactionsForSuspectId() {
		System.out.println("Find Suspect User For SuspectId:");
		// given
		Transaction suspectTransaction1 = new Transaction(20170710, 3000, suspectUser1, 4, 20, 10);
		Transaction suspectTransaction2 = new Transaction(20170710, 3000, suspectUser2, 5, 20, 20);
		Transaction suspectTransaction3 = new Transaction(20170710, 5000, suspectUser3, 6, 20, 30);
		TransactionList transactions = new TransactionList();
		transactions.addTransactionToList(suspectTransaction1);
		transactions.addTransactionToList(suspectTransaction2);
		transactions.addTransactionToList(suspectTransaction3);
		// when
		analyzer = new FraudAnalyzer(transactions.transactionList, users);
		analyzer.findSuspectUserForSuspectId(suspectUser1);
		analyzer.findSuspectUserForSuspectId(suspectUser2);
		analyzer.findSuspectUserForSuspectId(suspectUser3);
		// then
		assertTrue(suspectTransaction1.isSuspectTransaction());
		assertTrue(suspectTransaction2.isSuspectTransaction());
		assertTrue(suspectTransaction3.isSuspectTransaction());
		System.out.println("Suspect user 542 suspect transaction :" + suspectTransaction1.isSuspectTransaction());
		System.out.println("Suspect user 1052 suspect transaction : " + suspectTransaction2.isSuspectTransaction());
		System.out.println("Suspect user 2103 suspect transaction  :" + suspectTransaction3.isSuspectTransaction());

	}

	@Test
	public void shouldFindSuspectUserMoreThen2TransactionsSameDateSumOver10000() {
		System.out.println("Find Suspect User Over 2 Transactions Same Date SumOver 10000: ");
		// given
		Transaction suspectTransaction1 = new Transaction(20170710, 3000, suspectUser1, 4, 20, 10);
		Transaction suspectTransaction2 = new Transaction(20170710, 3000, suspectUser1, 5, 20, 20);
		Transaction suspectTransaction3 = new Transaction(20170710, 5000, suspectUser1, 6, 20, 30);
		Transaction suspectTransaction4 = new Transaction(20170711, 3000, suspectUser1, 7, 20, 40);
		TransactionList transactions = new TransactionList();
		transactions.addTransactionToList(suspectTransaction1);
		transactions.addTransactionToList(suspectTransaction2);
		transactions.addTransactionToList(suspectTransaction3);
		transactions.addTransactionToList(suspectTransaction4);
		//when
		analyzer = new FraudAnalyzer(transactions.transactionList, users);
		// then
		assertTrue(analyzer.findSuspectTransactionsForTheSameUser());
	}

	@Test
	public void shouldFindSuspectUserMoreThen3TransactionsSameDateSumOver5000() {
		System.out.println("Find Suspect User More Then 3 Transactions Same Date SumOver 5000: ");
		// given
		Transaction suspectTransaction1 = new Transaction(20170710, 3000, suspectUser1, 4, 20, 10);
		Transaction suspectTransaction2 = new Transaction(20170710, 1000, suspectUser1, 5, 20, 30);
		Transaction suspectTransaction3 = new Transaction(20170710, 1000, suspectUser1, 6, 20, 40);
		Transaction suspectTransaction4 = new Transaction(20170710, 1000, suspectUser1, 7, 20, 50);
		TransactionList transactions = new TransactionList();
		transactions.addTransactionToList(suspectTransaction1);
		transactions.addTransactionToList(suspectTransaction2);
		transactions.addTransactionToList(suspectTransaction3);
		transactions.addTransactionToList(suspectTransaction4);
		// when
		analyzer = new FraudAnalyzer(transactions.transactionList, users);
		// then
		assertTrue(analyzer.findSuspectTransactionsForTheSameUser());
	}

	@Test
	public void shouldFindSuspectUserMoreThen5TransactionsSameDateToTheSameAccount() {
		System.out.println("Find Suspect User More Then 5 Transactions Same Date To The Same Account :");
		//given
		Transaction suspectTransaction1 = new Transaction(20170710, 1000, suspectUser1, 4, 20, 10);
		Transaction suspectTransaction2 = new Transaction(20170710, 1000, suspectUser1, 5, 20, 10);
		Transaction suspectTransaction3 = new Transaction(20170710, 1000, suspectUser1, 6, 20, 10);
		Transaction suspectTransaction4 = new Transaction(20170710, 500, suspectUser1, 7, 20, 10);
		Transaction suspectTransaction5 = new Transaction(20170710, 500, suspectUser1, 8, 20, 10);
		Transaction suspectTransaction6 = new Transaction(20170710, 500, suspectUser1, 9, 20, 10);
		TransactionList transactions = new TransactionList();
		transactions.addTransactionToList(suspectTransaction1);
		transactions.addTransactionToList(suspectTransaction2);
		transactions.addTransactionToList(suspectTransaction3);
		transactions.addTransactionToList(suspectTransaction4);
		transactions.addTransactionToList(suspectTransaction5);
		transactions.addTransactionToList(suspectTransaction6);
		// when
		analyzer = new FraudAnalyzer(transactions.transactionList, users);
		// then
		assertTrue(analyzer.findSuspectTransactionsForTheSameUser());
	}

}
