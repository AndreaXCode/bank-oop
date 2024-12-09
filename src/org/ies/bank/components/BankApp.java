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

            System.out.println("Elige una opción:");
            System.out.println("1.Mostrar las cuentas del banco");
            System.out.println("2.Mostrar datos de una cuenta");
            System.out.println("3.Mostrar los datos de las cuentas de un cliente");
            System.out.println("4.Ingresar dinero en cuenta");
            System.out.println("5.Sacar dinero de una cuenta");
            System.out.println("6.Mostrar el número de cuentas de un cliente");
            System.out.println("7.Mostrar los datos del cliente al que pertenece la cuenta");
            System.out.println("8.Contar cuentas de cliente");
            System.out.println("9.Mostrar cliente de cuenta");
            System.out.println("10.Realizar transferencia");
            System.out.println("11.Salir");

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

                bank.deposit(iban, amount);


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

                Customer customer = bank.findAccountCustomer(iban);

                if (iban == null){

                    System.out.println("No existe la cuenta");

                } else {

                    System.out.println("Datos del cliente: " + customer);

                }


            } else if (option == 8) {


                //Hacer un método para contar cuentas de cliente
                System.out.println("Introduce un nif:");
                String nif = scanner.nextLine();

                int account = bank.countAccounts(nif);

                System.out.println(account);



            } else if (option == 9) {

                // Hacer método para mostrar cliente de cuenta
                System.out.println("Introduce un iban:");
                String iban = scanner.nextLine();

                Customer customer = bank.findAccountCustomer(iban);
                System.out.println("Cliente: " + customer);




            } else if (option == 10) {

                // Realizar transferencia

                //  Buscar cuenta de origen, buscar cuenta de destino.
                //  El amount tiene que ser suficente en la cuenta de origen.
                // En Bank.java creamos un método llamado tranfer, dentro llamaremos a varios métodos para conseguir lo anterior.





            } else if (option == 11){

                System.out.println("Saliendo del menu...");
            }


            else {

                System.out.println("Opción inválida");
            }


        } while (option != 11);


    }

}
