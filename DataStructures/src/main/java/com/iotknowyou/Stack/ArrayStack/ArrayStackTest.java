package com.iotknowyou.Stack.ArrayStack;

import java.util.Scanner;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/16 15:27
 * @updateDate 2020/4/16 15:27
 **/
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key= "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show: 显示栈信息");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("exit: 退出程序");
            System.out.println("请输入您的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int v = scanner.nextInt();
                    stack.push(v);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出栈的数据：" + res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
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
        System.out.println("程序结束");
    }


}
