package indi.search;

import java.util.Arrays;

public class FibonacciSearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 12, 15, 17, 20, 21, 27, 70, 88, 100};
        System.out.println(FibSearch.fibSearch(arr, 100));
    }
}

class FibSearch {
    public static int fibSearch(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        int index = 0;
        int mid;
        while (high > fibFunc(index)-1){
            index++;
        }

        int[] expandArr = new int[fibFunc(index)];
        for (int i = 0; i < expandArr.length; i++) {
            if (i < arr.length){
                expandArr[i] = arr[i];
            }else {
                expandArr[i] = arr[high];
            }
        }

        while (low <= high){
            mid = low + fibFunc(index-1) - 1;
            if (value < expandArr[mid]){
                high = mid - 1;
                index--;
            }else if (value > expandArr[mid]){
                low = mid + 1;
                index -= 2;
            }else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }

    public static int fibFunc(int n){
        if (n == 0 || n == 1){
            return 1;
        }else {
            int fn_1 = 1;
            int fn_2 = 1;
            int fn = 0;
            int count = 2;
            while (count++ <= n){
                fn = fn_1 + fn_2;
                fn_2 = fn_1;
                fn_1 = fn;
            }
            return fn;
        }
    }
}
