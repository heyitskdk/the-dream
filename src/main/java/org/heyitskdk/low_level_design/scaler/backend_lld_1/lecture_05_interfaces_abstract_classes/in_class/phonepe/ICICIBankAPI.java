package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.phonepe;

public class ICICIBankAPI implements BankAPI{

    @Override
    public void checkBalance() {
        System.out.println("ICICI bank is fetching your balance...");
    }

    @Override
    public void transferMoney(int amount) {
        System.out.println("ICICI bank has tranferred ₹" + amount + " successfully.");
    }
}
