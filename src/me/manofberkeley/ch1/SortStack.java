package me.manofberkeley.ch1;

/**
 * Created by MOng on 12/26/2016.
 */
public class SortStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(435);
        stack.push(5);
        stack.push(654654);
        stack.push(-654);
        stack.push(0);
        stack.push(5);
        stack.push(Integer.MAX_VALUE);

        Stack<Integer> sorted = new Stack<>();
        while(!stack.isEmpty()){
            int n = 0;
            Integer cur = stack.pop();
            while(!sorted.isEmpty() && sorted.peek().compareTo(cur) >= 0){
                stack.push(sorted.pop());
                n++;
            }
            sorted.push(cur);
            for(int i = 0; i < n; i++){
                sorted.push(stack.pop());
            }
        }

        //finishing blow
        while(!sorted.isEmpty()){
            stack.push(sorted.pop());
        }

        for(Integer i: stack){
            System.out.println(i);
        }

    }
}
