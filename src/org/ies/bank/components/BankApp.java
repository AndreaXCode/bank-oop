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


        //Inicia un bucle de menú  con las siguientes opciones


        // Creo la variable option
        int option;

        do {

            // Mostramos las opciones que tendrá nuestro menú

            option = chooseOption();

            if (option == 1) {

                // Ejecuta el método showCountsBank que está dentro de bank
                //Mostrar las cuentas del banco

                bank.showCountsBank();

            } else if (option == 2) {

                showInfo(bank);


            } else if (option == 3) {

                showAccountsClient(bank);


            } else if (option == 4) {

                deposit(bank);


            } else if (option == 5) {

                getIntoCount(bank);


            } else if (option == 6) {

                countNumber(bank);


            } else if (option == 7) {

                System.out.println("Introduce un IBAN:");
                String iban = scanner.nextLine();

                Customer customer = bank.findAccountCustomer(iban);

                if (iban == null){

                    System.out.println("No existe la cuenta");

                } else {

                    customer.showInfo();

                }




            } else if (option == 8) {


                // Realizar transferencia

                System.out.println("Introduce el IBAN de la cuenta origen:");
                String iban = scanner.nextLine();

                System.out.println("Introduce el IBAN de la cuenta destino:");
                String iban2 = scanner.nextLine();

                System.out.println("¿Que cantidad de dinero queire transferir?");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                bank.tranfer(iban, iban2, amount);


                // El amount tiene que ser suficente en la cuenta de origen.
                // En Bank.java creamos un método llamado tranfer, dentro llamaremos a varios métodos para conseguir lo anterior.




            } else if (option == 9){

                System.out.println("Saliendo del menu...");
            }


            else {

                System.out.println("Opción inválida");
            }


        } while (option != 9);


    }

    private void countNumber(Bank bank) {
        System.out.println("Introduce un NIF:");
        String nif = scanner.nextLine();


        int count = bank.countNumber(nif);
        System.out.println(count);
    }

    private void getIntoCount(Bank bank) {
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();

        System.out.println("Introduce la cantidad de dinero que quiere sacar:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        //Para sacar (restar)
        bank.getIntoCount(iban, -amount);
    }

    private void deposit(Bank bank) {
        //Ingresar dinero en cuenta

        //Se pide un IBAN
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();

        //Se pide una cantidad de dinero
        System.out.println("Introduce una cantidad de dinero");
        int amount = scanner.nextInt();
        scanner.nextLine();

        bank.deposit(iban, amount);  //invocar
    }

    private void showAccountsClient(Bank bank) {
        // Mostrar los datos de las cuentas de un cliente

        // Se pide un nif
        System.out.println("Introduce un NIF:");
        String nif = scanner.nextLine();


        // Ejecuta el método showCountsClient que está dentro del objeto bank
        bank.showAccountsClient(nif);
    }

    private void showInfo(Bank bank) {
        //Mostrar datos de una cuenta
        System.out.println("Introduce un IBAN:");
        String iban = scanner.nextLine();


        // Ejecuta el método showInfo que está dentro de bank
        bank.showInfo(iban);
    }

    private int chooseOption() {
        int option;
        System.out.println("Elige una opción:");
        System.out.println("1.Mostrar las cuentas del banco");
        System.out.println("2.Mostrar datos de una cuenta");
        System.out.println("3.Mostrar los datos de las cuentas de un cliente");
        System.out.println("4.Ingresar dinero en cuenta");
        System.out.println("5.Sacar dinero de una cuenta");
        System.out.println("6.Mostrar el número de cuentas de un cliente");
        System.out.println("7.Mostrar los datos del cliente al que pertenece la cuenta");
        System.out.println("8.Realizar transferencia");
        System.out.println("9.Salir");

        //Leer la opcion
        option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

}
