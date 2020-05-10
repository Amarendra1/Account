package com.capg.pecunia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Pecunia_Bank_Management")

public class AccountBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accNumber;	
	//insert into PECUNIA_BANK_MANAGEMENT values(9177894094,'savings',5000.00,'Cuttack','india','18-4-87','abcd','amar',8008709826,506002,'Odisha')
	
		private String customerName;
		private Long customerPhno;
		private String accType;
		private String customerAddress1;
		private String customerAddress2;
		private String city;
		private String state;
		private String country;
		private int pincode;
		private double balance;
				 

		
		//Getters and setters
		public Long getAccNumber() {
			return accNumber;
		}



		public void setAccNumber(Long accNumber) {
			this.accNumber = accNumber;
		}



		public String getCustomerName() {
			return customerName;
		}



		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}



		public Long getCustomerPhno() {
			return customerPhno;
		}



		public void setCustomerPhno(Long customerPhno) {
			this.customerPhno = customerPhno;
		}



		public String getAccType() {
			return accType;
		}



		public void setAccType(String accType) {
			this.accType = accType;
		}



		public String getCustomerAddress1() {
			return customerAddress1;
		}



		public void setCustomerAddress1(String customerAddress1) {
			this.customerAddress1 = customerAddress1;
		}



		public String getCustomerAddress2() {
			return customerAddress2;
		}



		public void setCustomerAddress2(String customerAddress2) {
			this.customerAddress2 = customerAddress2;
		}



		public String getCity() {
			return city;
		}



		public void setCity(String city) {
			this.city = city;
		}



		public String getState() {
			return state;
		}



		public void setState(String state) {
			this.state = state;
		}



		public String getCountry() {
			return country;
		}



		public void setCountry(String country) {
			this.country = country;
		}



		public int getPincode() {
			return pincode;
		}



		public void setPincode(int pincode) {
			this.pincode = pincode;
		}



		public double getBalance() {
			return balance;
		}



		public void setBalance(double balance) {
			this.balance = balance;
		}







		@Override
		public String toString() {
			return "AccountBean [accNumber=" + accNumber + ", customerName=" + customerName + ", customerPhno="
					+ customerPhno + ", accType=" + accType + ", customerAddress1=" + customerAddress1
					+ ", customerAddress2=" + customerAddress2 + ", city=" + city + ", state=" + state + ", country="
					+ country + ", pincode=" + pincode + ", balance=" + balance + "]";
		}
		


}