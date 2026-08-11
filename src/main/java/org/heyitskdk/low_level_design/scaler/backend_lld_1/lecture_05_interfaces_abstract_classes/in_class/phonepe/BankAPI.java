package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.phonepe;

public interface BankAPI {

    void checkBalance();
    void transferMoney(int amount);

    default void checkTransactionHistory() {
        System.out.println("Checking Transaction history... Your patience is appreciated.");
    };
}
