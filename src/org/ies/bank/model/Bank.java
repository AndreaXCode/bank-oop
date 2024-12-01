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

    //Preguntar a Mikel
    public void showCountsBank(){

        for (Account account: accounts){

            System.out.println("IBAN: " + account.getIban() + "Saldo: " + account.getBalance() + "NIF: " + account.getCustomer().getNif());
        }


    }

    //Dado un IBAN, mostrar la información de la cuenta con ese IBAN.


    public void showInfo(String iban){

        for (Account account: accounts){

            for (Customer customer: account.getCustomers()){

                if (account.getIban().equals(iban)){

                    System.out.println("Nombre: " + customer.getName());
                    System.out.println("Apellido: " + customer.getSurname());
                    System.out.println("NIF: " + customer.getNif());
                    System.out.println("IBAN:" + account.getIban());
                    System.out.println("Saldo: " + account.getBalance());

                }
            }


        }

    }

    //Dado un NIF, mostrar todas las cuentas del cliente con ese NIF
    public void showCountsClient(String nif){

        //Preguntar a Mikel

        for (Account account: accounts){


            Customer customer = account.getCustomer();
            if (customer.getNif().equals(nif));


        }


    }

    //Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN.
    // Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"
    public int getIntoCount(String iban, int amount){


        for (Account account: accounts){

            if (account.getIban().equals(iban)){

                System.out.println("IBAN: " + account.getIban() + "Cantidad: " + account.getBalance());

            }

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
