package lab7.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lab7.model.Account;

@Service
public class AccountImp implements AccountDAO {
	public static List<Account> listAccount = new ArrayList<>();
	static {
		listAccount.add(new Account("pnmtriet","123",true));//Admin
		listAccount.add(new Account("anhtu","123",true));//Admin
		listAccount.add(new Account("nvtriet","123",false));//Customer
	}

	@Override
	public Account getOne(String username) {
		Account account=new Account();
		if(username.isEmpty()||username=="") {
			account=null;
			return null;
		}
		for(Account item:listAccount) {
			if(item.getUsername().equalsIgnoreCase(username)) {
				account=item;
			}
		}
		return account;
	}
}
