package com.iotknowyou.Tree.AVLTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 **/
public class AVLTreeNode<T extends Comparable<T>> {
    T element;                       // 值
    int height;                      // 高度
    AVLTreeNode<T> left;             // 左孩子
    AVLTreeNode<T> right;            // 右孩子

    public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
        this.element = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    // 前序遍历的方法
    public void preOrder() {
        System.out.println(this); //先输出父结点
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {

        //递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "AVLTreeNode{" +
                "element=" + element +
                '}';
    }
}
