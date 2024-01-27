package com.nhnacademy.gateway.service.account;

import com.nhnacademy.gateway.adator.AccountAdaptor;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    private final AccountAdaptor accountAdaptor;

    public AccountService(AccountAdaptor accountAdaptor) {
        this.accountAdaptor = accountAdaptor;
    }


}
