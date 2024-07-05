package com.beaverg.services;

import com.beaverg.domain.Account;

import static com.beaverg.utils.PropertyGetter.getData;

public class AccountService {

    public static Account createValidAccount() {
        return new Account(getData("Credentials.valid_email"), getData("Credentials.valid_pass"));
    }

    public static Account createInvalidAccount() {
        return new Account(getData("Credentials.invalid_email"), getData("Credentials.invalid_pass"));
    }
}
