package com.iotknowyou.LinkedList.DoubleLinkedList;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/15 14:14
 * @updateDate 2020/4/15 14:14
 **/
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        // 测试 DoubleLinkedList
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList<User>();

        // 创建Node数据
        Node<User> user_1 = new Node(new User(6,"用户1","用户1"));
        Node<User> user_2 = new Node(new User(9,"用户2","用户2"));
        Node<User> user_3 = new Node(new User(10,"用户3","用户3"));
        Node<User> user_4 = new Node(new User(12,"用户4","用户4"));
        Node<User> user_5 = new Node(new User(11,"用户5","用户5"));
        Node<User> user_6 = new Node(new User(17,"用户6","用户6"));
        Node<User> user_7 = new Node(new User(2,"用户7","用户7"));
        Node<User> user_8 = new Node(new User(2,"用户8","用户8"));
        doubleLinkedList.addNode(user_1);
        doubleLinkedList.addNode(user_2);
        doubleLinkedList.addNode(user_3);
        doubleLinkedList.addNode(user_4);
        //doubleLinkedList.updateNode(user_4,user_5);
        doubleLinkedList.addNodeByUserNamber(user_5);
        doubleLinkedList.addNodeByUserNamber(user_6);
        doubleLinkedList.addNodeByUserNamber(user_7);
        doubleLinkedList.addNodeByUserNamber(user_8);
        doubleLinkedList.showlist();
//        System.out.println(doubleLinkedList.getHeadNode());

    }


    @Test
    public void test(){
        // 测试 DoubleLinkedList
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList<String>();
        Node<String> node_1 = new Node<>(new String("node_1"));
        Node<String> node_2 = new Node<>(new String("node_2"));
        doubleLinkedList.addNode(node_1);
        doubleLinkedList.addNode(node_2);
        doubleLinkedList.delNode(node_1);
        doubleLinkedList.showlist();

    }
}
