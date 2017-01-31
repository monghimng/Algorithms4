package me.manofberkeley.ch4;

import java.util.*;

/**
 * Created by mong on 1/15/17.
 */
public class LazyPrimMST {
    private boolean[] marked;
    private List<Edge> mst;
    private PriorityQueue<Edge> pq;
    public LazyPrimMST(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        mst = new ArrayList<>();
        pq = new PriorityQueue<>();
        visit(G, 0);
        while(!pq.isEmpty()){
            Edge e = pq.remove();
            int v = e.either(), w = e.other(v);
            if(marked[v] && marked[w])continue;
            mst.add(e);
            if(marked[v]) visit(G, w);
            else visit(G, v);
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e: G.adj(v)){
            if(!marked[e.other(v)]){
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges(){return mst;}

    public double weight(){ return mst.stream().mapToDouble(Edge::weight).sum();}
}
