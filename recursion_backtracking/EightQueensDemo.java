package indi.recursion_backtracking;

public class EightQueensDemo {
    public static void main(String[] args) {
        EightQueens eq = new EightQueens();
        eq.resolveProblem();
        System.out.println(eq.getAnsCount());
    }
}

// answer is 92
class EightQueens{
    int[] ansArray = new int[8];
    int ansCount = 0;

    public int getAnsCount() {
        return ansCount;
    }

    public void resolveProblem(){
        int start = 1;
        putQueue(start);
    }

    private void putQueue(int n){
        if (n > 8){
            ansCount++;
            System.out.printf("第%d个解：", ansCount);
            printAns();
        }else {
            for (int col = 0; col < 8; col++) {
                ansArray[n-1] = col;
                if (!isConflict(n)){
                    putQueue(n+1);
                }
            }
        }
    }

    private void printAns(){
        for (int item:  ansArray){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    //任意的两个皇后不在对角线上, 任意的两个皇后不能在通一列
    private boolean isConflict(int n){
        if (n == 1){
            return false;
        }
        for (int i = 0; i < n-1; i++) {
            if (ansArray[i] == ansArray[n-1] || Math.abs(n-1 - i) == Math.abs(ansArray[n-1] - ansArray[i])){
                return true;
            }
        }
        return false;
    }
}
