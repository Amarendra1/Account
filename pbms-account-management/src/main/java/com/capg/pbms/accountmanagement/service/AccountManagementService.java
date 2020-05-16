package com.capg.pbms.accountmanagement.service;


import java.util.List;




import com.capg.pbms.accountmanagement.model.Customer;

public interface AccountManagementService {
	
	 Customer  addAccount(Customer customer) ;
	 	 
	 Customer  getAccount(long accountId);
	 
	 List<Customer> getAllAccounts();
	 
	// Customer updateDetails(long accountId,Customer customer);
	 
	 Customer  updateCustomerName(long accountId,Customer customer);
	 
	 Customer  updateCustomerContact(long accountId,Customer customer);
	 
	 Customer  updateCustomerAddress(long accountId,Customer customer);
	 
	 boolean deleteAccount(long accountId);
//	 public Transaction creditUsingCheque( long accountId , double amount, Transaction transaction);
//	 Transaction debitUsingCheque(long accountId,double amount,Transaction transaction) ;
//	 
//	 Transaction creditUsingSlip(long accountId,double amount,Transaction transaction) ;
// 	
// 	 Transaction debitUsingSlip(long accountId,double amount,Transaction transaction) ;
// 	 
// 	public List<Transaction> getTransactionById( long transAccountId);
// 	
 	//public Optional<List<Transaction>> getAllTransactionsById(long accountId);
// 	public double getBalanceById(long accountId);
// 	public LoanRequest addLoan(long accountId,int creditScore,@PathVariable("amount") double loanAmount, LoanRequest loanrequest);
	 
	//public LoanRequest getLoanById(long accountId);
 
//	public List<Transaction> printpassbook(long accountId);

}
