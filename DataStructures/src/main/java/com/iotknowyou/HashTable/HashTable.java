package com.iotknowyou.HashTable;

import java.util.Random;

/**
 * @author LiuRongHua
 * @updateUser
 * @description   哈希表的实现
 * @updateRemark
 * @createDate 2020/4/25 10:37
 * @updateDate 2020/4/25 10:37
 **/
public class HashTable<M> {

    // 创建链表数组
    private LinkedList<M>[] HashLinkedListArray;

    // 链表数组的大小
    private Integer size;

    // 构造器
    public HashTable() {
    }

    public HashTable(Integer size) {
        this.size = size;
        // 初始化 HashLinkedListArray
        HashLinkedListArray = new LinkedList[size];
        // ** 初始化每一个链表
        for (Integer i = 0; i < size; i++) {
            HashLinkedListArray[i] = new LinkedList<M>();
        }
    }

    // 添加员工
    public void add(Node<M> node){
        // 创建一个随机数，让 数据 离散的存储在 哈希表中
        Random ran = new Random();
        // 生成随机索引
        Integer index = hashFun(ran.nextInt(size));
        // 添加数据
        HashLinkedListArray[index].add(node);

    }


    //遍历所有的链表,遍历hashtab
    public void list() {
        for(int i = 0; i < size; i++) {
            System.out.println("第 "+i+" 条链表的数据：" );
            HashLinkedListArray[i].showlist();
            System.out.println("-----------  分隔符   ------------");
        }
    }



    //编写散列函数, 使用一个简单取模法
    public int hashFun(int ran) {
        return ran % size;
    }
}
