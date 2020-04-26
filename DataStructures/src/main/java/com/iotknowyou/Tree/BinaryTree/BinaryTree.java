package com.iotknowyou.Tree.BinaryTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/26 10:11
 * @updateDate 2020/4/26 10:11
 **/
public class BinaryTree<E> {

    // 创建根节点
    private Node<E> root;

    public BinaryTree() {
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}
