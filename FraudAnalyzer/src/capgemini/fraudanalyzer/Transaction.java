package capgemini.fraudanalyzer;

public class Transaction {

	private int transactionDate; // yearMonthDay
	private double transactionValue; //
	private int accountFrom;
	private int accountTo;
	private int userId;
	private int transactionId;
	private boolean suspectTransaction = false;

	public Transaction(int date, double value, User user, int transactionId, int accountFrom,int accountTo) {
		this.transactionDate = date;
		this.transactionValue = value;
		this.accountFrom = accountFrom;
		this.accountTo=accountTo;
		this.transactionId=transactionId;
		this.userId = user.getId();
		user.getTransactionList().add(this);
	}

	public int getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(int transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(int accountFrom) {
		this.accountFrom = accountFrom;
	}

	public int getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(int accountTo) {
		this.accountTo = accountTo;
	}

	public boolean isSuspectTransaction() {
		return suspectTransaction;
	}

	public void setSuspectTransaction(boolean suspectTransaction) {
		this.suspectTransaction = suspectTransaction;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

}
