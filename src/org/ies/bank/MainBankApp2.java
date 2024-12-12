package org.ies.bank;

import org.ies.bank.components.*;

import java.util.Scanner;

public class MainBankApp2 {
    public static void main(String[] args) {

        // Se necesita el scanner para leer
        Scanner scanner= new Scanner(System.in);

        // Guardamos en una variable (CustomerReader), y dentro del new() ponemos el scanner
        CustomerReader customerReader = new CustomerReader(scanner);

        // Guardamos en una variable (AccountReader), y dentro del new() ponemos el scanner y el objeto anterior
        AccountReader accountReader = new AccountReader(scanner, customerReader);

        BankReader bankReader = new BankReader(scanner, accountReader);

        BankApp2 bankApp2 = new BankApp2(bankReader);

        // Ejecutar run que está en BankApp
        bankApp2.run();
    }
}

// El orden de los reader será: customer, account, bank