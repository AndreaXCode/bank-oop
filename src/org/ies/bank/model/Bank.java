package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;


public class Bank {

    private String bankName;
    private Account[] accounts;  //siempre en plural

    public Bank(String bankName, Account[] account) {
        this.bankName = bankName;
        this.accounts = account;
    }

    //Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
    public void showCounts(){

        for (Account account: accounts){

            System.out.println(account);
        }


    }





    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Account[] getAccount() {
        return accounts;
    }

    public void setAccount(Account[] account) {
        this.accounts = account;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bankName, bank.bankName) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", account=" + Arrays.toString(accounts) +
                '}';
    }
}
