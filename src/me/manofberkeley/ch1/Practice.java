package me.manofberkeley.ch1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mong on 12/23/16.
 */
public class Practice {
    public static void main(String[] args){
        int[] a = new int[5];
        //a = {1,2,3};
        int[] b = {1,2,3, 4};
        b = new int[]{1, 2, 3};
        Object o = b;
        Number[] i = {112,2,3};
        Integer[] c = Arrays.copyOf(i, i.length, Integer[].class);
        Integer[] d = (Integer[])i;
        List<Integer> lst = Arrays.asList(c);
        boolean bbb = c.equals(d);


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
            else if(c == ' '){
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
