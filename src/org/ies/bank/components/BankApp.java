package org.ies.bank.components;
import org.ies.bank.model.Account;

import java.util.Scanner;

public class BankApp {

    Scanner scanner = new Scanner(System.in);


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

            }



        } while (option != 6);





    }

}
