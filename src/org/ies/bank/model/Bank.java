package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;


public class Bank {

    private String bankName;
    private Account[] accounts;  //siempre en plural

    // Generamos el constructor
    public Bank(String bankName, Account[] account) {
        this.bankName = bankName;
        this.accounts = account;
    }


    //Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)

    public void showCountsBank() {

        //Account puede ser sustituido por var
        for (var account : accounts) {

            System.out.println("IBAN: " + account.getIban() + " Saldo: " + account.getBalance() + " NIF: " + account.getCustomer().getNif());
        }


    }


    //Dado un IBAN, mostrar la información de la cuenta con ese IBAN.

    public void showInfo(String iban) {

        //Account puede ser sustituido por var
        for (var account : accounts) {


            if (account.getIban().equals(iban)) {

                // Muestra el método showInfo de account
               account.showInfo();

            } else {

                System.out.println("No existe esa cuenta");
            }

        }

    }

    //Dado un NIF, mostrar todas las cuentas del cliente con ese NIF
    public void showAccountsClient(String nif) {


        // Se recorren las cuentas comprobando si son del cliente con ese nif
        //Account puede ser sustituido por var
        for (var account : accounts) {

            // Dentro de customer esta el NIF, forma resumida de hacerlo
            Customer customer = account.getCustomer();

            if (customer.getNif().equals(nif)) {

                System.out.println("--Cuentas con ese NIF--");

                customer.showInfo();


            } else {

                System.out.println("No existe esa cuenta");
            }

        }

    }


    //Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN.
    // Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"

    public void getIntoCount(String iban, double amount) {

        //Account puede ser sustituido por var
        //Busca una cuenta con ese IBAN  --> usan el método findAccount
        var account = findAccount(iban);

        //Si la cuenta existe hacer:
        if (account != null) {

            //Si la cantidad de dinero es mayor o igual que 0 hacer:
            if (amount >= 0){

                //Ingresar esa cantidad en la cuenta y mostrar la cuenta con los nuevos cambios
                account.deposit(amount);
                account.showInfo();

            } else {
                //Si el saldo de esa cuenta es mayor o igual que el dinero que se quiere sacar:
                if (account.getBalance() >= -amount){

                    //Restar ese dinero a nustro saldo
                    account.deposit(amount);
                    account.showInfo();

                } else {

                    System.out.println("No hay suficiente saldo, a trabajarrr");
                }
            }



        } else {

                System.out.println("No se encuentra la cuenta");

        }

    }



    //Dado un NIF, devuelve el número de cuentas de ese cliente.
    public int countNumber(String nif) {

        //Inicializamos el contador dandole el valor 0
        int counter = 0;


        for (Account account : accounts) {

            if (account.getCustomer().getNif().equals(nif)) {

                //Incrementamos el contador
                counter++;
            }
        }

        //Devuelvo el número de cuentas de ese cliente
        return counter;
    }


    //Dado un IBAN, devuelve los datos del cliente al que pertenece la cuenta. Si no existe la cuenta devuelve null.
    public Customer findAccountCustomer(String iban) {

        //Busca la cuenta con ese parámetro
        Account account = findAccount(iban);

        //Si la cuenta existe, la devolvemos
        if (account != null) {

            return account.getCustomer();

        } else {

            return null;
        }


    }


    // Método de transferencia
    //Dados dos IBAN y una cantidad de dinero, realiza una transferencia desde la cuenta con el primer IBAN a la cuenta con el segundo IBAN.
    // Si una de las cuentas no existo o no hay suficiente saldo en la cuenta de origen no se realiza la trasnferencia y se muestra un error explicando el problema.

    public void tranfer(String iban, String iban2, double amount){

        //Buscamos las 2 cuentas, origen y destino
        Account account = findAccount(iban);
        Account account2 = findAccount(iban2);

        //Si las 2 cuentas existen hacer:
        if (account != null && account2 != null){

            //Si el saldo de la cuenta de origen es mayor o igual que la cantidad que se quiere transferir
            if (account.getBalance() >= amount){

                //Quitamos la cantidad el la C.O y la añadimos en la C.D
                account.deposit(-amount);
                account2.deposit(+amount);

                //Mostramos la info de las 2 cuentas para ver los cambios
                account.showInfo();
                account2.showInfo();


            } else {

                System.out.println("No hay suficiente dinero");
            }

        } else {

            System.out.println("Una de las cuentas no existe");
        }

    }




    // Método para buscar una cuenta, luego la devuelve
    public Account findAccount(String iban) {

        for (Account account : accounts) {

            if (account.getIban().equals(iban)) {

                return account;

            }
        }

        return null;

    }

    // Método para contar cuentas de cliente
    public int countAccounts(String nif){

        int count = 0;

        for (var account: accounts){

            if (account.getCustomer().getNif().equals(nif)){

                count ++;
            }
        }

        return count;
    }



    //withdraw(amount): dado una cantidad saca el dinero de la cuenta. Si no hay suficiente saldo muestra un mensaje de error y no modifica el saldo.
    public void withdraw(double amount, String iban){

        var account = findAccount(iban);

        for (Account account2 : accounts){

            //Si la cuenta existe
            if (account2 != null){

                if (account.getBalance() >= amount){

                    account.deposit(-amount);

                } else {

                    System.out.println("No hay suficiente dinero el la cuenta");
                }

            } else {

                System.out.println("Cuenta no encontrada");
            }

        }

    }



    public void deposit(String iban, double amount){

        var account = findAccount(iban);
        if (account != null){

            account.deposit(amount);
            account.showInfo();

        } else {

            System.out.println("Cuenta no encontrada");
        }
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bankName, bank.bankName) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", account=" + Arrays.toString(accounts) +
                '}';
    }
}
