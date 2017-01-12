package me.manofberkeley.ch4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by mong on 1/11/17.
 */
public class Topological {
    boolean[] marked;
    boolean[] onStack;
    Stack<Integer> stack;

    public Topological(Digraph G, int s){
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        stack = new Stack<>();
    }

    private void dfsPostReverse(Digraph G, int s){
        onStack[s] = true;
        marked[s] = true;
        for(int v: G.adj(s)){
            if(stack == null){
                return;
            }
            else if(!marked[v]){
                dfsPostReverse(G, v);
            }
            else if(onStack[s]){
                stack = null;
            }
        }
        stack.push(s);
        onStack[s] = false;
    }

    public boolean isDAG(){
        return stack != null;
    }

    public Iterable<Integer> order(){
        return stack;
    }
}
