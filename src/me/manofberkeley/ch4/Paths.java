package me.manofberkeley.ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mong on 1/6/17.
 */
public class Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public Paths(Graph g, int s){
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int s){
        marked[s] = true;
        for(Integer v: g.adj(s)) {
            if (!marked[v]) {
                edgeTo[v] = s;
                dfs(g, v);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> PathTo(int v){
        if(!hasPathTo(v)) return null;
        LinkedList<Integer> path = new LinkedList<>();
        while(v != this.s){
            path.addFirst(v);
            v = edgeTo[v];
        }
        path.add(s);
        return path;
    }
}
