package com.iotknowyou.LinkedList.DoubleLinkedList;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/15 13:56
 * @updateDate 2020/4/15 13:56
 **/
public class Node<T> {

    /**
     * 指向下一个节点
     */
    public Node<T> Next;

    /**
     * 双向链表数据域
     */
    public T Data;

    /**
     * 指向前一个节点
     */
    public Node<T> Pre;

    /**
     * 构造器
     */

    public Node() {
    }

    public Node( T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "Data=" + Data +
                '}';
    }
}
