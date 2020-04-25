package indi.binary_tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadNode rootNode = new ThreadNode("1");
        ThreadNode threadNode2 = new ThreadNode("3");
        ThreadNode threadNode3 = new ThreadNode("8");
        ThreadNode threadNode4 = new ThreadNode("10");
        ThreadNode threadNode5 = new ThreadNode("6");
        ThreadNode threadNode6 = new ThreadNode("14");
        rootNode.setLeft(threadNode2);
        rootNode.setRight(threadNode5);
        threadNode2.setLeft(threadNode3);
        threadNode2.setRight(threadNode4);
        threadNode5.setLeft(threadNode6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(rootNode);
        threadedBinaryTree.infixThreadedNode();
        // pre:   1, (3, 8, 10,) (6, 14)
        // infix: (8, (3), 10,) 1, (14, (6))
        // test:
        System.out.println("前驱结点："+threadNode4.getLeft().toString());
        System.out.println("后继结点："+threadNode4.getRight().toString());
    }
}

class ThreadedBinaryTree{
    private final ThreadNode root;
    private static ThreadNode pre = null;

    public ThreadedBinaryTree(ThreadNode root) {
        this.root = root;
    }

    public void infixThreadedNode(){
        infixThreadedNode(this.root);
    }

    public void infixThreadedNode(ThreadNode node){
        if (node == null){
            return;
        }
        infixThreadedNode(node.getLeft());

        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftTag(Tag.Precursor);
        }
        if (pre != null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightTag(Tag.Subsequent);
        }
        pre = node;

        infixThreadedNode(node.getRight());

    }

//    public void infixOrder(){
//        System.out.println("中序遍历");
//        if (this.root!=null){
//            this.root.infixOrder();
//        }
//    }
}

class ThreadNode{
    private final String data;
    private ThreadNode left;
    private ThreadNode right;
    private Tag leftTag;
    private Tag rightTag;

    public ThreadNode(String data) {
        this.data = data;
        this.leftTag = Tag.LeftChild;
        this.rightTag = Tag.RightChild;
    }

//    public String getData() {
//        return data;
//    }

    public void setLeft(ThreadNode left) {
        this.left = left;
    }

    public ThreadNode getLeft() {
        return left;
    }

    public void setRight(ThreadNode right) {
        this.right = right;
    }

    public ThreadNode getRight() {
        return right;
    }

    public void setLeftTag(Tag leftTag) {
        this.leftTag = leftTag;
    }

//    public Tag getLeftTag() {
//        return leftTag;
//    }

    public void setRightTag(Tag rightTag) {
        this.rightTag = rightTag;
    }

//    public Tag getRightTag() {
//        return rightTag;
//    }

    @Override
    public String toString() {
        return "ThreadNode{" +
                "data='" + data + '\'' +
                ", leftTag=" + leftTag.toString() +
                ", rightTag=" + rightTag.toString() +
                '}';
    }

//    public void infixOrder(){
//        if (this.left != null){
//            this.left.infixOrder();
//        }
//        System.out.println(this);
//        if (this.right != null){
//            this.right.infixOrder();
//        }
//    }
}

enum Tag{
    LeftChild(0), RightChild(0), Precursor(1), Subsequent(1);
    private final int tag;

    Tag(int tag) {
        this.tag = tag;
    }

//    public int getTag() {
//        return tag;
//    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag=" + tag +
                '}';
    }
}