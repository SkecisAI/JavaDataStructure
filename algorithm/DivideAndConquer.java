package indi.algorithm;

public class DivideAndConquer {
    public static void main(String[] args) {
        hanoiTower(2, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char startTower, char assistTower, char targetTower){
        if (num == 1){
            System.out.println("第1个盘从" + startTower + "=>" + targetTower);
        }else {
            hanoiTower(num-1, startTower, targetTower, assistTower);
            System.out.println("将第"+ num +"个盘从"+ startTower +"移动到"+ targetTower);
            hanoiTower(num-1, assistTower, startTower, targetTower);
        }
    }
}
