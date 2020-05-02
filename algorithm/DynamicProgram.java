package indi.algorithm;

public class DynamicProgram {
    public static void main(String[] args) {
     int[] value = {1500, 3000, 2000};
     int[] weight = {1, 4, 3};
     int bagSize = 4;
     KnapsackProblem bagProblem = new KnapsackProblem(value, weight);
        System.out.println(bagProblem.resolve(bagSize));
    }
}

class KnapsackProblem {
    int[] value;
    int[] weight;

    public KnapsackProblem(int[] value, int[] weight) {
        this.value = value;
        this.weight = weight;
    }

    public int resolve(int size){
        // 1. recursion method
//        return getForm(weight.length, size);
        // 2. non-recursion method
        int[][] form = new int[weight.length+1][size+1];
        int[][] path = new int[weight.length+1][size+1];
        for (int i = 1; i <= weight.length; i++) {
            for (int bagWeight = 1; bagWeight <= size; bagWeight++) {
                if (weight[i-1] > bagWeight){
                    form[i][bagWeight] = form[i-1][bagWeight];
                }else {
//                    form[i][bagWeight] = Math.max(form[i - 1][bagWeight], value[i - 1] + form[i - 1][bagWeight - weight[i - 1]]);
                    if (value[i-1] + form[i-1][bagWeight - weight[i-1]] > form[i-1][bagWeight]){
                        path[i][bagWeight] = 1;
                        form[i][bagWeight] = value[i-1] + form[i-1][bagWeight - weight[i-1]];
                    }else {
                        path[i][bagWeight] = 0;
                        form[i][bagWeight] = form[i - 1][bagWeight];
                    }
                }
            }
        }
        printArray(form);

        // get the detail
        int i = weight.length;
        int j = size;
        while (i >= 0 && j >= 0){
            if (path[i][j] == 1){
                System.out.printf("放入第 %d 个物品\n", i);
                j -= weight[i-1];
            }
            i--;
        }
        return form[weight.length][size];
    }

    public int getForm(int i, int bagWeight){
        if (i == 0 || bagWeight == 0) {
            return 0;
        }else {
            if (weight[i-1] > bagWeight){
                return getForm(i-1, bagWeight);
            }else {
                return Math.max(getForm(i-1, bagWeight), value[i-1] + getForm(i-1, bagWeight-weight[i-1]));
            }
        }
    }

    public void printArray(int[][] arr){
        for (int[] row: arr){
            for (int col: row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}

class TwoEggsProblem{

}