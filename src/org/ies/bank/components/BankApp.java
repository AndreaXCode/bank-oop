package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankApp {

    private final Scanner scanner;
    private final Bank bank;

    public BankApp(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {


        //Pide los datos de un banco

        System.out.println("--Datos del banco--");

        System.out.println("Nombre del banco:");
        String bankName = scanner.nextLine();

        System.out.println("Cuantas cuentas hay");
        int size = scanner.nextInt();
        scanner.nextLine();

        Account[] accounts = new Account[size];

        for (int i = 0; i < size; i++) {

            //Revisar
            final AccountReader accountReader = null;
            accounts[i] = accountReader.read();

        }

        //Inicia un bucle de menú con las siguientes opciones

        int option;

        do {
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

                //Mostrar las cuentas del banco

                bank.showCountsBank();

            } else if (option == 2) {

                //Mostrar datos de una cuenta

                System.out.println("Introduce un IBAN");
                String iban = scanner.nextLine();

                bank.showInfo(iban);


            } else if (option == 3) {

                System.out.println("Introduce un NIF:");
                String nif = scanner.nextLine();

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
