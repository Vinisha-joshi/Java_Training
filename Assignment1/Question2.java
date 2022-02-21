package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter Numbers of list: ");
        for (int i = 0; i < 5; i++) {
            int x = sc.nextInt();
            list.add(x);
        }
        int sum;
        System.out.print("Enter Sum : ");
        sum = sc.nextInt();
        System.out.println(findIsSum(list, sum));
    }

    public static boolean findIsSum(ArrayList<Integer> list, int sum) {
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            int add = 0;
            for (int j = i + 1; j < list.size(); j++) {
                add = list.get(i) + list.get(j);
                if (add == sum) {
                    System.out.println(list.get(i) + " + " + list.get(j) + " = " + sum);
                    flag = 1;
                    return true;
                }

            }
            if (flag == 0) {
                return false;
            }
        }
        return false;
    }
}