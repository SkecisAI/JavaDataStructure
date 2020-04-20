package indi.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSortDemo {
    public static void main(String[] args) {
//        int[] arr1 = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] temp = new int[arr1.length];
//        MergeSort.mergeSort(arr1, 0, arr1.length-1, temp);
//        System.out.println(Arrays.toString(arr1));

        int[] randomArr = new int[80000];
        int[] tempRand = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间-"+date1Str);

        MergeSort.mergeSort(randomArr, 0, randomArr.length-1, tempRand);    // <1秒

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间-"+date2Str);
    }
}

class MergeSort{
    public static void mergeSort(int[] arr, int l, int r, int[] temp){
        if (l < r){
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid, temp);
            mergeSort(arr, mid+1, r, temp);
            merge(arr, temp, l, mid, r);
        }
    }

    public static void merge(int[] arr, int[] sorted, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 1. move
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                sorted[k] = arr[i];
                i++;
            }else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }
        // 2. merge
        if (i<=mid){
            while (i<=mid){
                sorted[k++] = arr[i++];
            }
        }
        if (j<=right){
            while (j<=right){
                sorted[k++] = arr[j++];
            }
        }
        // 3. copy
        int ind = left;
        int t = 0;
        while (ind <= right){
            arr[ind++] = sorted[t++];
        }
    }
}