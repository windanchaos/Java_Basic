package com.chaosbom.repository;

import com.chaosbom.entity.Account;

import java.util.List;

public interface AccountRepository {
    int save(Account account);
    int update(Account account);
    int deleteByID(long id);
    List<Account> findAll();
    Account findByID(long id);
}
