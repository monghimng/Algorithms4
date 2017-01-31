package me.manofberkeley.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mong on 1/15/17.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private List<Edge>[] adj;
    public EdgeWeightedGraph(int V){
        this.V = V;
        adj = (List<Edge>[])new Object[V];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V(){return V;}
    public int E(){return E;}
    public Iterable<Edge> adj(int v){return adj[v];}
    public Iterable<Edge> edges(){
        List<Edge> lst = new ArrayList<>(E);
        for(int i = 0; i < V; i++){
            for(Edge e: adj[i]){
                if(i > e.either()){
                    lst.add(e);
                }
            }
        }
        return lst;
    }

}
