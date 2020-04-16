package com.iotknowyou.LinkedList.SingleLinkedList;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        //测试
        Node node_1 = new Node(1,"user_1","name_1");
        Node node_2 = new Node(2,"user_2","name_2");
        Node node_3 = new Node(3,"user_3","name_3");
        Node node_4 = new Node(4,"user_4","name_4");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // ********************************************************************

        singleLinkedList.add(node_1);
        singleLinkedList.add(node_2);
        singleLinkedList.add(node_3);
        singleLinkedList.add(node_4);

        //遍历显示
        singleLinkedList.list();


        // ********************************************************************

        System.out.println("********************************************************************");
        //加入按照编号的顺序

        singleLinkedList.addOrderByNum(node_1);
        singleLinkedList.addOrderByNum(node_4);
        singleLinkedList.addOrderByNum(node_3);
        singleLinkedList.addOrderByNum(node_2);

        //遍历显示
        singleLinkedList.list();

        System.out.println("********************************************************************");
        //测试修改节点
        Node newDode = new Node(2,"person_02","nickname_02");
        singleLinkedList.updateByNum(newDode);

        //遍历显示
        singleLinkedList.list();

        System.out.println("********************************************************************");
        //删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        singleLinkedList.delete(2);

        //遍历显示
        singleLinkedList.list();

    }
}
