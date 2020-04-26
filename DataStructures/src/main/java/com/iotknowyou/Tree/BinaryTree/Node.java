package com.iotknowyou.Tree.BinaryTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  构建二叉树节点
 * @updateRemark
 * @createDate 2020/4/26 8:52
 * @updateDate 2020/4/26 8:52
 **/
public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    // 构造器
    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }


    //编写前序遍历的方法
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

    //中序遍历
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
    //后序遍历
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
        return "Node{" +
                "data=" + data +
                '}';
    }
}
