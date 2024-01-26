package com.nhnacademy.gateway.service.account;

import com.nhnacademy.gateway.domain.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccount(String userId);

    Account login(String userId, String password);


}
