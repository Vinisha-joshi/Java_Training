package Assignment1;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of row ");
        int row=sc.nextInt();
        System.out.println("Enter no of col ");
        int col=sc.nextInt();
        int arr[][]=new int[row][col];
        System.out.println("enter elements");
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                arr[i][j]= sc.nextInt();

        System.out.println(Isvalid(row,col,arr));

    }
    public static boolean Isvalid(int row,int col,int arr[][])
    {
        int arr1[][]=new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                arr1[i][j]= arr[j][i];


        for (int i=0;i<col;i++)
            for (int j=0;j<row;j++)
                if (arr1[i][j] != arr[i][j])
                    return false;
        return true;
    }
}
