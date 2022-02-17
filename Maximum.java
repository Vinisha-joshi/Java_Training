package Day4;

import java.util.ArrayList;
import java.util.Collections;


public class Maximum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(20);
        list.add(13);
        list.add(6);
        list.add(60);
        System.out.print("Array list: ");
        for(Integer i :list)
        {
            System.out.print(i+" ");
        }
        System.out.println("");
        FirstMax(list);
        SecondMax(list);
        int k=3;
        MaxTillK(list,k);
    }
    public static void FirstMax(ArrayList<Integer> list)
    {
        System.out.println("First Max : "+Collections.max(list));
    }
    public static void SecondMax(ArrayList<Integer> list)
    {
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Second Max: "+list.get(1));
    }
    public static void MaxTillK(ArrayList<Integer> list,int k)
    {
        Collections.sort(list, Collections.reverseOrder());
        System.out.print("Maximum upto "+k+" : ");
        for(int i=0;i<k;i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }

}
