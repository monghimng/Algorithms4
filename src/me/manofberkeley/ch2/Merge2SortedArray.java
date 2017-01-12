package me.manofberkeley.ch2;

import java.util.Arrays;

/**
 * Created by mong on 1/3/17.
 */
public class Merge2SortedArray {
    public static void main(String[] args){
        int[] a = {1, 3, 5, 9, 13, 15, 0, 0, 0, 0};
        int[] b = {2, 9, 50, 100};
        sort(a, b);
        Arrays.stream(a).forEach(e -> System.out.println(" " + e));
    }

    public static void sort(int[] a, int[] b){
        int end = a.length - 1;
        int aend = end - b.length;
        int bend = b.length - 1;

        while(end >= 0){
            if(aend < 0) a[end] = b[bend--];
            else if(bend < 0) a[end] = a[aend--];
            else if(a[aend] < b[bend]){
                a[end] = b[bend--];
            }
            else{
                a[end] = a[aend--];
            }
            end--;
        }
    }
}
