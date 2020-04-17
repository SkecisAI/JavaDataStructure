package indi.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {-2, -1, -3, 8, 12, 15, 9};
//        InsertionSort.insertionSort(arr1);

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间"+date1Str);

        InsertionSort.insertionSort(randomArr);    // 1秒左右

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间"+date2Str);
    }
}

class InsertionSort{
    public static void insertionSort(int[] arr){
        for (int count = 1; count < arr.length; count++) {
            int insertVal = arr[count];
            int insertIndex = count-1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=count){
                arr[insertIndex+1] = insertVal;
            }
//            System.out.println("第"+count+"轮排序"+Arrays.toString(arr));
        }
    }
}