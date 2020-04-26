package indi.binary_tree;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSortDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 6, 8, 5, 9};
//        HeapSort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间"+date1Str);

        HeapSort.heapSort(randomArr);    // <1秒

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间"+date2Str);
    }
}

class HeapSort{
    public static void heapSort(int[] arr){
        for (int i = (arr.length-1) / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length-1);
        }
        int temp;
        for (int i = arr.length-1; i >= 0; i--){
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapAdjust(arr, 0, i-1);
        }
    }

    public static void heapAdjust(int[] arr, int nonLeafNodeIndex, int len){
        int nonLeafNode = arr[nonLeafNodeIndex];
        for (int childIndex = 2*nonLeafNodeIndex+1; childIndex <= len; childIndex = 2*childIndex+1){
            if (childIndex < len && arr[childIndex] < arr[childIndex + 1]){
                ++childIndex;
            }
            if (nonLeafNode < arr[childIndex]){   // 没有成堆
                arr[nonLeafNodeIndex] = arr[childIndex];
                nonLeafNodeIndex = childIndex;
            }else {                               // 已经成堆
                break;
            }
        }
        arr[nonLeafNodeIndex] = nonLeafNode;
    }
}