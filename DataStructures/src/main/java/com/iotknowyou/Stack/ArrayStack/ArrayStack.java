package com.iotknowyou.Stack.ArrayStack;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  使用数组模拟  栈
 * @updateRemark
 * @createDate 2020/4/16 14:49
 * @updateDate 2020/4/16 14:49
 **/
public class ArrayStack {
    // 栈的大小
    private int maxSize;
    // 数组模拟器，数据存在数组中
    private int[] stack;
    // top表示栈顶，初始化为 -1
    private int top = -1;

    // 构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 判断栈满
    public boolean isFull(){
        return top == ( maxSize - 1 ) ;
    }

    // 判断栈为空
    public boolean isEmpty(){
        return top == -1 ;
    }

    // 入栈
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("栈满~~");
            return;
        }else {
            top++;
            stack[top] = value;
        }
    }

    // 出栈
    public int pop(){
        //判断栈是否为空
        if (isEmpty()){
            // 抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }

        // 将栈顶的值出栈
        int val = stack[top];
        // top 往后面移动一位
        top--;
        return val;
    }

    // 遍历栈 ，显示栈中的信息
    public void showStack(){

        // 判断是否为空
        if (isEmpty()){
            System.out.println("栈空，没有数据~~");
        }

        //需要注意：遍历栈时，需要从栈顶开始遍历
        for (int i = top; i >= 0; i--) {
            System.out.printf("Stack[%d] = %d\n",i,stack[i]);
        }


    }

}
