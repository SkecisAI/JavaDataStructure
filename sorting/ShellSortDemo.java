package indi.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, 12, 32, 11, 3, 7, 9, 0};
        int[] arr2 = {4, 1, 2, 12, 32, 11, 3, 7, 9, 0};
        ShellSort.shellSortByExchange(arr1);
        ShellSort.shellSortByMove(arr2);

//        int[] randomArr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            randomArr[i] = (int)(Math.random()*800000);
//        }
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        String date1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间"+date1Str);
//
//        ShellSort.shellSortByExchange(randomArr);    // 7-9秒左右
//        ShellSort.shellSortByMove(randomArr);        // <1秒
//        Date date2 = new Date();
//        String date2Str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间"+date2Str);
    }
}

class ShellSort{
    public static void shellSortByExchange(int[] arr){
        int groupGap = arr.length / 2;
        int tmp;
        while (groupGap > 0) {
            for (int i = groupGap; i < arr.length; i++) {
                for (int j = i - groupGap; j >= 0; j -= groupGap) {
                    if (arr[j] > arr[j + groupGap]) {
                        tmp = arr[j + groupGap];
                        arr[j + groupGap] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
            groupGap = groupGap / 2;
        }
    }

    public static void shellSortByMove(int[] arr){
        int groupGap = arr.length / 2;
        while (groupGap > 0) {
            for (int i = groupGap; i < arr.length; i++) {
                int insertIndex = i;
                int insertValue = arr[insertIndex];
                if (arr[insertIndex] < arr[insertIndex - groupGap]){
                    while (insertIndex - groupGap >= 0 && insertValue < arr[insertIndex - groupGap]){
                        arr[insertIndex] = arr[insertIndex - groupGap];
                        insertIndex -= groupGap;
                    }
                    arr[insertIndex] = insertValue;
                }
            }
//            System.out.println(Arrays.toString(arr));
            groupGap = groupGap / 2;
        }
    }
}
