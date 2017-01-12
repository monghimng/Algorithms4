package me.manofberkeley.ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mong on 1/10/17.
 */
public class Digraph {
    private int V;
    private int E;
    private List<Integer>[] lst;

    public int V(){return this.V;}
    public int E(){return this.E;}

    public Digraph(int V){
        this.V = V;
        lst = (List<Integer>[])new Object[V];
        for(int i = 0; i < lst.length; i++){
            lst[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        lst[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return lst[v];
    }

    public Digraph reverse(){
        Digraph reverse = new Digraph(V);
        for(int i = 0; i < lst.length; i++){
            int k = i;
            lst[i].forEach(
                    e -> reverse.addEdge(e, k)
            );
        }
        return reverse;
    }
}
