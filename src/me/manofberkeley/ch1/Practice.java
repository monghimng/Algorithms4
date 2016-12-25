package me.manofberkeley.ch1;

import java.util.Scanner;

/**
 * Created by mong on 12/23/16.
 */
public class Practice {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            String expression = scan.nextLine();
            System.out.println(expression + " is " + (isValid(expression) ? "valid" : "not valid"));
        }
    }

    static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == ')' && stack.pop() != '(' ||
                    c == ']' && stack.pop() != '[' ||
                    c == '}' && stack.pop() != '{') {
                    return false;
            }
            else if(c == ''){
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
