package com.iotknowyou.LinkedList.DoubleLinkedList;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  双向链表的实现 -- 带表头的双向链表
 * @updateRemark
 * @createDate 2020/4/15 13:52
 * @updateDate 2020/4/15 13:52
 **/
public class DoubleLinkedList<E>  {
    // 先初始化一个头结点
    private Node<E> HeadNode  = new Node<>();


    // 获取头节点
    public Node<E> getHeadNode(){
        return HeadNode;
    }


    // 添加节点信息
    public void addNode(Node<E> newNode){
        // 因为 head节点不能动，因此我们需要一个辅助遍历的变量 temp
        Node<E> temp = HeadNode;

        // 遍历链表，找到最后
        while (true){
            // 找到链表的最后
            if(temp.Next == null){
                break;
            }
            temp = temp.Next;
        }
        // 当上面的循环结束后，temp就指向了 链表的最后

        // 将最后这个节点的next 指向 新的节点
        temp.Next = newNode;
        // newNode的pre指向temp ， 形成一个双向链表
        newNode.Pre = temp;
    }

    // 该方法只针对 E
    // 添加节点信息，通过 Node 中 Data域中的 User ---> Number
    public void addNodeByUserNamber(Node<E> newNode){
        if( newNode.Data instanceof User){
            User newUser = (User) newNode.Data ;
            // 因为 head节点不能动，因此我们需要一个辅助遍历的变量 temp
            Node<E> temp = HeadNode;

            // 定义一个flag表示是否找到待添加数据的前一个节点
            boolean flag = false;

            // 遍历链表，找到最后
            while (true){
                // 插入的位置在 头节点和 第一个节点之间
                if(((User)temp.Next.Data).getNumber() >= newUser.getNumber()){
                    flag = true;
                    break;
                }else {
                // 插入的位置不在 头节点和第一个节点之间
                    temp = temp.Next;
                    //当需要插入的节点在最后时
                    if(temp.Next == null){
                        flag = true;
                        break;
                    }
                    User userTemp_pre = (User) temp.Data;
                    User userTemp_next = (User) temp.Next.Data;
                    // 已经遍历完链表
                    if(temp == null){
                        break;
                    }
                    // 找到链表中待插入的前一个位置
                    if(  userTemp_pre.getNumber()< newUser.getNumber() &&  userTemp_next.getNumber() >= newUser.getNumber() ){
                        flag = true;
                        break;
                    }
                }
            }
            // 当上面的循环结束后，temp就指向了链表中节点插入前一个位置
            // 需要判断是不是最后一个节点
            if(temp.Next != null){
                // temp.Next 的 Pre 指向 newNode
                temp.Next.Pre = newNode;
                // newNode 的Pre 指向 temp
                newNode.Pre = temp;
                // newNode 的Next 指向 temp.Next
                newNode.Next = temp.Next;
                // temp.Next 指向 newNode
                temp.Next = newNode;
                // 最后 形成一个双向链表
            }else {
                // 将最后这个节点的next 指向 新的节点
                temp.Next = newNode;
                // newNode的pre指向temp ， 形成一个双向链表
                newNode.Pre = temp;
            }
        }else{
            System.out.println("非 Node<User> 不能调用该方法 ！");
        }
    }

    // 从双向链表中删除一个节点
    public void delNode(Node<E> newNode){
        //判断当前链表是否为空
        if(HeadNode.Next == null ){
            System.out.println("当前的链表为空，无法删除 ！！");
            return;
        }
        // 创建辅助变量，遍历双向链表
        Node<E> temp = HeadNode.Next;

        // 定义一个flag表示是否找到待删除节点
        boolean flag = false;
        // 循环遍历双向链表
        while (true){
            // 已经遍历完链表
            if(temp == null){
                break;
            }
            // 找到了对应的节点
            if(temp.Data == newNode.Data){
                flag = true;
                break;
            }

            // temp 后移动
            temp = temp.Next;
        }

        // 判断flag ，为true时可以删除
        if(flag){
            temp.Pre.Next = temp.Next;
        // 需要注意的是，如果是最后一个节点，那么它next是指向null的，这时候我们对null取Pre会报空指针异常。
            if(temp.Next != null ){
                temp.Next.Pre = temp.Pre;
            }
        }else{
            System.out.println("删除的节点不存在！");
        }
    }


    // 修改节点的信息
    public void updateNode(Node<E> oldNode,Node<E> newNode){
//判断当前链表是否为空
        if(HeadNode.Next == null ){
            System.out.println("当前的链表为空，无法删除 ！！");
            return;
        }
        // 创建辅助变量，遍历双向链表
        Node<E> temp = HeadNode.Next;

        // 定义一个flag表示是否找到待删除节点
        boolean flag = false;
        // 循环遍历双向链表
        while (true){
            // 已经遍历完链表
            if(temp == null){
                break;
            }
            // 找到了对应的节点
            if(temp.Data == oldNode.Data){
                flag = true;
                break;
            }

            // temp 后移动
            temp = temp.Next;
        }

        // 判断flag ，为true时可以删除
        if(flag){
            //修改节点的信息Data
            temp.Data = newNode.Data;
        }else{
            System.out.println("删除的节点不存在！");
        }
    }

    // 遍历显示节点
    public void showlist(){
        // 判断链表是否为空
        if(HeadNode.Next == null){
            System.out.println("This SingleLinkedList is NULL !");
            return;
        }

        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        Node<E>  temp = HeadNode.Next;
        while (true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }

            //输出节点的信息
            //System.out.println("This node information ：");
            System.out.println(temp);

            //将 temp 后移一位
            temp = temp.Next;

        }
    }
}
