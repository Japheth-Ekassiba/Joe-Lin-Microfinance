package com.demo.bank.DemoBank.helpers;

import java.util.Random;

public class GenAccountNumber {
    public static int generateAccountNumber(){
        int accountNumber;
        Random random = new Random();
        int bound = 134265;
        accountNumber = bound * random.nextInt(bound);
        return accountNumber;
    }
    //End Of Generate Account Number Method.
}
