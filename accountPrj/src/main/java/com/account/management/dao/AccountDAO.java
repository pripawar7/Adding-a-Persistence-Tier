package com.account.management.dao;


import java.util.ArrayList;

import org.springframework.stereotype.Component;


import com.account.management.domain.Account;
import com.account.management.domain.Student;


public interface AccountDAO {

		public Account createAccount(Student student);
		public double retrieveBalance(String accountId);
		public void addAmount(String account,double newbalance);
		public ArrayList<Account> retrieveOverDueAccounts();
		public void setNewBalance(String accountId, double value) ;


}
