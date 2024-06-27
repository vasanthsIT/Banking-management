package com.example.bank.management.system.bank.service;

import com.example.bank.management.system.bank.model.Deposit;
import com.example.bank.management.system.bank.model.ProfileUpdation;
import com.example.bank.management.system.bank.model.Sbi_Bank;
import com.example.bank.management.system.bank.model.WithDrawal;

public interface BankService {
    String amount_withdrawal(WithDrawal withDrawal);
    Sbi_Bank account_creation(Sbi_Bank sbi_bank);

    Sbi_Bank amount_deposit(Deposit deposit);

    Sbi_Bank profile_updation(ProfileUpdation profileUpdation);
}
