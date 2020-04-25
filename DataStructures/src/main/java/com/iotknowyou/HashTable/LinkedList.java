package com.iotknowyou.HashTable;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/25 10:39
 * @updateDate 2020/4/25 10:39
 **/
public class LinkedList<E> {

    //创建第一个节点
    private Node<E> head;


    //添加节点
    public void add(Node<E> node){
        // 判断是不是第一个节点 , true则直接赋值给第一个节点
        if(head == null){
            head = node;
            return;
        }

        // 如果不是第一个节点，向链表末端添加节点
        // 1、创建辅助接节点
        Node<E> help = head ;
        // 2、遍历至链表尾部
        while (true){
            if(help.getNext() == null){
                break;
            }
            help = help.getNext();
        }
        // 3、将节点加入到 链表中
        help.setNext(node);
    }

    //遍历链表
    public void showlist(){
        if(head == null){
            System.out.println("链表为空！");
            return;
        }
        // 1、创建辅助接节点
        Node<E> help = head ;

        // 2、遍历节点，依次输出
        while (true){
            System.out.println(help);
            if(help.getNext() == null){
                break;
            }
            // 后移指针
            help = help.getNext();
        }
    }
}
