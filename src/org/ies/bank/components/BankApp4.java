package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp4 {

    //Pide usar BankReader
    private final BankReader bankReader;

    public BankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    //Tendrá un método run() que realice lo siguiente:
    public void run(){


        //Pide un banco usando BankReader
        //Hay que guardarlo en una variable

        Bank bank = bankReader.read();


        //Busca la cuenta con IBAN ES0001
        //Si no existe la cuenta muestra un mensaje de error
        //Si existe:
        //Muestra los datos de la cuenta


        //Usar metodo que devuelve la cuenta  --> esta dentro de bank
        Account account = bank.findAccount("ES0001");

        if (account != null){

            account.showInfo();


        } else {

            System.out.println("No existe la cuenta");
        }


        //Haz una transferencia de todo el dinero de la cuenta ES0001 a la cuenta ES0002

        //Buscar las 2 cuentas
        Account account1 = bank.findAccount("ES0001");
        Account account2 = bank.findAccount("ES0002");

        //Comprobar si existen
        if (account1 != null && account2 != null){

           double amount = account1.getBalance();

            bank.tranfer("ES0001", "ES0002", amount);


        } else {

            System.out.println("Una de las cuentas no existe");
        }



        //Muestra la información del banco

        bank.showCountsBank();



    }


}
