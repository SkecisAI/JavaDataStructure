package indi.stack;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(4);
        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show: 显示栈");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("exit: 退出程序");
            System.out.println("输入命令:");
            key = scanner.next();
            switch (key){
                case "show":
                    as.traverse();
                    break;
                case "push":
                    int value = scanner.nextInt();
                    as.push(value);
                    break;
                case "pop":
                    try {
                        int result = as.pop();
                        System.out.printf("pop->(%d)\n", result);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayStack {
    private int top = -1;
    private final int maxSize;
    private final int[] stack;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int returnValue = stack[top];
        top--;
        return returnValue;
    }

    public void traverse(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("[%d]: %d\n", i, stack[i]);
        }
    }
}