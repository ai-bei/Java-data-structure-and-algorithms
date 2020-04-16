package com.iotknowyou.Queue;

import java.util.Scanner;

/*
    存在问题：
       数组使用一次，就不能使用了。
       即：数据不能重复使用。
    改进代码：
        将这个数组使用算法，改进成一个环形的队列

*/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个 队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add):  添加数据到队列");
            System.out.println("g(get):  从队列中取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's' :
                    arrayQueue.showQueue();
                    break;
                case 'a' :
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g' :
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("你取出的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h' :
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e' :
                    scanner.close();
                    loop = false;
                    break;

                default:break;
            }
        }

        System.out.println("程序退出。");
    }
}


// 使用数组模拟队列 ，
class ArrayQueue{
    //数组的最大容量
    private int maxSize;
    //队列 头
    private int front;
    //队列 尾
    private int rear;
    // g该数据用于存放数据，模拟队列
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front=-1; // 指向队列头部，指向队列头的前一个位置
        rear=-1;  // 指向队列尾部，指向队列尾的数据（即就是队列最后一个数据 ）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int data){
        if(isFull()){
            System.out.println("队列已经满了，不能加数据！！！");
            return;
        }

        rear++; // 往后移动一位
        arr[rear] = data;
    }

    //获取队列的数据
    public int getQueue(){
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("队列为空，不能取数据。");
        }
        front++; // 往后移动一位
        int res = arr[front];
        // 取出数据后，将原数据设置为 0
        arr[front] = 0;
        return res;
    }

    //显示所有的数据
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列为空，没有数据。");
            return;
        }
        for (int i=0 ; arr.length > i ; i++ ) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，（并没有取数据）
    public int headQueue(){
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列为空，不能取数据。");
        }
        return arr[front+1];
    }
}