package me.manofberkeley.ch4;

/**
 * Created by mong on 1/6/17.
 */
public class DFS {
    boolean[] marked;
    int count;
    public DFS(Graph g, int s){
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int s){
        marked[s] = true;
        for(Integer v: g.adj(s)){
            if(!marked[v]){
                count++;
                dfs(g, v);
            }
        }
    }


    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
