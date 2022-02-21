package Assignment1;

import java.util.Scanner;
import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter String : ");
            String string = sc.nextLine();
            System.out.println(validParentheses(string));


    }
    public static boolean validParentheses(String s){
        if (!s.isEmpty()) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char character = s.charAt(i);
                if (character == '(' || character == '[' || character == '{') {
                    stack.push(character);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char charPeek = stack.peek();
                    if ((character == ')' && charPeek != '(') || (character == '}' && charPeek != '{') || (character == ']' && charPeek != '[')) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
