package com.iotknowyou.Stack.CalculatorBaseStack;

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

    //返回栈顶的值
    public int peek(){
        return stack[top];
    }

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



    /**
     * 对运算符 符号进行比较，返回运算符的优先级
     * version_1.0  假定  运算符只有  + - * /
     *
     * @param oper  运算符
     * @return
     */
    public int priority(char oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1; // 不是 + - * / ，直接返回 -1
        }
    }


    /**
     * 判断是不是一个 运算符
     * 假定  运算符只有  + - * /
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val == '*' || val == '/' || val == '+' || val == '-' ;
    }

    /**
     * 计算方法
     * @param num_1
     * @param num_2
     * @param oper
     * @return
     */
    public int cal(int num_1 , int num_2 , char oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num_1 + num_2;
                break;
            case '-':
                res = num_1 - num_2;
                break;
            case '*':
                res = num_1 * num_2;
                break;
            case '/':
                res = num_1 / num_2;
                break;
            default:
                break;
        }
        return res;
    }
}
