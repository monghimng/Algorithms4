package me.manofberkeley.ch1;

import java.util.Iterator;

/**
 * Created by mong on 12/23/16.
 */
public class Stack<T> implements Iterable<T>{

    public static void main(String[] args){
        Stack<Number> s = new Stack<>();
        s.push(5);
        s.push(6.44546);
        System.out.println(s.pop());
        s.push(564.654 - 345);
        System.out.println(s.pop());
        System.out.println(s.pop());
        for(int i = 0; i < 100; i++){
            double num = Math.random() * 100 - 50;
            s.push(num);
            if(num < -30 || num > 20){
                System.out.println(s.pop());
            }
        }
        for(Number n: s){
            System.out.println("mhb" + n);
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            Node iterNode = head;
            @Override
            public boolean hasNext() {
                return iterNode != null;
            }

            @Override
            public T next() {
                T data = iterNode.data;
                iterNode = iterNode.next;
                return data;
            }
        };
    }

    private class Node{
        T data;
        Node next;
    }

    private Node head;
    private int n;

    public void push(T item){
        Node oldHead = head;
        head = new Node();
        head.data = item;
        head.next = oldHead;
        n++;
    }

    public T peek(){
        return head.data;
    }

    public T pop(){
        T poped = head.data;
        head = head.next;
        n--;
        return poped;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }
}
