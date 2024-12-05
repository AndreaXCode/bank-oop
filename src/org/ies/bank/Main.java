package org.ies.bank;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Se necesita el scanner para leer
        Scanner scanner= new Scanner(System.in);

        // Guardamos en una variable (CustomerReader), y dentro del new() ponemos el scanner
        CustomerReader customerReader = new CustomerReader(scanner);

        // Guardamos en una variable (AccountReader), y dentro del new() ponemos el scanner y el objeto anterior
        AccountReader accountReader = new AccountReader(scanner, customerReader);

        BankReader bankReader = new BankReader(scanner, accountReader);

        BankApp bankApp = new BankApp(scanner, bankReader);

        // Ejecutar run que está en BankApp
        bankApp.run();
    }
}

// El orden de los reader será: customer, account, bank