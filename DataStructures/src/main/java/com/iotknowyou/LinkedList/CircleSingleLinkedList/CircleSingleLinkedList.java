package com.iotknowyou.LinkedList.CircleSingleLinkedList;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  单向环形链表的实现
 * @updateRemark
 * @createDate 2020/4/16 12:17
 * @updateDate 2020/4/16 12:17
 **/
public class CircleSingleLinkedList<E> {
    // 初始化创建 first 节点, 当前没有节点。
    private Node<E> firstNode = null;

    /**
     * 生成节点数位num的单向循环链表，初始化节点中的data=null
     * @param num
     */
    public void addNode(int num){
        // 校验 num 的值
        if(num < 1){
            System.out.println("num < 1 ,输入的值不正确！");
            return;
        }

        // 创建 currentNode 辅助变量, 帮助构建环形链表
        // currentNode 指向单向环形链表的最后一个节点
        Node<E>  currentNode = null;

        for (int i = 1; i <= num; i++) {
            Node<E> node = new Node<>(null,i);
            //当创建第一个节点时，需要将 node赋值给firstNode 并将next指向自身
            if(i == 1){
                firstNode = node;
                firstNode.setNext(firstNode);
                currentNode = firstNode;
            }else {
            //不是创建第一节点, 只需要执行3步
            // 1、currentNode的 Next  指向新的 node
            // 2、新的node的Next 指向 firstNode
            // 3、currentNode 需要指向 新的node
                currentNode.setNext(node);
                node.setNext(firstNode);
                currentNode = node;
            }
        }


    }


    /**
     * 约瑟夫环问题的求解
     *
     * @param startNo   表示从第环中第几节点开始数数
     * @param countNum  表示计算步长
     * @param nums      表示环中最初有多少节点
     */
    public void countNodeOutIndex(int startNo , int countNum , int nums){
        // 数据校验
        if(firstNode == null || startNo < 1 || startNo > nums){
            System.out.println("输入数据有误 ！");
            return;
        }

        // 创建 currentNode 辅助变量, 帮助遍历环形链表
        // lastNode 需要指向最后的一个节点
        Node<E>  lastNode = firstNode;
        while (true){
            // while循环跳出后，lastNode 指向了最后的一个节点
            if(lastNode.getNext() == firstNode){
                break;
            }
            lastNode = lastNode.getNext();
        }

        // firstNode 和 lastNode 分别移动 (startNo - 1) 次
        for (int i = 0; i < startNo - 1; i++) {
            firstNode = firstNode.getNext();
            lastNode = lastNode.getNext();
        }


        //firstNode 和 lastNode 分别移动 (countNum - 1) 次
        //  节点出环
        // 这里是一个循环操作
        while (true){
            // 说明环中，只有一个节点
            if(lastNode == firstNode){
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                firstNode = firstNode.getNext();
                lastNode = lastNode.getNext();
            }
            // 这时 firstNode 指向的节点，就是需要出环的节点
            System.out.println("节点出环：" + firstNode.toString());
            // 此时，需要删除环形链表中的出环的节点
            firstNode = firstNode.getNext();
            lastNode.setNext(firstNode);
        }
        System.out.println("最后出环的节点：" + firstNode.toString());

    }

    /**
     * 遍历当前的环形链表
     */
    public void showList(){
        // 判断链表是否为空
        if(firstNode == null){
            System.out.println("当前的链表为NUll ！");
            return;
        }
        // 创建 currentNode 辅助变量, 帮助遍历环形链表
        Node<E>  currentNode = firstNode;
        while (true){
            System.out.println("节点信息：" + currentNode.toString());
            if (currentNode.getNext() == firstNode){
                break;
            }
            currentNode = currentNode.getNext();
        }
    }
}
