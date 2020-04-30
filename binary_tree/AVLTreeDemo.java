package indi.binary_tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        for (int e: arr){
            balancedBinaryTree.add(new AVLNode(e));
        }
        balancedBinaryTree.infixOrder();
        System.out.println("树高度："+balancedBinaryTree.getRoot().getHeight());
        System.out.println("左子树高度："+balancedBinaryTree.getRoot().getLeftHeight());
        System.out.println("右子树高度："+balancedBinaryTree.getRoot().getRightHeight());
    }
}

class BalancedBinaryTree{
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void add(AVLNode node){
        if (root == null){
            root = node;
            return;
        }
        root.add(node);

        // left rotate and right rotate
        if (root.getRightHeight() - root.getLeftHeight() > 1){
            if (root.right != null && root.right.getLeftHeight() > root.right.getRightHeight()){
                root.right = root.right.rightRotate();
            }
            root = root.leftRotate();
        }
        if (root.getLeftHeight() - root.getRightHeight() > 1){
            if (root.left != null && root.left.getRightHeight() > root.left.getLeftHeight()){
                root.left = root.left.leftRotate();
            }
            root = root.rightRotate();
        }
    }

    public void infixOrder(){
        if (root != null){
            System.out.println("中序遍历结果:");
            root.infixOrder();
        }else {
            System.out.println("empty tree!");
        }
    }
}

class AVLNode{
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public int getLeftHeight(){
        if (left == null){
            return 0;
        }else {
            return left.getHeight();
        }
    }

    public int getRightHeight(){
        if (right == null){
            return 0;
        }else {
            return right.getHeight();
        }
    }

    public int getHeight(){
        return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight())+1;
    }

    public AVLNode leftRotate(){
        AVLNode newNode = this.right;
        this.right = this.right.left;
        newNode.left = this;
        return newNode;
    }

    public AVLNode rightRotate(){
        AVLNode newNode = this.left;
        this.left = this.left.right;
        newNode.right = this;
        return newNode;
    }

    public void add(AVLNode node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.toString());
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}