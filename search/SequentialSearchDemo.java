package indi.search;

public class SequentialSearchDemo {
    public static void main(String[] args) {
        int[] arr = {3, 5, 12, 4, 34, 12, 9};
        int sign = SequentialSearch.sequentialSearch(arr, 12);
        if(sign == -1){
            System.out.println("not found");
        }else {
            System.out.println("找到的下标："+sign);
        }
    }
}

class SequentialSearch{
    public static int sequentialSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
