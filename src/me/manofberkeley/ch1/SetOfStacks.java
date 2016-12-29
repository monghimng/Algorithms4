package me.manofberkeley.ch1;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by MOng on 12/26/2016.
 */
public class SetOfStacks<T> {
    List<Stack> lstOfStacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
        lstOfStacks.add(new Stack());
    }
    void push (T data){
        Stack TopStack = lstOfStacks.get(lstOfStacks.size() - 1);
        if(TopStack.size() >= capacity){
            Stack newStack = new Stack();
            newStack.push(data);
            lstOfStacks.add(newStack);
        }
        else{
            TopStack.push(data);
        }
    }

    T pop(){
        Stack TopStack = lstOfStacks.get(lstOfStacks.size() - 1);
        if(TopStack.isEmpty()){
            if(lstOfStacks.size() == 1){
                throw new EmptyStackException();
            }
            else{
                lstOfStacks.remove(lstOfStacks.size()-1);
                pop();
            }
        }
        return TopStack.pop();
    }

    T popAt(int index){
        return lstOfStacks.get(index).pop();
    }
    class Stack{
        Node head;
        int n;
        void push(T data){
            Node newHead = new Node();
            newHead.data = data;
            newHead.next = head;
            head = newHead;
            n++;
        }

        T pop(){
            if(isEmpty()) throw new EmptyStackException();
            T data = head.data;
            head = head.next;
            n--;
            return data;
        }

        boolean isEmpty(){
            return head == null;
        }

        int size(){
            return n;
        }
    }

    class Node{
        T data;
        Node next;
    }
}
