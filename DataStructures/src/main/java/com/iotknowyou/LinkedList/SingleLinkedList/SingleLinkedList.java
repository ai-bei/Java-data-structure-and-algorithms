package com.iotknowyou.LinkedList.SingleLinkedList;

/* 单链表实现 */
public class SingleLinkedList {
    //初始化一个头结点,头结点不要动，不存放具体的数据
    private Node head = new Node(0,"","");

    // 添加节点到单项链表
    // 在不考虑添加的顺序时：
    //  1、找到当前链表的最后节点
    //  2、将最后这个节点的 next 指向 新的节点

    /**
     * 单链表添加节点
     * @param node
     */
    public void add(Node node){

        // 因为 head节点不能动，因此我们需要一个辅助遍历的变量 temp
        Node temp = head;

        // 遍历链表，找到最后
         while (true){
             // 找到链表的最后
             if(temp.next == null){
                 break;
             }
             temp = temp.next;
         }
         // 当上面的循环结束后，temp就指向了 链表的最后

         // 将最后这个节点的next 指向 新的节点
        // 完成一个节点的添加
        temp.next = node;
    }


    /**
     * 根据 num的大小排序，并指定位置添加节点
     * @param node
     */
    public void addOrderByNum(Node node){
        //由于头结点不能动，用辅助变量 temp 找到添加的位置
        //在单链表中，temp 是位于添加位置的前一个节点 ( 否则，会添加失败)

        Node temp =  head;
        // 标志添加的编号是否存在，默认为 false
        boolean flag = false;

        while (true){
            //  temp.next == null  表示temp已经是 该单链表的末尾了
            if(temp.next == null){
                //到了链表的尾部，直接退出
                break;
            }
            if(temp.next.num > node.num){
                break;
            }else if (temp.next.num == node.num){ //说明希望添加的 节点的编号已经存在
                flag = true; // 编号已经了
                break;
            }

            //后移节点，避免死循环，
            temp = temp.next;
        }

        //判断 flag 的值
        if(flag){
            System.out.printf("该节点的 num = %d 已经存在了 \n",node.num);
        }else {
            // 插入到单链表中
            node.next = temp.next;
            temp.next = node;

        }
    }

    /**
     * 根据节点的num 修改节点信息 ，num的值是不能修改的
     * @param node
     */
    public void updateByNum(Node node){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为 null ~");
        }
        //找到需要修改的节点，根据num
        Node temp = head.next ; // 定义一个辅助变量
        boolean flag = false ; // 标志是否找到该节点
        while(true){
            if(temp == null){
                break; // 表示已经遍历完链表，没有找到指定num的节点
            }
            if (temp.num == node.num){
                flag = true; //找到指定num的节点
                break;
            }
            //后移
            temp = temp.next;
        }

        // 根据flag的结果，判断是否找到修改的节点
        if(flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else {
            //没有找到
            System.out.printf("没有找到 num = %d 的节点，不能修改。/n",node.num);
        }


    }

    /**
     * 根据 num 的值，删除节点
     * @param num
     */
    public void delete(int num){
        // 1. head 不能移动，我们需要引入 temp 辅助节点，
        // 找到待删除节点的前一个节点
        // 2. 在比较的时候，是 temp.next.num 和 需要删除的节点的 num 比较

        Node temp = head;
        boolean flag = false ; // 标志是否找到待删除的节点
        while (true){
            if(temp.next == null){ //遍历完没有找到
                break;
            }

            if(temp.next.num == num){
                flag = true;
                break;
            }

            // temp 后移，实现遍历
            temp = temp.next;
        }
        //判断遍历
        if(flag){
            // 删除该节点
            temp.next = temp.next.next;
        }else {
            System.out.printf("输入的节点 num = %d 不存在 ~",num);
        }
    }
    /**
     * 遍历显示链表
     */
    public void list(){
        // 判断链表是否为空
        if(head.next == null){
            System.out.println("This SingleLinkedList is NULL !");
            return;
        }

        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        Node  temp = head.next;
        while (true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }

            //输出节点的信息
            //System.out.println("This node information ：");
            System.out.println(temp);

            //将 temp 后移一位
            temp = temp.next;

        }
    }




}

