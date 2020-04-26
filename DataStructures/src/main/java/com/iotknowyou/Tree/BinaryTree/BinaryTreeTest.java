package com.iotknowyou.Tree.BinaryTree;

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

        // 简单创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        binaryTree.setRoot(root);

        //测试
		System.out.println("前序遍历"); // 1,2,3,5,4
		binaryTree.preOrder();
		System.out.println("中序遍历");
		binaryTree.infixOrder(); // 2,1,5,3,4
		System.out.println("后序遍历");
		binaryTree.postOrder(); // 2,5,4,3,1


    }
}
