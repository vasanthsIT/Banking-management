package com.example.bank.management.system.bank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="Sbi_Bank")
@Data
public class Sbi_Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long account_number;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    double account_bal;
    @Column(nullable = false)
    BigInteger ph_no;
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String aadhar_number;
    @Column(nullable = false)
    String gender;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.ANY,pattern = "yyyy-MM-dd")
    Date dob;
    @Column(nullable = false)
    String address;
    @Column(nullable = false)
    String account_type;
    @Column(nullable = false)
    String email;
}
