package org.ies.bank.components;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {

    private final Scanner scanner;
    private final Bank bank;

    public BankApp(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run(){


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
            System.out.println("6.Salir");

            //Leer la opcion
            option = scanner.nextInt();
            scanner.nextLine();

            if (option ==1){

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

                System.out.println("Introduce la cantidad de dinero que quiere ingresar:");
                int amount = scanner.nextInt();
                scanner.nextLine();

                for (Account account: accounts){

                    if (account.getIban().equals(iban)){

                        //Si hay suficiente saldo, se reduce el saldo. Si no hay suficiente saldo se muestra "Saldo insuficiente"

                        if (account.getBalance() > amount){

                            System.out.println(account.getBalance() - amount);

                        } else if (account.getBalance() < amount) {

                            System.out.println("Saldo insuficiente");

                        }


                    } else {

                        System.out.println("No existe la cuenta");
                    }


                }






            }


        } while (option != 6);





    }

}
