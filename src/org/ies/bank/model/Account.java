package org.ies.bank.model;

import java.util.Objects;

public class Account {

    private String iban;
    private double balance;
    private Customer customer;

    public Account(String iban, double balance, Customer customer) {
        this.iban = iban;
        this.balance = balance;
        this.customer = customer;
    }


    //Método que muestra el IBAN  y el saldo de las cuentas
    public void showInfo(){

        customer.showInfo();
        System.out.println("IBAN:" + iban);
        System.out.println("Saldo: " + balance);
        System.out.println("NIF del cliente: " + customer.getNif());
    }


    //Método para el déposito  -->  deposit(amount): dado una cantidad ingresa esa cantidad en la a cuenta
    public void deposit(double amount){

        balance += amount;
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
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}

