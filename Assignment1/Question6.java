package Assignment1;

import java.util.Arrays;
import java.util.List;

public class Question6 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(12,2,5,7,8,5);
        numberList.stream().filter(n -> n%2 == 0).forEach(System.out::println);
    }
}
