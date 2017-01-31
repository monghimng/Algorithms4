package me.manofberkeley.ch4;

import java.util.Comparator;

/**
 * Created by mong on 1/15/17.
 */
public class Edge implements Comparable<Edge>{
    private int v, w;
    private double weight;
    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return this.weight;
    }

    public int either(){
        return v;
    }

    public int other(int other){
        if(other == v) return w;
        else if(other == w) return v;
        else throw new RuntimeException();
    }

    public int compareTo(Edge other){
        if(this.weight() == other.weight) return 0;
        else if(this.weight() > other.weight) return 1;
        else return -1;
    }
}
