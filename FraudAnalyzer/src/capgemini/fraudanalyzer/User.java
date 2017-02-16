package capgemini.fraudanalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

	private int userId;
	public List<Transaction> userTransactionsList = new ArrayList<Transaction>();

	public User(int id) {
		this.userId = id;
	}

	public void addTransactionToUserTransactions(Transaction transaction) {
		userTransactionsList.add(transaction);
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public List<Transaction> getTransactionList() {
		return userTransactionsList;
	}

}
