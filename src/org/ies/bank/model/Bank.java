package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Bank {

    Scanner scanner = new Scanner(System.in);

    private String bankName;
    private Account[] accounts;  //siempre en plural

    public Bank(String bankName, Account[] account) {
        this.bankName = bankName;
        this.accounts = account;
    }

    //Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)

    public void showCountsBank() {

        for (Account account : accounts) {

            System.out.println("IBAN: " + account.getIban() + "Saldo: " + account.getBalance() + "NIF: " + account.getCustomer().getNif());
        }


    }

    //Dado un IBAN, mostrar la información de la cuenta con ese IBAN.


    public void showInfo(String iban) {

        for (Account account : accounts) {


            if (account.getIban().equals(iban)) {

                System.out.println("Nombre: " + account.getCustomer().getName());
                System.out.println("Apellido: " + account.getCustomer().getSurname());
                System.out.println("NIF: " + account.getCustomer().getNif());
                System.out.println("IBAN:" + account.getIban());
                System.out.println("Saldo: " + account.getBalance());

            }

        }

    }

    //Dado un NIF, mostrar todas las cuentas del cliente con ese NIF
    public void showCountsClient(String nif) {


        for (Account account : accounts) {


            Customer customer = account.getCustomer();
            if (customer.getNif().equals(nif)) {

                System.out.println("--Cuentas con ese NIF:--");
                System.out.println(account);
            }


        }


    }


    //Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN.
    // Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"


    public Account findAccount(String iban) {

        for (Account account : accounts) {

            if (account.getIban().equals(iban)) {

                return account;

            }
        }

        return null;

    }


    public void getIntoCount(String iban, double amount) {

        Account account = findAccount(iban);

        if (account == null) {

            System.out.println("No se ha encontrado ninguna cuenta");

        } else {

            account.setBalance(account.getBalance() + amount);
            System.out.println("Saldo: " + account.getBalance());
        }


    }

    //Dado un NIF, devuelve el número de cuentas de ese cliente.
    public int countNumber(String nif) {

        int counter = 0;

        for (Account account : accounts) {

            if (account.getCustomer().getNif().equals(nif)) {

                counter++;
            }
        }

        return counter;
    }


    //Dado un IBAN, devuelve los datos del cliente al que pertenece la cuenta. Si no existe la cuenta devuelve null.
    public Customer findAccountCustomer(String iban) {

        Account account = findAccount(iban);

        if (account != null) {

            return account.getCustomer();

        } else {

            return null;
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
