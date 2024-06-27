package com.example.bank.management.system.bank.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ProfileUpdation {
   private Long account_num;
   private String email;
   private BigInteger ph_no;
}
