package com.iotknowyou.LinkedList.SingleLinkedList;

public class Node {
    //定义一个 Node
    //next域

    // 指向下一个节点
    public Node next;


    // data域

    // 节点对象的信息
    public int num;

    public String name;

    public String nickname;

    //构造器
    public Node(int num ,String name , String nickname){
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    //输出
    @Override
    public String toString() {
        return "Node{" +
                /*"next=" + next +*/
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

