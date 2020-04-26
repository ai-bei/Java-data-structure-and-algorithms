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


    //前序遍历
    public Node<E> preOrderSearch(Node<E> node) {
        if(root != null) {
            return root.preOrderSearch(node);
        } else {
            return null;
        }
    }
    //中序遍历
    public Node<E> infixOrderSearch(Node<E> node) {
        if(root != null) {
            return root.infixOrderSearch(node);
        }else {
            return null;
        }
    }
    //后序遍历
    public Node<E> postOrderSearch(Node<E> node) {
        if(root != null) {
            return this.root.postOrderSearch(node);
        }else {
            return null;
        }
    }

    //删除结点
    public void delNode(Node<E> node) {
        if(root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if(root.getData() == node.getData()) {
                root = null;
            } else {
                //递归删除
                root.delNode(node);
            }
        }else{
            System.out.println("空树，不能删除~");
        }
    }


}
