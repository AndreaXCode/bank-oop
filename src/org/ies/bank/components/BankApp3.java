package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp3 {

    private final BankReader bankReader;


    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }


    // Tendrá un método run() que realice lo siguiente:
    public void run(){


        // Pide un banco usando BankReader


        // Hay que guardarlo en una variable
        Bank bank = bankReader.read();



        // Muestra todas las cuentas del banco

        bank.showCountsBank();


        // Saca 50 de la cuenta ES0003

        Account account = bank.findAccount("ES0003");


        if (account != null){

            account.deposit(-50);

        } else {

            System.out.println("No se ha encontado la cuenta");
        }



        // Muestra las cuentas del cliente con NIF 000X

        bank.showAccountsClient("000X");



        // Mete 300 en la cuenta ES004

        Account account2 = bank.findAccount("ES004");
        account2.deposit(300);

        //hacer if


        // Muestra los datos del titular de la cuenta ES0001

        bank.showInfo("ES0001");







    }







}
