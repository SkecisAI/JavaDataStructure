package indi.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {-2, -1, -3, 8, 12, 15, 9};
//        SelectionSort.selectionSort(arr1);

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间"+date1Str);

        SelectionSort.selectionSort(randomArr);    // 3秒左右

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间"+date2Str);
    }
}

class SelectionSort{
    public static void selectionSort(int[] arr){
        for (int count = 0; count < arr.length - 1; count++) {
            int minVal = arr[count];
            int minIndex = count;
            for (int i = count+1; i < arr.length; i++) {
                if (arr[i] < minVal){
                    minIndex = i;
                    minVal = arr[i];
                }
            }
            arr[minIndex] = arr[count];
            arr[count] = minVal;
//            System.out.println("第"+(count+1)+"趟"+Arrays.toString(arr));
        }
    }
}
