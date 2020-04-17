package com.iotknowyou.Stack.LinkedListStack;

import java.util.Iterator;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/17 19:43
 * @updateDate 2020/4/17 19:43
 **/
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<String> s = new LinkedListStack<>();
        for (int i = 0 ; i < 20;i++){
            s.push(String.valueOf(i));
            System.out.println("size: " + s.size());
        }
        // 使用for增强的方式遍历，底层使用的 迭代器
        for (String per : s){
            System.out.println(per);
        }

        // 使用迭代器的方式遍历
        Iterator iterator = s.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
