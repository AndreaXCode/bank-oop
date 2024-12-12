package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;


public class BankApp2 {

    private final BankReader bankReader;

    public BankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    // Tendrá un método run() que realice lo siguiente:
    public void run(){


        // - Pide un banco usando BankReader
        Bank bank = bankReader.read();



        // - Busca la cuenta con IBAN "ES0001".
        //    - Si no existe muestra "La cuenta no existe"
        //    - Si existe, hace un deposito en la misma de 500



        Account account = bank.findAccount("ES0001");


        if (account != null){

            account.deposit(500);

        } else {

            System.out.println("La cuenta no existe");
        }



        // - Busca otra cuenta con IBAN "ES0002"
        //    - Si no existe muestra "La cuenta no existe"
        //    - Si existe, saca 30 euros



        Account account2 = bank.findAccount("ES0002");

        if (account2 != null){

            account2.deposit(30);

        } else {

            System.out.println("La cuenta no existe");

        }



        // - Muestra en pantalla la información de la cuenta "ES0001"

        bank.showInfo("ES0001");





        // - Muestra en pantalla la información de la cuenta "ES0002"

        bank.showInfo("ES0002");





        // - Haz una trasnferencia de 500 euros desde "ES0001" a "ES0002"

        bank.tranfer("ES0001","ES0002", 500);



    }



}



