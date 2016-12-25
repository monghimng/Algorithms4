package me.manofberkeley.ch1;

import java.util.Iterator;

/**
 * Created by mong on 12/23/16.
 */
public class Queue<T> implements Iterable<T> {

    public static void main(String[] args){
        Queue<Number> q = new Queue<>();
        q.enqueue(54);
        System.out.println(q.dequeue());
        q.enqueue(654653563);
        q.enqueue(654653563);
        q.enqueue(654653563);
        q.enqueue(654653563);
        q.enqueue(555);
        for(Number n: q){
            System.out.println(n);
        }

    }
    @Override
    public Iterator<T> iterator() {
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
    private Node end;
    private int n;
    public void enqueue(T item){
        Node oldEnd = end;
        end = new Node();
        end.data = item;
        if(isEmpty()) head = end;
        else oldEnd.next = end;
        n++;
    }

    public T dequeue(){
        T data = head.data;
        head = head.next;
        if(isEmpty()) end = null;
        n--;
        return data;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
