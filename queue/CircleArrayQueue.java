package indi.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    int maxSize;
    int front;
    int rear;
    int[] arrQueue;

    public CircleArrayQueue(int maxSize_){
        maxSize = maxSize_;
        arrQueue = new int[maxSize];
        front = 0;  // 指向队列头元素的前一个位置
        rear = 0;   // 指向尾元素
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public void enqueue(int value){
        if (isFull()){
            System.out.println("队列已满！不能再添加数据~");
            return;
        }
        arrQueue[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("队列空！不能取数据");
        }
        int tmp = arrQueue[front];
        arrQueue[front] = 0;
        front = (front + 1) % maxSize;
        return tmp;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i = 0; i < arrQueue.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arrQueue[i]);
        }
    }

    public int peekQueueHead(){
        if (isEmpty()){
            throw new RuntimeException("队列空！");
        }
        return arrQueue[front + 1 % maxSize];
    }

    public int calQueueItemCount(){
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args){
        CircleArrayQueue aq = new CircleArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        char key;
        boolean loop = true;
        while (loop){
            System.out.println("-------");
            System.out.println("1. 显示队列");
            System.out.println("2. 添加数据到队列");
            System.out.println("3. 从队头取出数据");
            System.out.println("4. 查看队头");
            System.out.println("5. 统计队列元素");
            System.out.println("6. 退出");
            System.out.println("-------");
            key = scanner.next().charAt(0);
            switch (key){
                case '1':
                    aq.showQueue();
                    break;
                case '2':
                    System.out.print("输入一个数：");
                    int v = scanner.nextInt();
                    aq.enqueue(v);
                    break;
                case '3':
                    try {
                        System.out.println("取出的数为："+aq.dequeue());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case '4':
                    try{
                        System.out.println("队头的数为："+aq.peekQueueHead());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case '5':
                    System.out.println("队列长度为："+aq.calQueueItemCount());
                    break;
                case '6':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出。。。");
    }
}
