package me.manofberkeley.ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mong on 1/11/17.
 */
public class DirectCycleDetection {
    int[] edgeTo;
    boolean[] marked;
    boolean[] onStack;
    LinkedList<Integer> cycle;
    public DirectCycleDetection(Digraph G){
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++){
            if(!marked[v]){
                dfsCycle(G, v);
            }
        }
    }

    private void dfsCycle(Digraph G, int s){
        onStack[s] = true;
        marked[s] = true;

        for(int w: G.adj(s)){
            if(this.hasCycle()) return;
            else if(!marked[w]){
                edgeTo[w] = s;
                dfsCycle(G, w);
            }
            else if(onStack[w]){
                cycle = new LinkedList<>();
                for(int x = s; x != w; x = edgeTo[x]){
                    cycle.addFirst(x);
                }
                cycle.addFirst(w);
                cycle.addFirst(s);
            }
        }
        onStack[s] = false;
    }

    public boolean hasCycle(){
        return this.cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
