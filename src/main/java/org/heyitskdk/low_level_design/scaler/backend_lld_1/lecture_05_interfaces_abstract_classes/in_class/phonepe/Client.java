package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.phonepe;

public class Client {

    public static void main(String[] args) {
        BankAPI bankAPI = new YesBankAPI();

        bankAPI.checkBalance();
        bankAPI.transferMoney(2000);
        bankAPI.checkTransactionHistory();

        bankAPI = new ICICIBankAPI();
        bankAPI.checkBalance();
        bankAPI.transferMoney(1000);
    }
}
