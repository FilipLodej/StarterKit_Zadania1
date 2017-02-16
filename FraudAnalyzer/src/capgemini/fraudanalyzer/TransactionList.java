package capgemini.fraudanalyzer;
import java.util.ArrayList;
import java.util.List;

public class TransactionList {

	public List<Transaction> transactionList;

	public TransactionList() {
		transactionList=new ArrayList<Transaction>();
	}
	
	public void addTransactionToList(Transaction transaction){
		this.transactionList.add(transaction);
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

}
