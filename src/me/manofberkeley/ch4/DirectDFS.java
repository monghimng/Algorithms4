package me.manofberkeley.ch4;

/**
 * Created by mong on 1/10/17.
 */
public class DirectDFS {

    private boolean[] marked;
    public DirectDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int i: sources){
            dfs(G, i);
        }
    }

    private void dfs(Digraph G, int s){
        marked[s] = true;
        for(int v: G.adj(s)){
            if(!marked(v)){
                dfs(G, v);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }
}
