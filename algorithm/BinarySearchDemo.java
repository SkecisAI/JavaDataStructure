package indi.algorithm;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = BinarySearch.binarySearch(arr, 1);
        if (index != -1){
            System.out.println("found index: "+index);
        }else {
            System.out.println("not found");
        }
    }
}

class BinarySearch{
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (target < arr[mid]){
                right = mid - 1;
            }else if(target > arr[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
}
