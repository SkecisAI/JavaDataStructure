package indi.hash_table;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String key;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加");
            System.out.println("list: 显示");
            System.out.println("find: 寻找");
            System.out.println("exit: 退出");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    Employee emp = new Employee(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.reverse();
                    break;
                case "find":
                    System.out.println("输入id");
                    int seekId = scanner.nextInt();
                    hashTable.findEmpById(seekId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

class HashTable{
    private final EmpLinkedList[] empLinkedLists;
    private final int size;

    public HashTable(int size){
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Employee emp){
        int empListNo = hashFunc(emp.id);
        empLinkedLists[empListNo].add(emp);
    }

    public void reverse(){
        for (int i = 0; i < size; i++) {
            System.out.printf("第%d条链表--", i+1);
            empLinkedLists[i].reverse();
        }
    }

    public void findEmpById(int id){
        Employee emp = empLinkedLists[hashFunc(id)].find(id);
        if (emp == null){
            System.out.println("not found");
        }else {
            System.out.printf("在第%d条链表中\n", hashFunc(id)+1);
        }
    }

    public int hashFunc(int id){
        return id % size;
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Employee head;

    public void add(Employee emp){
        if (head==null){
            head = emp;
            return;
        }
        Employee currEmp = head;
        while (currEmp.next!=null){
            currEmp = currEmp.next;
        }
        currEmp.next = emp;
    }

    public void reverse(){
        if (head==null){
            System.out.println("链表为空");
            return;
        }
        System.out.print("链表信息为：");
        Employee currEmp = head;
        while (currEmp!=null){
            System.out.printf("=>(id=%d,name=%s)", currEmp.id, currEmp.name);
            currEmp = currEmp.next;
        }
        System.out.println();
    }

    public Employee find(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Employee currEmp = head;
        while (currEmp != null){
            if (currEmp.id == id){
                return currEmp;
            }
            currEmp = currEmp.next;
        }
        return null;
    }
}