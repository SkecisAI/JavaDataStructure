package indi.sorting;

//import java.text.SimpleDateFormat;
import java.util.Arrays;
//import java.util.Date;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {-2, -1, 3, 8, 12, 15, 9};
        int[] arr2 = {-2, -1, 3, 8, 12, 15, 9};
//        int[] randomArr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            randomArr[i] = (int)(Math.random()*800000);
//        }

        BubbleSort.bubbleSort(arr1);
        BubbleSort.optimizedBubbleSort(arr2);
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//        String date1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间"+date1Str);
//
//        BubbleSort.optimizedBubbleSort(randomArr);  // 13秒左右
//
//        Date date2 = new Date();
//        String date2Str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间"+date2Str);
    }
}

class BubbleSort{
    public static void bubbleSort(int[] arr){
        int tmp;
        for (int count = 0; count < arr.length - 1; count++) {
            for (int i = 0; i < arr.length - 1 - count; i++) {
                if (arr[i] > arr[i+1]){
                    tmp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;
                }
            }
            System.out.println("第"+(count+1)+"趟"+Arrays.toString(arr));
        }
    }

    public static void optimizedBubbleSort(int[] arr){
        int tmp;
        boolean isSorted;
        for (int count = 0; count < arr.length - 1; count++) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1 - count; i++) {
                if (arr[i] > arr[i+1]){
                    isSorted = false;
                    tmp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;
                }
            }
            System.out.println("第"+(count+1)+"趟"+Arrays.toString(arr));
            if (isSorted){
                break;
            }
        }
    }
}
