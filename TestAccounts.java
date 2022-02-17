package Homework;

import java.util.Scanner;
public class TestAccounts
{
    public static void main(String[] args)
    {
        Account testAcct;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many accounts would you like to create?"); int num =
            scan.nextInt();
        for (int i=1; i<=num; i++)
        {
            testAcct = new Account(100, "Name" + i);
            System.out.println("\nCreated account " + testAcct);
            // Your code here: call method to print out how many accounts have been created so far
        }
        System.out.println("Total number of accounts: " + Account.getNumAccounts());

        Account account = new Account(1000,"Vinisha");
        System.out.println("Total number of accounts: " + Account.getNumAccounts());
        System.out.println(account);
        account.close();
        System.out.println("Total number of accounts after deleting account: " + Account.getNumAccounts());
        System.out.println("\nCreated account " + account);
        
        //Consolidate
        Account account1=new Account(5000,"Vini");
        Account account2=new Account(5000,"Vini");
        Account.consolidate(account1,account2);
        System.out.println(Account.getNumAccounts());
        System.out.println(account1);
        System.out.println(account2);





    }
}
