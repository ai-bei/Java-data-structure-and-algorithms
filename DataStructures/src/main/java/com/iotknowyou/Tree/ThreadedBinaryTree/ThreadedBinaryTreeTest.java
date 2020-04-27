package com.iotknowyou.Tree.ThreadedBinaryTree;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description 线索二叉树
 * @updateRemark
 * @createDate 2020/4/27 10:01
 * @updateDate 2020/4/27 10:01
 **/
public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        Node<User> root = new Node<>(new User(1, "tom"));
        Node<User> node2 = new Node<>(new User(3, "jack"));
        Node<User> node3 = new Node<>(new User(6, "smith"));
        Node<User> node4 = new Node<>(new User(8, "mary"));
        Node<User> node5 = new Node<>(new User(10, "king"));
        Node<User> node6 = new Node<>(new User(14, "dim"));

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        Node<User> leftNode = node5.getLeft();
        Node<User> rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6





    }

    @Test
    public void test(){
        //测试一把中序线索二叉树的功能
        Node<User> root = new Node<>(new User(1, "tom"));
        Node<User> node2 = new Node<>(new User(3, "jack"));
        Node<User> node3 = new Node<>(new User(6, "smith"));
        Node<User> node4 = new Node<>(new User(8, "mary"));
        Node<User> node5 = new Node<>(new User(10, "king"));
        Node<User> node6 = new Node<>(new User(14, "dim"));

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试前序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodesByPreOrder();


        // 前序线索化二叉树 遍历输出
        threadedBinaryTree.threadedNodesByPreOrderList();


        System.out.println("");
    }

    @Test
    public void test2(){
        //测试一把中序线索二叉树的功能
        Node<User> root = new Node<>(new User(1, "tom"));
        Node<User> node2 = new Node<>(new User(3, "jack"));
        Node<User> node3 = new Node<>(new User(6, "smith"));
        Node<User> node4 = new Node<>(new User(8, "mary"));
        Node<User> node5 = new Node<>(new User(10, "king"));
        Node<User> node6 = new Node<>(new User(14, "dim"));

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);




        System.out.println("");
    }


    @Test
    public void test3(){
        String[] strings = {"1","3","6","8","10","14"};
        createTree<String> stringcreateTree = new createTree<>();
        Node<String> binaryTreeRoot = stringcreateTree.createBinaryTree(strings, 0);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(binaryTreeRoot);


        // 测试后序线索化
        threadedBinaryTree.threadedNodesByPostOrder();


        // 后序线索化二叉树 遍历输出
        threadedBinaryTree.threadedNodesByPostOrderList();

        System.out.println();
    }

}
