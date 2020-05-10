package com.capg.pecunia.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pecunia.dao.IAccountDao;
import com.capg.pecunia.entity.AccountBean;

@Service
public class AccountServiceImpl implements IAccountService {
	
	 @Autowired
	 IAccountDao accountDao;
	
	 @Override
		public AccountBean addAccount(AccountBean bean) {
			
			return accountDao.addAccount(bean);
		}
	 
	   @Override
	   public AccountBean findById(long accNumber) {
			return accountDao.findById(accNumber);
		}
	 
	    @Override
		public AccountBean updateAccount(AccountBean bean, long accNumber) {
			return accountDao.updateAccount(bean, accNumber);
		}
	 
	    @Override
		public void deleteAccount(long accNumber) {
			accountDao.deleteAccount(accNumber);
		}

		@Override
		public List<AccountBean> viewAll() {
			 
			return accountDao.viewAll();
		}
}