package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;


public class Bank {

    private String bankName;
    private Account[] accounts;  //siempre en plural

    // Generamos el constructor
    public Bank(String bankName, Account[] account) {
        this.bankName = bankName;
        this.accounts = account;
    }


    //Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)

    public void showCountsBank() {

        //Account puede ser sustituido por var
        for (var account : accounts) {

            System.out.println("IBAN: " + account.getIban() + "Saldo: " + account.getBalance() + "NIF: " + account.getCustomer().getNif());
        }


    }


    //Dado un IBAN, mostrar la información de la cuenta con ese IBAN.

    public void showInfo(String iban) {

        //Account puede ser sustituido por var
        for (var account : accounts) {


            if (account.getIban().equals(iban)) {

                // Muestra el método showInfo de account
               account.showInfo();

            }

        }

    }

    //Dado un NIF, mostrar todas las cuentas del cliente con ese NIF
    public void showCountsClient(String nif) {


        // Se recorren las cuentas comprobando si son del cliente con ese nif
        //Account puede ser sustituido por var
        for (var account : accounts) {

            // Dentro de customer esta el NIF, forma resumida de hacerlo
            Customer customer = account.getCustomer();

            if (customer.getNif().equals(nif)) {

                System.out.println("--Cuentas con ese NIF--");

                customer.showInfo();

                //System.out.println(account);
            }

        }

    }


    //Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN.
    // Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"

    public void getIntoCount(String iban, double amount) {

        //Account puede ser sustituido por var
        //Busca una cuenta con ese IBAN
        var account = findAccount(iban);

        //Si la cuenta existe hacer:
        if (account != null) {

            //Si el saldo de esa cuenta es mayor o igual que el dinero que se quiere sacar:
            if (account.getBalance() >= amount){

                //Restar ese dinero a nustro saldo
                account.deposit(-amount);

            } else {

                System.out.println("No hay suficiente saldo, a trabajarrr");
            }

        } else {

                System.out.println("No se encuentra la cuenta");

        }

    }

    //Preguntar a Mikel
    public void deposit(String iban, double amount){

        var account = findAccount(iban);
        if (account != null){

            account.deposit(amount);
            account.showInfo();

        } else {

            System.out.println("Cuenta no encontrada");
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


    // Método para buscar una cuenta, luego la devuelve
    public Account findAccount(String iban) {

        for (Account account : accounts) {

            if (account.getIban().equals(iban)) {

                return account;

            }
        }

        return null;

    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
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
