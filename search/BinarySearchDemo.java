package indi.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 12, 15, 17, 27, 27, 27, 78, 88, 100, 100};
        List<Integer> resultList = BinarySearch.binarySearch(arr, 27, 0, arr.length-1);
        if (resultList.size() <= 0){
            System.out.println("not fount");
        }else {
            System.out.println("找到的下标为："+resultList);
        }
    }
}

class BinarySearch{
    public static List<Integer> binarySearch(int[] arr, int value, int left, int right){
        if (left > right){
            return new ArrayList<>();
        }
//        int mid = (left + right) / 2;
        // self-adaption mid
        int mid = (int) (left + (value - arr[left])*1.0 / (arr[right] - arr[left]) * (right - left));
        if (value < arr[mid]){
            return binarySearch(arr, value, left, mid-1);
        }else if (value > arr[mid]){
            return binarySearch(arr, value, mid+1, right);
        }else {   // find more values
            List<Integer> resList = new ArrayList<>();
            int l = mid-1, r = mid+1;
            if (l >= 0 || r < arr.length) {
                while (l >= 0 && arr[l] == value) {
                    resList.add(l--);
                }
                resList.add(mid);
                while (r < arr.length && arr[r] == value) {
                    resList.add(r++);
                }
            }
            return resList;
        }
    }
}
