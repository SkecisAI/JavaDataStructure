package indi.huffman_tree;

import java.util.*;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTreeNode huffmanTree = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(huffmanTree);
    }
}
// WPL
class HuffmanTree{
    public static HuffmanTreeNode createHuffmanTree(int[] arr){
        List<HuffmanTreeNode> huffmanTreeNodeList = new ArrayList<>();
        for (int e: arr){
            HuffmanTreeNode node = new HuffmanTreeNode(e);
            huffmanTreeNodeList.add(node);
        }
        while (huffmanTreeNodeList.size() > 1) {
            Collections.sort(huffmanTreeNodeList);
            HuffmanTreeNode left = huffmanTreeNodeList.get(0);
            HuffmanTreeNode right = huffmanTreeNodeList.get(1);
            HuffmanTreeNode parent = new HuffmanTreeNode(left.weight + right.weight);
            parent.setLeftChild(left);
            parent.setRightChild(right);
            huffmanTreeNodeList.remove(left);
            huffmanTreeNodeList.remove(right);
            huffmanTreeNodeList.add(parent);
        }
        return huffmanTreeNodeList.get(0);
    }

    public static void preOrder(HuffmanTreeNode root){
        if (root != null){
            root.preOrder();
            return;
        }
        System.out.println("赫夫曼树为空");
    }
}

class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
    int weight;
    HuffmanTreeNode leftChild;
    HuffmanTreeNode rightChild;

    public HuffmanTreeNode(int weight) {
        this.weight = weight;
    }

    public void setLeftChild(HuffmanTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(HuffmanTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.leftChild != null){
            this.leftChild.preOrder();
        }
        if (this.rightChild != null){
            this.rightChild.preOrder();
        }
    }

    @Override
    public String toString() {
        return "{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        return this.weight - o.weight;
    }
}
