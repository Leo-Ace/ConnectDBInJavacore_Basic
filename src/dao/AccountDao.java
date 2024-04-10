package dao;

import models.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> getAccounts();
    public Account getById(String id);
    public boolean insert(Account acc);
    public boolean update(Account acc);
    public List<Account> search(float from, float to);
}
