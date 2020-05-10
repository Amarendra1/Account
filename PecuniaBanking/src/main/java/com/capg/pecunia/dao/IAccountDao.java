package com.capg.pecunia.dao;

import java.util.List;

import com.capg.pecunia.entity.AccountBean;

public interface IAccountDao {
	
	
	  public AccountBean addAccount(AccountBean bean);
	  
	  public AccountBean findById(long accNumber);
	  
	  public AccountBean updateAccount(AccountBean bean, long accNumber);
	  
	  public void deleteAccount(long accNumber);
	  
	  public List<AccountBean> viewAll();

	
	 
	 
}

