package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_02_intro_to_lld_and_oop.additional_problems.q_01_create_bank_account_class.solution;

public class BankAccount {
    // write the code of bank account class here
    public String accountNumber;
    public int balance;
    public double roi;

    public double getSimpleInterest(int years) {
        double simpleInterest = this.balance * this.roi * years / 100;
        return simpleInterest;
    }

    public double getBalanceWithInterest(int years) {
        return this.balance + getSimpleInterest(years);
    }
}
