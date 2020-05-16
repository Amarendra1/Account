package com.capg.pbms.accountmanagement.service;


import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;


import com.capg.pbms.accountmanagement.exceptions.AccountAlreadyExistException;
import com.capg.pbms.accountmanagement.exceptions.AccountNotFoundException;
import com.capg.pbms.accountmanagement.exceptions.EmptyAccountListException;
import com.capg.pbms.accountmanagement.model.Customer;

import com.capg.pbms.accountmanagement.repository.AccountRepository;
import com.capg.pbms.accountmanagement.repository.AddressRepository;

public class AccountManagementServiceImpl implements AccountManagementService {
	
	@Autowired
	AccountRepository accountrepo;
	@Autowired
	AddressRepository addressRepo;

	
	
	Customer customer=new Customer();
	@Override
	@Transactional
	public Customer addAccount(Customer customer) {
		customer.setAccountId(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
		customer.setAccountHolderId(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12));
		customer.setAccountBranchId("1");
		//customer.setAccountBalance(getBalanceById(customer.getAccountId()));
		customer.setAccountIntrest(0.0);
		customer.setCustomerId(String.valueOf(Math.abs(new Random().nextLong())).substring(0,4));
		if(accountrepo.existsById(customer.getAccountId()))
		throw new AccountAlreadyExistException("Customer with Id: " +customer.getAccountId()+" is Already Exist");
		addressRepo.save(customer.getCustomerAddress());
		return accountrepo.save(customer);
	}
	@Override
	@Transactional
	public Customer getAccount(long accountId) {
		if(!accountrepo.existsById(accountId)) 
		{	
		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
		}
	    return accountrepo.getOne(accountId);
	}

	
	@Override
	@Transactional
	public Customer updateCustomerName(long accountId,Customer customer) {
		if(!accountrepo.existsById(customer.getAccountId()))
			
	throw new AccountNotFoundException("Customer with Id : " +customer.getAccountId()+" Not Found");
	
		Customer newAccount=accountrepo.getOne(customer.getAccountId());
		newAccount.setCustomerName(customer.getCustomerName());
               accountrepo.save(newAccount);
		         return newAccount;	
	}

	@Override
	@Transactional 
	public boolean deleteAccount(long accountId) {
			if(!accountrepo.existsById(accountId)) 
			{	
			   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
			}
			accountrepo.deleteById(accountId);
			return !accountrepo.existsById(accountId);
			

		}

	@Override
	public List<Customer> getAllAccounts() {
	
		 if(accountrepo.count()==0)
		    throw new EmptyAccountListException("No Account Found in Account Database");
			return accountrepo.findAll();
	}

	@Override
	public Customer updateCustomerContact(long accountId,Customer customer) {
		
	 if(!accountrepo.existsById(customer.getAccountId()))
			
	 throw new AccountNotFoundException("Customer with Id : " +customer.getAccountId()+" Not Found");
			
		Customer newAccount=accountrepo.getOne(customer.getAccountId());
		newAccount.setCustomerContact(customer.getCustomerContact());
		     accountrepo.save(newAccount);
		      return newAccount;	
	}

	@Override
	public Customer updateCustomerAddress(long accountId,Customer customer) {
		
		 if(!accountrepo.existsById(customer.getAccountId()))
				
		 throw new AccountNotFoundException("Customer with Id : " +customer.getAccountId()+" Not Found");
					
			Customer newAccount=accountrepo.getOne(customer.getAccountId());
			newAccount.setCustomerAddress(customer.getCustomerAddress());
				     accountrepo.save(newAccount);
				      return newAccount;	
   }
	
	public boolean isValidAccountId(long accountId) {
		String str=String.valueOf(accountId);
		if(str.matches("[0-9]{12}")) 
		{
			 
			return true;	
		}
		throw new AccountNotFoundException("Account No should be in 12 digits");
		}


	 	public boolean isValidZipcode(String addressZipcode) 
	 	{
		if(addressZipcode.matches("[0-9]{6}")) 
		{
	 			return true;
	}
			return false;
		}
		}
		

