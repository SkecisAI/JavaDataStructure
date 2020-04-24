package indi.binary_tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //         A
        //      B     C
        //          E    D
        TreeNode root = new TreeNode(1, "A");
        TreeNode treeNode2 = new TreeNode(2, "B");
        TreeNode treeNode3 = new TreeNode(3, "C");
        TreeNode treeNode4 = new TreeNode(4, "D");
        TreeNode treeNode5 = new TreeNode(5, "E");

        root.setLeft(treeNode2);
        root.setRight(treeNode3);
        treeNode3.setRight(treeNode4);
        treeNode3.setLeft(treeNode5);

        binaryTree.setRoot(root);
        System.out.println("before deleting");
        binaryTree.preOrder();
        binaryTree.preOrderDelete(2);
        System.out.println("after deleting");
        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
//        System.out.println(binaryTree.preOrderSearch(2));

    }
}

class TreeNode{
    private final int id;
    private final String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public TreeNode preOrderSearch(int id){
        if (this.id == id){  // pre
            return this;
        }
        TreeNode res;
        if (this.left != null){
            res = this.left.preOrderSearch(id);
            if (res != null){
                return res;
            }
        }
        if (this.right != null){
            res = this.right.preOrderSearch(id);
            return res;
        }
        return null;
    }

    public void preOrderDelete(int id){
        if (this.left != null && this.left.id == id){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.preOrderDelete(id);
        }
        if (this.right != null){
            this.right.preOrderDelete(id);
        }
    }
}

class BinaryTree{
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preOrder(){
        System.out.println("前序遍历");
        if (this.root!=null){
            this.root.preOrder();
        }
    }

    public TreeNode preOrderSearch(int id){
        if (this.root!=null){
            return this.root.preOrderSearch(id);
        }else {
            return null;
        }
    }

    public void preOrderDelete(int id){
        if (this.root != null){
            if (this.root.getId() == id){
                this.root = null;
                return;
            }
            this.root.preOrderDelete(id);
        }else {
            System.out.println("树空，不能删除");
        }
    }

    public void infixOrder(){
        System.out.println("中序遍历");
        if (this.root!=null){
            this.root.infixOrder();
        }
    }

    public void postOrder(){
        System.out.println("后续遍历");
        if (this.root!=null){
            this.root.postOrder();
        }
    }
}
