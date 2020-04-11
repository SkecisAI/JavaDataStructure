package indi.linkedlist;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        AnimalNode node1 = new AnimalNode(1, "小猫");
        AnimalNode node2 = new AnimalNode(2, "小狗");
        AnimalNode node3 = new AnimalNode(3, "小猪");
        AnimalNode node4 = new AnimalNode(4, "小鸡");
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList();
        myDoublyLinkedList.add(node1);
        myDoublyLinkedList.add(node3);
        myDoublyLinkedList.add(node2);
        myDoublyLinkedList.add(node4);
        myDoublyLinkedList.traverse();
        myDoublyLinkedList.del(1);
        System.out.println("删除节点... ...");
        myDoublyLinkedList.traverse();
        System.out.println("修改... ...");
        myDoublyLinkedList.update(new AnimalNode(3, "小猪猪"));
        myDoublyLinkedList.traverse();
    }
}

class DoublyLinkedList{
    private AnimalNode head = new AnimalNode(0, "");

    public AnimalNode getHead() {
        return head;
    }

    public void traverse(){
        if (head.next == null){
            System.out.println("链表为空~~");
            return;
        }
        AnimalNode tmp = head.next;
        while (tmp != null){
            System.out.println(tmp.toString());
            tmp = tmp.next;
        }
    }

    public void add(AnimalNode pn){
        AnimalNode tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = pn;
        pn.pre = tmp;
    }

    public void update(AnimalNode pn){
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        AnimalNode tmp = head.next;
        while (tmp.id != pn.id){
            tmp = tmp.next;
            if (tmp == null){
                System.out.println("Not fount.");
                return;
            }
        }
        tmp.name = pn.name;
    }

    public void del(int id){
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        AnimalNode tmp = head.next;
        while (tmp.id != id){
            tmp = tmp.next;
            if (tmp == null){
                System.out.println("Not fount.");
                return;
            }
        }
        tmp.pre.next = tmp.next;
        if (tmp.next != null){
            tmp.next.pre = tmp.pre;
        }
    }
}

class AnimalNode{
    public int id;
    public String name;
    public AnimalNode next;
    public AnimalNode pre;

    public AnimalNode(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnimalNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}