package org.ies.bank.components;

import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankApp {

    // Se necesita el Scanner para hacer el menu
    private final Scanner scanner;
    // Se necesita el BankReader para pedir un banco al usuario
    private final BankReader bankReader;

    // Solo se inyectan componentes
    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {

        // Siempre empezamos pidiendo los datos con el reader
        // Creamos una variable llamada Bank con el objeto bank, que guardará y ejecutará "bankReader"
        // De esta manera se verán los datos (lo que se pide).
        Bank bank = bankReader.read();


        //Inicia un bucle de menú con las siguientes opciones


        // Creo la variable option
        int option;

        do {

            // Mostramos las opciones que tendrá nuestro menú

            System.out.println("1.Mostrar las cuentas del banco");
            System.out.println("2.Mostrar datos de una cuenta");
            System.out.println("3.Mostrar los datos de las cuentas de un cliente");
            System.out.println("4.Ingresar dinero en cuenta");
            System.out.println("5.Sacar dinero de una cuenta");
            System.out.println("6.Mostrar el número de cuentas de un cliente");
            System.out.println("7.Mostrar los datos del cliente al que pertenece la cuenta");
            System.out.println("8.Salir");

            //Leer la opcion
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {

                // Ejecuta el método showCountsBank que está dentro de bank
                //Mostrar las cuentas del banco

                bank.showCountsBank();

            } else if (option == 2) {

                //Mostrar datos de una cuenta
                System.out.println("Introduce un IBAN:");
                String iban = scanner.nextLine();


                // Ejecuta el método showInfo que está dentro de bank
                bank.showInfo(iban);


            } else if (option == 3) {

                // Mostrar los datos de las cuentas de un cliente

                // Se pide un nif
                System.out.println("Introduce un NIF:");
                String nif = scanner.nextLine();


                // Ejecuta el método showCountsClient que está dentro de bank
                bank.showCountsClient(nif);


            } else if (option == 4) {

                //Ingresar dinero en cuenta

                //Se pide un IBAN
                System.out.println("Introduce un IBAN:");
                String iban = scanner.nextLine();

                //Se pide una cantidad de dinero
                System.out.println("Introduce una cantidad de dinero");
                int amount = scanner.nextInt();
                scanner.nextLine();

                bank.getIntoCount(iban, amount);


            } else if (option == 5) {

                System.out.println("Introduce un IBAN:");
                String iban = scanner.nextLine();

                System.out.println("Introduce la cantidad de dinero que quiere sacar:");
                int amount = scanner.nextInt();
                scanner.nextLine();

                //Para sacar (restar)
                bank.getIntoCount(iban, -amount);

            } else if (option == 6) {

                System.out.println("Introduce un NIF:");
                String nif = scanner.nextLine();


                int count = bank.countNumber(nif);
                System.out.println(count);



            } else if (option == 7) {

                System.out.println("Introduce un IBAN:");
                String iban = scanner.nextLine();

               Customer data = bank.findAccountCustomer(iban);
                System.out.println("Datos del cliente: " + data);



            } else if (option == 8){

                System.out.println("Saliendo del menu...");
            }


            else {

                System.out.println("Opción inválida");
            }


        } while (option != 8);


    }

}
