package com.account.management.dao.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.account.management.dao.AccountDAO;
import com.account.management.domain.Account;
import com.account.management.domain.Student;

@Repository("accountDaoMock")
public class AccountDAOMockImpl implements AccountDAO {

	private ArrayList<Account> acctList;

	@PostConstruct
	public void init() {
		Account acct;

		acctList = new ArrayList<Account>();

		String s1 = "09/22/2016", s2 = "06/11/2015";
		;
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = null, date2 = null;
		try {
			date1 = sd.parse(s1);
			date2 = sd.parse(s2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
		acct = new Account("101", 0.0, date1);
		acctList.add(acct);

		acct = new Account("102", 0.0, date2);
		acctList.add(acct);
	}

	public Account createAccount(Student student) {
		// TODO Auto-generated method stub

		System.out.println("hey there");
		String s1 = "09/22/2016";
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = null;
		
		try {
			date1 = sd.parse(s1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("student"+student.getStudentId());
		Account account=new Account(student.getStudentId(), 0.0, date1);
		
	    return account;
	}

	public double retrieveBalance(String accountId) {
		// TODO Auto-generated method stub

		for (Account tstAcct : acctList) {
			if (tstAcct.matchesId(accountId)) {
				return tstAcct.getBalanceDue();
			}
		}
		return 0;

	}

	public void addAmount(String accountId, double fees) {
		// TODO Auto-generated method stub
		double curBalance = retrieveBalance(accountId);

		double newBalance = curBalance + fees;

		for (Account tstAcct : acctList) {
			if (tstAcct.matchesId(accountId)) {
				tstAcct.setBalanceDue(newBalance);
			}
		}

		System.out.println("bal:" + newBalance);

	}

	public void setNewBalance(String accountId, double value) {
		// TODO Auto-generated method stub
		for (Account tstAcct : acctList) {
			if (tstAcct.matchesId(accountId)) {
				tstAcct.setBalanceDue(value);
			}
		}
	}

	public ArrayList<Account> retrieveOverDueAccounts() {
	
		String s3 = "06/12/2015";
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Date dueDate=null;
		try {
			 dueDate=sd.parse(s3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ArrayList<Account> dueAccntList= new ArrayList<Account>();
		for (Account tstAcct : acctList) {
			if (tstAcct.getBalanceDue()>0 && tstAcct.getDate().before(dueDate)) {
				
				dueAccntList.add(tstAcct);
				
			}
		}
		return dueAccntList;
	}
	
}
