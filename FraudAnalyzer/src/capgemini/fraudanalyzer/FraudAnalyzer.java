package capgemini.fraudanalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

public class FraudAnalyzer {

	public List<Transaction> transactionsList;
	public List<User> userList;

	public FraudAnalyzer(List<Transaction> transactionList, List<User> userList) {
		this.transactionsList = transactionList;
		this.userList = userList;
	}

	public void findSuspectUserForSuspectId(User suspectUser) {
		for (Transaction transaction : transactionsList) {
			if (transaction.getUserId() != 101 && transaction.getUserId() != 606) {
				if (transaction.getUserId() == suspectUser.getId()) {
					transaction.setSuspectTransaction(true);
				}
			}

		}
	}

	public boolean findSuspectTransactionsForTheSameUser() {
		boolean suspect = false;
		for (User user : userList) {
			if (user.userTransactionsList.size() > 2) {
				Map<Integer, List<Transaction>> transactionsByDay = groupTransactionsByDate(user.userTransactionsList);
				for (Integer date : transactionsByDay.keySet()) {
					List<Transaction> transactionsBySingleDay = transactionsByDay.get(date);
					if (transactionsBySingleDay.size() > 2 == true) {
						double sumOfTransactionsValues = 0;
						for (Transaction transaction : transactionsBySingleDay) {
							sumOfTransactionsValues += transaction.getTransactionValue();

						}

						if (sumOfTransactionsValues > 5000 && transactionsBySingleDay.size() > 3) {
							suspect = true;
							System.out.println("Warning for user = " + user.getId() + " for date " + date
									+ " Sum of transactions > 5000 EUR more than 3 transactions");
						} else if (sumOfTransactionsValues > 10000 && transactionsBySingleDay.size() > 2) {
							suspect = true;
							System.out.println("Warning for user = " + user.getId() + " for date " + date
									+ " Sum of transactions > 10000 EUR more than 2 transactions");
						} else {
							suspect = isMoreThan5TransactionsToTheSameAccount(transactionsBySingleDay, user);
						}
						if (suspect == true) {
							for (Transaction transaction : transactionsBySingleDay) {
								transaction.setSuspectTransaction(true);
							}
						}
					}

				}

			}
		}
		return suspect;
	}

	private Map<Integer, List<Transaction>> groupTransactionsByDate(List<Transaction> userTransactionsList) {
		Map<Integer, List<Transaction>> transactionsByDay = new HashMap<Integer, List<Transaction>>();
		for (Transaction transaction1 : userTransactionsList) {
			if (transactionsByDay.containsKey(transaction1.getTransactionDate()) == false) {
				transactionsByDay.put(transaction1.getTransactionDate(), new ArrayList<Transaction>());
			}
			transactionsByDay.get(transaction1.getTransactionDate()).add(transaction1);
		}
		return transactionsByDay;
	}

	private boolean isMoreThan5TransactionsToTheSameAccount(List<Transaction> transactionsBySingleDay, User user) {
		boolean suspect = false;
		Map<Integer, Integer> transactionsToTheSameAccount = new HashMap<Integer, Integer>();
		for (Transaction transaction : transactionsBySingleDay) {
			if (transactionsToTheSameAccount.containsKey(transaction.getAccountTo()) == false) {
				transactionsToTheSameAccount.put(transaction.getAccountTo(), 1);
			} else {
				int numberOfTranscionAccountTo = transactionsToTheSameAccount.get(transaction.getAccountTo());
				numberOfTranscionAccountTo++;
				transactionsToTheSameAccount.put(transaction.getAccountTo(), numberOfTranscionAccountTo);
			}

		}
		for (Integer accountTo : transactionsToTheSameAccount.keySet()) {
			int numberOfTransactions = transactionsToTheSameAccount.get(accountTo);
			if (numberOfTransactions > 5) {
				suspect = true;
				System.out.println("Warning for user = " + user.getId() + " for date "
						+ transactionsBySingleDay.get(0).getTransactionDate() + " More then 5 transactions to Account "
						+ accountTo);
			}
		}
		return suspect;
	}

	public List<Transaction> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<Transaction> transactionsList) {
		this.transactionsList = transactionsList;
	}
}
