package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bank {

    private String bankName;
    private Account[] account;

    public Bank(String bankName, Account[] account) {
        this.bankName = bankName;
        this.account = account;
    }

    //Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
    public void showCounts(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuantas cuentas hay?");
        int number = scanner.nextInt();
        scanner.nextLine();


        }










    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Account[] getAccount() {
        return account;
    }

    public void setAccount(Account[] account) {
        this.account = account;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bankName, bank.bankName) && Objects.deepEquals(account, bank.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, Arrays.hashCode(account));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", account=" + Arrays.toString(account) +
                '}';
    }
}
