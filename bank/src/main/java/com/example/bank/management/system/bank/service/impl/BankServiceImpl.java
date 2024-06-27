package com.example.bank.management.system.bank.service.impl;

import com.example.bank.management.system.bank.exception.UserNotFoundException;
import com.example.bank.management.system.bank.model.Deposit;
import com.example.bank.management.system.bank.model.ProfileUpdation;
import com.example.bank.management.system.bank.model.Sbi_Bank;
import com.example.bank.management.system.bank.model.WithDrawal;
import com.example.bank.management.system.bank.repository.BankRepository;
import com.example.bank.management.system.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{
    @Autowired
    BankRepository bankRepository;

    @Override
    public String  amount_withdrawal(WithDrawal withDrawal) {
        int minimum_balance=2000;
       Sbi_Bank sbi_bank= bankRepository.findById(withDrawal.getAccount_num()).
                orElseThrow(() -> new UserNotFoundException
                        (withDrawal.getAccount_num().toString()));
                if(minimum_balance<=sbi_bank.getAccount_bal()-withDrawal.getWith_drawal()){
                    sbi_bank.setAccount_bal(sbi_bank.getAccount_bal()-withDrawal.getWith_drawal());
                     bankRepository.save(sbi_bank);
                     return String.format("Amount debited from your account xxxx%s balance amount in account rs."+sbi_bank.getAccount_bal(),sbi_bank.getAccount_number().toString(),sbi_bank.getAccount_bal());
                }
                else {
                        return "Minimum balance rs."+minimum_balance+ " should be required in the account";
                }

    }

    @Override
    public Sbi_Bank amount_deposit(Deposit deposit){
        Sbi_Bank sbiBank=bankRepository.findById(deposit.getAccount_num()).
                orElseThrow(() ->new UserNotFoundException
                        (deposit.getAccount_num().toString()));
        if (sbiBank.getAccount_bal()>deposit.getDe_posit()){
            double updated_bal = sbiBank.getAccount_bal()+deposit.getDe_posit();
            sbiBank.setAccount_bal(updated_bal);
            bankRepository.save(sbiBank);
        }
        System.out.println("Amount credited");
        return sbiBank;
    }
    @Override
    public Sbi_Bank profile_updation(ProfileUpdation profileUpdation){
        Sbi_Bank sbiBank=bankRepository.findById(profileUpdation.getAccount_num()).orElseThrow(() ->new UserNotFoundException
                (profileUpdation.getAccount_num().toString()));
        sbiBank.setEmail(profileUpdation.getEmail());
        sbiBank.setPh_no(profileUpdation.getPh_no());
        return bankRepository.save(sbiBank);
    }



    @Override
    public Sbi_Bank account_creation(Sbi_Bank sbi_bank) {
        return bankRepository.save(sbi_bank);
        //return sbi_bank;
    }
}
