package indi.linkedlist;

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        int kidsNum1 = 17, start1 = 1, m1 = 7;  // answer = 2
        int kidsNum2 = 5, start2 = 1, m2 = 2;
        CircularLinkedList josephProblemCircularLinkedList = new CircularLinkedList(kidsNum1);
        josephProblemCircularLinkedList.add();
//        josephProblemCircularLinkedList.traverse();
        josephProblemCircularLinkedList.resolveProblem(start1, m1);
    }
}

class CircularLinkedList{
    private ChildNode first = new ChildNode(0);
    private int length;

    public CircularLinkedList(int len){
        length = len;
    }

    public void resolveProblem(int start, int m){
        if (start<=0 || start > length || first.getId()==0){
            System.out.println("错误的开始编号!");
            return;
        }
        System.out.println("解决中... ...");
        ChildNode startNode = first;
        ChildNode last = startNode;
        while (true){
            if (startNode.getId()==start){
                break;
            }else {
                startNode = startNode.getNext();
            }
        }
        int numberOff = 0;
        while (true){
            numberOff++;
            if (numberOff == m){
                System.out.println(startNode.toString()+"出列...");
                last.setNext(startNode.getNext());
                numberOff = 0;
            }
            last = startNode;
            startNode = startNode.getNext();
            if (last.getId() == startNode.getId()){
                System.out.println("最后是："+startNode.toString());
                break;
            }
        }
    }

    public void add(){
        if (length < 0){
            System.out.println("数量不正确");
            return;
        }
        ChildNode curr = first;
        for (int i = 1; i <= length; i++) {
            if (i == 1){
                first.setId(i);
                first.setNext(first);
            }else {
                ChildNode newNode = new ChildNode(i);
                curr.setNext(newNode);
                newNode.setNext(first);
                curr = newNode;
            }
        }
    }

    public void traverse(){
        System.out.println("展示环：");
        if (first.getId()==0){
            System.out.println("没有节点！");
            return;
        }
        ChildNode tmp = first;
        while (true){
            System.out.println(tmp.toString());
            tmp = tmp.getNext();
            if (tmp.getId() == first.getId()){
                return;
            }
        }
    }
}

class ChildNode{
    private int id;
    private ChildNode next;

    public ChildNode(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNext(ChildNode next) {
        this.next = next;
    }

    public ChildNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "ChildNode{" +
                "id=" + id +
                '}';
    }
}