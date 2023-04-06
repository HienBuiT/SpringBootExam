package lab7.service;

import lab7.model.Account;

public interface AccountDAO {
	public Account getOne(String username);
}
