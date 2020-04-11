package indi.linkedlist;

import java.util.EmptyStackException;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        PersonNode node1 = new PersonNode(1, "小红");
        PersonNode node2 = new PersonNode(2, "小明");
        PersonNode node3 = new PersonNode(3, "小刚");
        PersonNode node4 = new PersonNode(4, "小新");
        SingleLinkedList mySingleLinkedList = new SingleLinkedList();
        mySingleLinkedList.addOrderly(node1);  // 有序添加
        mySingleLinkedList.addOrderly(node4);
        mySingleLinkedList.addOrderly(node3);
        mySingleLinkedList.addOrderly(node2);
        mySingleLinkedList.traverse();
        System.out.println("修改信息后... ...");
        mySingleLinkedList.update(new PersonNode(2, "小明明"));
        mySingleLinkedList.traverse();
        System.out.printf("链表长度为：%d\n", mySingleLinkedList.getLength());
        System.out.println("删除节点后... ...");
        mySingleLinkedList.del(2);
        mySingleLinkedList.traverse();
        System.out.printf("链表长度为：%d\n", mySingleLinkedList.getLength());
        int find = 3;
        System.out.println("寻找倒数第" + find +"个节点为："+mySingleLinkedList.findToLast(3));
        System.out.println("逆序打印... ...");
        mySingleLinkedList.printReversed();

    }
}

class SingleLinkedList{
    private PersonNode head = new PersonNode(0, "");

    public void printReversed(){
        if (head.next==null){
            System.out.println("链表为空");
        }
        Stack<PersonNode> s = new Stack<PersonNode>();
        PersonNode tmp = head.next;
        while (tmp!=null){
            s.push(tmp);
            tmp = tmp.next;
        }
        while (s.size() > 0){
            System.out.println(s.pop().toString());
        }
    }

    //单链表反转，头结点不动，反转链表体的内容
    public void reverse(){
        if (head.next==null){
            System.out.println("链表无需反转。");
            return;
        }
        PersonNode newHead = new PersonNode(0, "");
        PersonNode tmp = head.next;
        PersonNode tmp2;
        while (tmp!=null){
            tmp2 = tmp.next;

            tmp.next = newHead.next;
            newHead.next = tmp;

            tmp = tmp2;
        }
        head.next = newHead.next;
    }

    public PersonNode findToLast(int toLast){
        int len = this.getLength();
        if (head.next==null || toLast <= 0 || toLast > len ){
            System.out.println("没有该节点。");
            return null;
        }
        int index = 0;
        toLast = this.getLength() - toLast + 1;
        PersonNode curr = head.next;
        while (true){
            index++;
            if (index==toLast){
                return curr;
            }
            curr = curr.next;
        }
    }

    public int getLength(){
        int len = 0;
        if (head.next == null){
            return len;
        }
        PersonNode curr = head.next;
        while (curr!=null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    public void del(int id){
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        PersonNode tmp = head.next;
        PersonNode last = head;
        while (tmp.id != id){
            last = tmp;
            tmp = tmp.next;
            if (tmp == null){
                System.out.println("Not fount.");
                return;
            }
        }
        last.next = tmp.next;
    }

    public void update(PersonNode pn){
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        PersonNode tmp = head.next;
        while (tmp.id != pn.id){
            tmp = tmp.next;
            if (tmp == null){
                System.out.println("Not fount.");
                return;
            }
        }
        tmp.name = pn.name;
    }

    public void add(PersonNode pn){
        PersonNode tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = pn;
    }

    public void addOrderly(PersonNode pn){
        PersonNode tmp = head;
        PersonNode last;
        while (tmp.next!=null){
            last = tmp;
            tmp = tmp.next;
            if (pn.id < tmp.id){
                last.next = pn;
                pn.next = tmp;
                return;
            }
            else if (pn.id == tmp.id){
                System.out.println("已存在，不能添加。");
                return;
            }
        }
        tmp.next = pn;
    }

    public void traverse(){
        if (head.next == null){
            System.out.println("链表为空~~");
            return;
        }
        PersonNode tmp = head.next;
        while (tmp != null){
            System.out.println(tmp.toString());
            tmp = tmp.next;
        }
    }
}

class PersonNode{
    public int id;
    public String name;
    public PersonNode next;

    public PersonNode(int pId, String pName){
        this.id = pId;
        this.name = pName;
        this.next = null;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
