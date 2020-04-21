package indi.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSortDemo {
    public static void main(String[] args) {
//        int[] arr1 = {53, 3, 542, 748, 14, 214};
//        RadixSort.radixSort(arr1);
//        System.out.println(Arrays.toString(arr1));

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间"+date1Str);

        RadixSort.radixSort(randomArr);    // <1秒

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间"+date2Str);
    }
}

class RadixSort{
    public static void radixSort(int[] arr){
        int[][] bucket = new int[10][arr.length];
        int[] bucketElemCount = new int[10];

        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }
        int maxLength = (max+"").length();
        for (int count = 0, n = 1; count < maxLength; count++, n*=10) {
            for (int value : arr) {
                int digit = (value / n) % 10;
                bucket[digit][bucketElemCount[digit]] = value;
                bucketElemCount[digit]++;
            }
            int index = 0;
            for (int i = 0; i < bucketElemCount.length; i++) {
                if (bucketElemCount[i] != 0) {
                    for (int j = 0; j < bucketElemCount[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                    bucketElemCount[i] = 0;  // reset
                }
            }
        }
    }
}
