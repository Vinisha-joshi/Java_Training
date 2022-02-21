package Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter Numbers of list: ");
        for(int i=0;i<5;i++)
        {
            int x=sc.nextInt();
            list.add(x);
        }
        int k=3;
        getTopKMax(list,k);
    }
    public static void getTopKMax(ArrayList<Integer> list,int k)
    {
        Collections.sort(list, Collections.reverseOrder());
        System.out.print("Maximum upto "+k+" : ");
        for(int i=0;i<k;i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
