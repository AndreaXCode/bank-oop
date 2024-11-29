package org.ies.bank.model;

import java.util.Objects;

public class Account {

    private String iban;
    private double balance;
    private Customer customers;

    public Account(String iban, double balance, Customer customers) {
        this.iban = iban;
        this.balance = balance;
        this.customers = customers;
    }

    //MÉTODOS

    //Dado un IBAN, mostrar la información de la cuenta con ese IBAN.
    public void showIban(String iban){

        for (Customer cuentas: customers){

            if (cuentas.getName().equals(iban)){


            }
        }
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customers;
    }

    public void setCustomer(Customer customer) {
        this.customers = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customers, account.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, customers);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", customer=" + customers +
                '}';
    }
}

