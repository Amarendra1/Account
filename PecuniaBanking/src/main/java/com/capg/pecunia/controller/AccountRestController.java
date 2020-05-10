package com.capg.pecunia.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pecunia.entity.AccountBean;
import com.capg.pecunia.service.*;
import com.capg.pecunia.exception.*;



//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
@RestController

public class AccountRestController {

	@Autowired
     IAccountService accountservice;
	
	@PostMapping(path="/add")
	public ResponseEntity<Boolean> addAccount(@RequestBody AccountBean bean, long accNumber) {
		accountservice.addAccount(bean);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true,HttpStatus.OK);
		System.out.println("response entity=" + responseEntity+ "Account Number is  "+accNumber);
		return responseEntity;
	}
	
	
	  @GetMapping(path="/getdetails/{accNumber}") 
	  public ResponseEntity<AccountBean>findById(@PathVariable("accNumber") long accNumber) { AccountBean
	  bean=accountservice.findById(accNumber); 
	  if (bean == null) { 
	  throw new AccountNotFoundException("Account not found for Account Number=" + accNumber);
	  } 
	  return new ResponseEntity<AccountBean>(bean,new HttpHeaders(),HttpStatus.OK); }
	 
	
	
	
	@PutMapping(path="/update/{accNumber}")
	public ResponseEntity<AccountBean> updateAccount( @RequestBody AccountBean bean, @PathVariable long accNumber){
		bean= accountservice.updateAccount(bean, accNumber);
		return new ResponseEntity<AccountBean>(bean,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{accNumber}")
	public String deleteEmployee(@PathVariable("accNumber") Long accNumber) {
		accountservice.deleteAccount(accNumber);
		return "Deleted";
	}
	@GetMapping("/viewall")   //GET:         
	public ResponseEntity<List<AccountBean>> viewAll() {

		List<AccountBean> list = accountservice.viewAll();
		return new ResponseEntity<List<AccountBean>>(list,new HttpHeaders(),HttpStatus.OK);
		
}
}
