package indi.binary_tree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int e: arr){
            binarySearchTree.add(new Node(e));
        }
        binarySearchTree.infixOrder();
        binarySearchTree.deleteBST(new Node(9));
        binarySearchTree.infixOrder();
    }
}

class BinarySearchTree{
    private Node root;
    static boolean isFind = false;

    public void add(Node node){
        if (root == null){
            root = node;
            return;
        }
        root.add(node);
    }

    public void infixOrder(){
        if (root != null){
            System.out.println("中序遍历结果:");
            root.infixOrder();
        }else {
            System.out.println("empty tree!");
        }
    }

    public void deleteBST(Node target){
        if (root == null){
            System.out.println("empty tree");
            return;
        }
        deleteBST(root, target.value, null);
        if (isFind){
            System.out.println("节点已删除");
        }else {
            System.out.println("节点没有找到");
        }
    }

    public void deleteBST(Node bstNode, int value, Node parent){
        if (bstNode == null){
            return;
        }
        if (bstNode.value == value) {         // find target node
            isFind = true;
            if (parent != null) {
                bstNode.deleteSelf(parent);   // 删除的不是根节点
            }else {
                root = bstNode.deleteRoot();  // 删除的是根节点
            }
        }
        else if (value < bstNode.value){
            deleteBST(bstNode.left, value, bstNode);
        }else {
            deleteBST(bstNode.right, value, bstNode);
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node){
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

    public void deleteLeaf(Node leaf){
        if (this.left != null && this.left.value == leaf.value){
            this.left = null;
        }else {
            this.right = null;
        }
    }

    public void deleteSingleBranch(Node node, Node single){
        if (this.left != null && this.left.value == node.value){
            this.left = single;
        }else{
            this.right = single;
        }
    }

    public void deleteSelf(Node parent){
        if (this.right == null && this.left == null){
            parent.deleteLeaf(this);
        }
        else if (this.right == null || this.left == null){
            parent.deleteSingleBranch(this, this.left == null ? this.right : this.left);
        }else {
            parent.left = this.left;   // 重接左子树
            Node tmp = this.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = this.right;    // 重接右子树
        }
    }

    public Node deleteRoot(){
        Node root;
        if (this.right == null && this.left == null){
            root = null;
        }else if (this.right == null || this.left == null){
            root = (this.left == null) ? this.right : this.left;
        }else {
            root = this.left;    // 更新根节点
            Node tmp = this.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = this.right;    // 重接右子树
        }
        return root;
    }
}
