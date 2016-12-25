package me.manofberkeley.ch2;

import java.util.Comparator;

public class Sort {

    public static void main(String[] args) {
        Comparable[] lst = new Integer[]{3,51,54,6481,6,4,68,1,68,6851,658,
                498,41,689,64,61,687,4,1,1,21,1,2,1,6987,9,0,0,2,1,6,-658684-1,5,65-651,-4665,-6514};
//        lst = new Integer[10000];
//        for(int k = 0; k < lst.length; k++){
//            lst[k] = (int)Math.random()*100 - 50;
//        }
//        lst = new Integer[]{3,-1,0};
//        lst = insertionSort(lst);
        lst = shellSort(lst);
        printLst(lst);
    }

    public static Comparable[] shellSort(Comparable[] lst){
        int N = lst.length;
        int h = 1;
        while(h < N) h = 3 * h + 1;
        while(h >= 1) {
            for (int cur = h; cur < N; cur++) {
                for (int pre = cur; pre - h >= 0 && lst[pre].compareTo(lst[pre - h]) < 0; pre -= h) {
                    Comparable temp = lst[pre - h];
                    lst[pre - h] = lst[pre];
                    lst[pre] = temp;
                }
            }
            h /= 3;
        }
        return lst;
    }

    public static Comparable[] insertionSort(Comparable[] lst){
        for(int cur = 0; cur < lst.length; cur++){
            for(int i = cur; i > 0 && lst[i].compareTo(lst[i-1]) < 0; i--){
                Comparable temp = lst[i];
                lst[i] = lst[i-1];
                lst[i-1] = temp;
            }
        }
        return lst;
    }

    static Comparable[] selectionSort(Comparable[] lst){
        for(int cur = 0; cur < lst.length; cur++){
            int min = cur;
            for(int i = cur; i < lst.length; i++){
                if(lst[i].compareTo(lst[min]) < 0){
                    min = i;
                }
            }
            Comparable temp = lst[cur];
            lst[cur] = lst[min];
            lst[min] = temp;
        }
        return lst;
    }

    public static void printLst(Comparable[] lst){
        System.out.println();
        for (Comparable c : lst) {
            System.out.print(c.toString() + " ");
        }
    }
}
