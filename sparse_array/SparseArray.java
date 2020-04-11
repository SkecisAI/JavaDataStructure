package indi.sparse_array;

public class SparseArray {
    int index;
    int row;
    int col;
    int value;

    public SparseArray(int index_, int row_, int col_, int value_) {
        index = index_;
        row = row_;
        col = col_;
        value = value_;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public void printSelf() {
        System.out.println(index + "\t" + row + "\t" + col + "\t" + value);
    }

    public static int getItemCount(int[][] arr) {
        int count = 0;
        for (int[] row : arr) {
            for (int item : row) {
                if (item != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void toSparseArray(int[][] arr, SparseArray[] sa) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sa[count] = new SparseArray(count, i, j, arr[i][j]);
                }
            }
        }
    }

    public static void peekSparseArray(SparseArray[] sa){
        System.out.println("稀疏数组：");
        for (SparseArray s: sa){
            s.printSelf();
        }
    }

    public static void peekArr(int[][] arr){
        System.out.println("原始数组：");
        for (int [] row: arr) {
            for (int item: row){
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    public static int[][] toArray(SparseArray[] sa){
        int rowCount = sa[0].getRow();
        int colCount = sa[0].getCol();
        int itemCount = sa[0].getValue();
        int[][] newArr = new int[rowCount][colCount];
        for (int i = 1; i <= itemCount; i++) {
            newArr[sa[i].getRow()][sa[i].getCol()] = sa[i].getValue();
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[][] myArr = new int[10][10];
        myArr[1][4] = 1;
        myArr[2][5] = 2;
        myArr[2][8] = 1;
        myArr[9][1] = 2;
        int itemCount = getItemCount(myArr);
        SparseArray[] mySparseArr = new SparseArray[itemCount + 1];
        mySparseArr[0] = new SparseArray(0, 10, 10, itemCount);
        peekArr(myArr);
        toSparseArray(myArr, mySparseArr);
        peekSparseArray(mySparseArr);
        int[][] newArr = toArray(mySparseArr);
        peekArr(newArr);
    }
}