//	@Override
//	public Customer updateDetails(long accountId, Customer customer) {
//		if(!accountrepo.existsById(customer.getAccountId()))		
//			throw new AccountNotFoundException("Customer with Id : " +customer.getAccountId()+" Not Found");
//		
//		return accountrepo.save(customer);
//	}
//	@Override
//	public Transaction creditUsingCheque(long accountId, double amount,Transaction transaction) {
//		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
//		Transaction t=rt.postForObject("http://transaction-management/transactions/creditcheque/id/"+accountId+"/amount/"+amount, transaction,Transaction.class);
//
//		Customer customer=accountrepo.getOne(accountId);
//		double currentBalance=getBalanceById(accountId)+amount;
//		 customer.setAccountBalance(currentBalance);
//		 accountrepo.save(customer);
//
//		Transaction transactions=new Transaction(accountId,t.getTransaction_id(),amount,t.getTransOption(),LocalDate.now(),t.getTransChequeId(),getBalanceById(accountId),t.getChequeList());
// 		
//		return transactions;
//	}
//	@Override
//	public Transaction debitUsingCheque(long accountId, double amount, Transaction transaction) {
//		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
//		Transaction t= rt.postForObject("http://transaction-management/transactions/debitcheque/id/"+accountId+"/amount/"+amount,transaction,Transaction.class);
//		Transaction transactions=new Transaction(accountId,t.getTransaction_id(), t.getTransAmount(),t.getTransOption(),t.getTransDate(),t.getTransChequeId(), t.getTransClosingBalance(),t.getChequeList());
//
//		Customer customer=accountrepo.getOne(accountId);
//		double currentBalance=getBalanceById(accountId)-amount;
//		 customer.setAccountBalance(currentBalance);
//		 accountrepo.save(customer);
//
//		return transactions;
//	}
//	@Override
//	public Transaction creditUsingSlip(long accountId, double amount, Transaction transaction) {
//		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
//		Transaction t= rt.postForObject("http://transaction-management/transactions/creditslip/id/"+accountId+"/amount/"+amount,transaction,Transaction.class);
//		Transaction transactions=new Transaction(accountId,t.getTransaction_id(), t.getTransAmount(),t.getTransOption(),t.getTransDate(),t.getTransChequeId(), t.getTransClosingBalance(),t.getChequeList());
//
//		Customer customer=accountrepo.getOne(accountId);
//		double currentBalance=getBalanceById(accountId)+amount;
//		 customer.setAccountBalance(currentBalance);
//		 accountrepo.save(customer);
//
//		return transactions;
//	}
//	@Override
//	public Transaction debitUsingSlip(long accountId, double amount, Transaction transaction) {
//		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
//		Transaction t= rt.postForObject("http://transaction-management/transactions/debitslip/id/"+accountId+"/amount/"+amount,transaction,Transaction.class);
//		Transaction transactions=new Transaction(accountId,t.getTransaction_id(), t.getTransAmount(),t.getTransOption(),t.getTransDate(),t.getTransChequeId(), t.getTransClosingBalance(),t.getChequeList());
//
//		Customer customer=accountrepo.getOne(accountId);
//		double currentBalance=getBalanceById(accountId)-amount;
//		 customer.setAccountBalance(currentBalance);
//		 accountrepo.save(customer);
//	
//		return transactions;
//	}
//	
// 	@Override
//	public List<Transaction> getTransactionById(long accountId) {
// 		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
//		Transaction []t= rt.getForObject("http://transaction-management/transactions/allTransactionsById/id/"+accountId,Transaction[].class);
//		return Arrays.asList(t);
//	}
//	@Override	
//	public double getBalanceById(long accountId) {
//		Customer customer=accountrepo.getOne(accountId);
//		if(!accountrepo.existsById(accountId))
//		{
//			throw new AccountNotFoundException("Account Not Found");
//		}
//		return customer.getAccountBalance();
//	}
// 
// 
//	@Override
//	public LoanRequest addLoan(long accountId, int creditScore, double loanAmount,LoanRequest loanrequest) {
//		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
//		LoanRequest r=rt.postForObject("http://loan-management/loans/assign/loan/id/"+accountId+"/"+creditScore+"/"+loanAmount,loanrequest,LoanRequest.class); 
//		LoanRequest request=new LoanRequest(accountId,loanAmount,r.getLoanType(),r.getLoanTenure(),r.getLoanRoi(), r.getLoanStatus(),r.getLoanEmi(),r.getCreditScore());
//	
//		Customer customer=accountrepo.getOne(accountId);
//		double currentBalance=getBalanceById(accountId)+loanAmount;
//		 customer.setAccountBalance(currentBalance);
//		 accountrepo.save(customer);
//		
//		return request;
//	}
//
//	
//	
// 	@Override
//	public List<Transaction> printpassbook(long accountId) {
// 		if(!accountrepo.existsById(accountId)) 
//		{	
//		   throw new AccountNotFoundException("Customer with Id "+accountId+" Not Found");
//		}
// 		Transaction []t= rt.getForObject("http://passbook-management/passbook/allTransactionsById/id/"+accountId,Transaction[].class);
//		return Arrays.asList(t);
//	}
//
//// 	public boolean isValidName(String customerName) {
//// 		if(customerName.matches("^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-,])*$/")) {
//// 			return true;
//// 		}
//// 		return false;
//// 	}
//

