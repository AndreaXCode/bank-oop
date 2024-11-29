package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {

    private final Scanner scanner;
    private final CustomerReader customerReader;


    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }


    public Account read(){

        System.out.println("--Datos de la cuenta--");

        System.out.println("IBAN:");
        String iban = scanner.nextLine();

        System.out.println("Saldo");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cuantos clientes hay");
        int size = scanner.nextInt();
        scanner.nextLine();

        Customer[] customers = new Customer[size];

        for (int i = 0; i < size; i++) {

            customers[i] = customerReader.read();
        }

        return new Account(

                iban,
                balance,
                customers

        );

    }
}
