package com.iotknowyou.Tree.BinaryTree;

import org.junit.Test;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/26 10:23
 * @updateDate 2020/4/26 10:23
 **/
public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        Node<User> root = new Node<>(new User( 1,"liu"));
        Node<User> node1 = new Node<>(new User(2,"liu"));
        Node<User> node2 = new Node<>(new User(3,"liu"));
        Node<User> node3 = new Node<>(new User(4,"liu"));
        Node<User> node4 = new Node<>(new User(5,"liu"));
        Node<User> node5 = new Node<>(new User(6,"liu"));
        Node<User> node6 = new Node<>(new User(7,"liu"));

        // 简单创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        binaryTree.setRoot(root);

        //测试
		System.out.println("前序遍历"); // 1,2,3,5,4
		binaryTree.preOrder();
		System.out.println("中序遍历");
		binaryTree.infixOrder(); // 2,1,5,3,4
		System.out.println("后序遍历");
		binaryTree.postOrder(); // 2,5,4,3,1
        System.out.println("-----------------------------");
        //测试  查找
        Node resnode1 = binaryTree.preOrderSearch(root);
        System.out.println(resnode1);
        Node resnode2 = binaryTree.postOrderSearch(root);
        System.out.println(resnode2);
        Node resnode3 = binaryTree.infixOrderSearch(root);
        System.out.println(resnode3);

        Node resnode4 = binaryTree.preOrderSearch(node5);
        System.out.println(resnode4);
        Node resnode5 = binaryTree.postOrderSearch(node5);
        System.out.println(resnode5);
        Node resnode6 = binaryTree.infixOrderSearch(node5);
        System.out.println(resnode6);

        System.out.println("-----------------------------");
        // 测试删除
        binaryTree.delNode(node3);
        System.out.println("前序遍历"); //
        binaryTree.preOrder();
    }

    @Test
    public void test(){
        BinaryTree binaryTree = new BinaryTree();
        Node<User> root = new Node<>(new User( 1,"liu"));
        Node<User> node1 = new Node<>(new User(2,"liu"));
        Node<User> node2 = new Node<>(new User(3,"liu"));
        Node<User> node3 = new Node<>(new User(4,"liu"));
        Node<User> node4 = new Node<>(new User(5,"liu"));
        Node<User> node5 = new Node<>(new User(6,"liu"));
        Node<User> node6 = new Node<>(new User(7,"liu"));


        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        binaryTree.setRoot(root);

        System.out.println("前序遍历"); //
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder(); //
        System.out.println("后序遍历");
        binaryTree.postOrder(); //
        System.out.println("-----------------------------");

    }
}
