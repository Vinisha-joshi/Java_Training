package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter Numbers of list: ");
        for(int i=0;i<5;i++)
        {
            int x=sc.nextInt();
            list.add(x);
        }
        removeNegative(list);

    }
    public static void removeNegative(ArrayList<Integer> list)
    {
        ArrayList<Integer> newList=new ArrayList<Integer>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>0)
            {
                newList.add(list.get(i));
            }
        }
        list=newList;
        System.out.println("After Removing Negative List Become: ");
        for(int i=0;i< list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
