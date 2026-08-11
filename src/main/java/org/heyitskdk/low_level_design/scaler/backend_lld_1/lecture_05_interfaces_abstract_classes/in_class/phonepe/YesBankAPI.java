package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.phonepe;

public class YesBankAPI implements BankAPI{

    @Override
    public void checkBalance() {
        System.out.println("Yes Bank is fetching your balance");
    }

    @Override
    public void transferMoney(int amount) {
        System.out.println("Yes Bank has safely transferred: ₹" + amount);
    }

    @Override
    public void checkTransactionHistory() {
        System.out.println("Yes Bank is checking your transaction history");
    }
}
