package indi.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {3,3,3,3,3,2,3,3,3,3,3};
//        QuickSort.quickSort(arr1, 0, arr1.length-1);

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间"+date1Str);

        QuickSort.quickSort(randomArr, 0, randomArr.length-1);    // <1秒

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间"+date2Str);
    }
}

class QuickSort{
    public static void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[left];
        while (l < r){
            while (l < r && arr[r] >= pivot){
                --r;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot){
                ++l;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        quickSort(arr, left, l-1);
        quickSort(arr, l+1, right);
    }
}
