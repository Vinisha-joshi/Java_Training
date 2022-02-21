package Assignment1;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class Question8 {

    public static void main(String args[])
    {
        String s1 = "vini";
        String s2 = "nivi";
        if (areAnagram(s1, s2))
            System.out.println("strings are anagram ");
        else
            System.out.println("The two strings are not anagram ");
    }
    static boolean areAnagram(String s1,String s2)
    {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int n1 = str1.length;
        int n2 = str2.length;
        if (n1 != n2)
            return false;
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;
        return true;
    }
}