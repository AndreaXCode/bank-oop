package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {

    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }


    public Bank read(){

        System.out.println("--Datos del banco--");

        System.out.println("Nombre del banco:");
        String bankName = scanner.nextLine();

        System.out.println("Cuantas cuentas hay");
        int size = scanner.nextInt();
        scanner.nextLine();

        Account[] account = new Account[size];

        for (int i = 0; i < size; i++) {

            account[i] = accountReader.read();
        }

        return new Bank(

                bankName,
                account


        );
    }
}
