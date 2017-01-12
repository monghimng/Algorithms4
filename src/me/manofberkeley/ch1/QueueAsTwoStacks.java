package me.manofberkeley.ch1;

import java.util.EmptyStackException;

/**
 * Created by MOng on 12/26/2016.
 */
public class QueueAsTwoStacks<T> {
    Stack<T> pushStack = new Stack<>();
    Stack<T> popStack = new Stack<>();

    void enqueue(T data){
        pushStack.push(data);
    }

    T dequeue(){
        if(popStack.isEmpty()){
            if(pushStack.isEmpty()){
                throw new EmptyStackException();
            }
            else{
                shiftElements();
            }
        }
        return popStack.pop();
    }

    void shiftElements(){
        assert popStack.isEmpty();
        while(!pushStack.isEmpty()){
            T data = pushStack.pop();
            popStack.push(data);
        }
    }
}
