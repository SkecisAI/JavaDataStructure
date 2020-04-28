package indi.huffman_tree;

import java.util.*;

public class HuffmanCodeDemo {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] strBytes = str.getBytes();
        List<CodeNode> codeNodeList = HuffmanCodeTree.getCodeList(strBytes);
        CodeNode root = HuffmanCodeTree.createHuffmanTree(codeNodeList);
//        HuffmanCodeTree.preOrder(root);
        HuffmanCodeTree.buildCode(root);  // 生成赫夫曼编码
        byte[] zipCode = HuffmanCodeTree.resultAfterZipping(strBytes);  // 编码文字
        System.out.println(Arrays.toString(zipCode));
    }
}

class HuffmanCodeTree{
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    public static byte[] resultAfterZipping(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b: bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        int byteLength = (stringBuilder.length() == 0) ? stringBuilder.length() / 8 : stringBuilder.length() / 8 + 1;
        byte[] res = new byte[byteLength];

        for (int i = 0, index = 0; i < stringBuilder.length(); i+=8, index++) {
            String strByte;
            if (i + 8 > stringBuilder.length()){       // 不够8位
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            res[index] = (byte) Integer.parseInt(strByte, 2);
        }
        return res;
    }

    public static List<CodeNode> getCodeList(byte[] strBytes){
        List<CodeNode> codeNodeList = new ArrayList<>();
        Map<Byte, Integer> strMap = new HashMap<>();
        for (byte b: strBytes){
            Integer count = strMap.get(b);
            strMap.put(b, count == null ? 1 : count+1);
        }
        for (Map.Entry<Byte, Integer> entry: strMap.entrySet()){
            codeNodeList.add(new CodeNode(entry.getKey(), entry.getValue()));
        }
        return codeNodeList;
    }

    public static CodeNode createHuffmanTree(List<CodeNode> codeNodeList){
        while (codeNodeList.size() > 1) {
            Collections.sort(codeNodeList);
            CodeNode left = codeNodeList.get(0);
            CodeNode right = codeNodeList.get(1);
            CodeNode parent = new CodeNode(null, left.weight + right.weight);
            parent.leftChild = left;
            parent.rightChild = right;
            codeNodeList.remove(left);
            codeNodeList.remove(right);
            codeNodeList.add(parent);
        }
        return codeNodeList.get(0);
    }

    public static void buildCode(CodeNode root){
        buildCode(root, "", new StringBuilder());
        System.out.println(huffmanCodes.toString());
    }

    public static void buildCode(CodeNode node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node!=null){
            if (node.data == null){
                buildCode(node.leftChild, "0", stringBuilder1);
                buildCode(node.rightChild, "1", stringBuilder1);
            }else {
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }

    public static void preOrder(CodeNode root){
        if (root != null){
            root.preOrder();
            return;
        }
        System.out.println("树空！");
    }
}

class CodeNode implements Comparable<CodeNode>{
    Byte data;
    int weight;
    CodeNode leftChild;
    CodeNode rightChild;

    public CodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
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
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(CodeNode o) {
        return this.weight - o.weight;
    }
}
