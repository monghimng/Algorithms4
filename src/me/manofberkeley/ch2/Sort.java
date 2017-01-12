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
//        lst = shellSort(lst);
//        buffer = new Integer[lst.length]; lst = topDownMergeSort(lst, 0, lst.length);
//        lst = bottomUpMergeSort(lst);

        lst = quickSort(lst, 0, lst.length);
        printLst(lst);
    }

    public static Comparable[] quickSort(Comparable[] lst, int low, int high){
        if(high - low > 2){
            int mid = partition(lst, low, high);
            quickSort(lst, low, mid);
            quickSort(lst, mid+1, high);
        }
        return lst;
    }

    public static int partition(Comparable[] lst, int low, int high){
        Comparable pivot = lst[low];
        int i = low, j = high;
        while(true){
            while(lst[++i].compareTo(pivot) <= 0) if(i == high - 1) break;
            while(lst[--j].compareTo(pivot) >= 0) if(j == low) break;
            if(i >= j) break;
            Comparable temp = lst[i];
            lst[i] = lst[j];
            lst[j] = temp;
        }
        lst[low] = lst[j];
        lst[j] = pivot;
        return j;
    }

    public static Comparable[] buffer;

    public static Comparable[] bottomUpMergeSort(Comparable[] lst){
        buffer = new Comparable[lst.length];
        for(int pow2 = 1; pow2 < lst.length; pow2 *= 2){
            for(int i = 0; i + pow2 < lst.length; i += 2 * pow2){
                merge(lst, i, i + pow2, Math.min(i + 2 * pow2, lst.length));
            }
        }
        return lst;
    }

    public static Comparable[] topDownMergeSort(Comparable[] lst, int low, int high) {
        //high is exclusive
        int mid = (high + low) / 2;
        if(high - low > 2) {
            topDownMergeSort(lst, low, mid);
            topDownMergeSort(lst, mid, high);
        }
        merge(lst, low, mid, high);
        return lst;
    }

    public static void merge(Comparable[] lst, int low, int mid, int high){
        //high inclusive
        for(int i = low; i < high; i++) {
            buffer[i] = lst[i];
        }
        int first = low;
        int second = mid;
        for(int i = low; i < high; i++){
            if(first >= mid) lst[i] = buffer[second++];
            else if(second >= high) lst[i] = buffer[first++];
            else if(buffer[first].compareTo(buffer[second]) <= 0){
                lst[i] = buffer[first++];
            }
            else{
                lst[i] = buffer[second++];
            }
        }
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
