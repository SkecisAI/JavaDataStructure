package indi.binary_tree;

public class SeqBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        SeqBinaryTree seqBinaryTree = new SeqBinaryTree(arr);
        seqBinaryTree.preOrder();  // 1, 2, 4, 5, 3, 6, 7
    }
}

class SeqBinaryTree{
    private final int[] arr;

    public SeqBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能遍历");
            return;
        }
        System.out.print(arr[index]+" ");
        if (index*2 + 1 < arr.length){
            preOrder(2 * index + 1);
        }
        if (index*2 + 2 < arr.length){
            preOrder(2 *index + 2);
        }
    }
}
