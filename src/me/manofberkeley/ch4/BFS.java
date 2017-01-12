package me.manofberkeley.ch4;

import java.util.Queue;

import java.util.LinkedList;

/**
 * Created by mong on 1/6/17.
 */
public class BFS {
    Queue<Integer> q = new LinkedList<>();
    boolean[] marked;
    int[] edgeTo;
    private int s;
    public BFS(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        LinkedList<Integer> lst = new LinkedList<>();
        while(v != this.s){
            lst.addFirst(v);
            v = edgeTo[v];
        }
        lst.addFirst(s);
        return lst;
    }

    private void bfs(Graph G, int s){
        q.add(s);
        while(!q.isEmpty()){
            int curr = q.remove();
            marked[curr] = true;
            for(Integer v: G.adj(curr)){
                if(!marked[v]){
                    q.add(v);
                    edgeTo[v] = curr;
                }
            }
        }
    }
}
