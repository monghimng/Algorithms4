package me.manofberkeley.ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mong on 1/6/17.
 */
public class Graph {
    private final int V;
    private int E;
    List<Integer>[] edgeTo;

    public Graph(int V){
        this.V = V;
        this.edgeTo = (List<Integer>[])new Object[V];
        for(int i = 0; i < V; i++){
            edgeTo[i] = new LinkedList<>();
        }
    }

    public int V(){return V;}
    public int E(){return E;}

    public void addEdge(int v, int w){
        edgeTo[v].add(w);
        edgeTo[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return edgeTo[v];
    }

}
