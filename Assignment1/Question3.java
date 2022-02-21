package Assignment1;

import java.util.Scanner;

public class Question3 {
    static int n1=0,n2=1,n3;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter no for series: ");
        n=sc.nextInt();
        System.out.println("Iterative");
        Fibonacci(n);
        System.out.println();
        System.out.println("Recursive");
        System.out.print(n2);
        RecurrsiveFibonnaci(n);
    }
    public static void Fibonacci(int n)
    {
        int n1=0,n2=1,n3;
        System.out.print(n2+" ");
        for(int i=0;i<n;i++)
        {
            n3=n1+n2;
            n1=n2;
            n2=n3;
            System.out.print(n3+" ");
        }
    }
    public static void RecurrsiveFibonnaci(int n)
    {
        if(n>0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            RecurrsiveFibonnaci(n-1);
        }
    }
}
