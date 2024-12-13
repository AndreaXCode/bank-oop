package org.ies.bank;

import org.ies.bank.components.*;

import java.util.Scanner;

public class MainBankApp4 {
    public static void main(String[] args) {

        // Se necesita el scanner para leer
        Scanner scanner = new Scanner(System.in);

        // Guardamos en una variable (CustomerReader), y dentro del new() ponemos el scanner
        CustomerReader customerReader = new CustomerReader(scanner);

        // Guardamos en una variable (AccountReader), y dentro del new() ponemos el scanner y el objeto anterior para usarlo (grisecito)
        AccountReader accountReader = new AccountReader(scanner, customerReader);

        // Guardamos en una variable (BankReader), y dentro del new() ponemos el scanner y el objeto anterior para usarlo (grisecito)
        BankReader bankReader = new BankReader(scanner, accountReader);

        // Ya se han puesto todos los componentes, queda el BankApp4 y bankReader esta en gris, no se está usando.
        // Asi qué, guardamos en una variable (BankApp4), y dentro del new() el objeto anterior para usarlo (grisecito)
        // No se pone el scanner ya que no se usa en el BankApp4
        BankApp4 bankApp4 = new BankApp4(bankReader);

        // Ejecutar run que está en BankApp4
        bankApp4.run();


    }
}

// El orden de los reader será: customer, account, bank

// Customer  --> No tiene array
// Account  --> Tiene un tipo Customer, sin array
// Bank  --> Debe tener la mayoría de los métodos y tiene el array de cuentas





























