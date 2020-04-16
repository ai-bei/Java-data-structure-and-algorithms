package com.iotknowyou.LinkedList.CircleSingleLinkedList;

/**
 * @author LiuRongHua
 * @updateUser
 * @description 单向环形链表的Node实例
 * @updateRemark
 * @createDate 2020/4/16 12:06
 * @updateDate 2020/4/16 12:06
 **/
public class Node<T> {
    // 单向环形链表，数据域
    private T data;

    // next 指向下一个节点
    private Node<T> next;

    // number 节点的标识
    private int number;

    // 方法构造器

    public Node() {
    }

    public Node(T data, int number) {
        this.data = data;
        this.number = number;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", number=" + number +
                '}';
    }
}
