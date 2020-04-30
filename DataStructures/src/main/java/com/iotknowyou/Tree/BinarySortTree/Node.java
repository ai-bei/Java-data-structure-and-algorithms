package com.iotknowyou.Tree.BinarySortTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description  排序二叉树的节点
 * @updateRemark
 **/
public class Node {
    private Integer data;

    private Node left ;

    private Node right ;

    /**
     * 构造排序二叉树的节点
     * @param data
     */
    public Node(Integer data) {
        this.data = data;
    }



    /**
     * 添加节点的方法 , 需要满足二叉排序树的要求
     * @param node
     */
    public void addNode(Node node){
        // 参数校验
        if(node == null){
            return;
        }

        //判断传入的结点的值，和当前子树的根结点的值关系
        if(node.getData() < this.getData()) {
            //如果当前结点左子结点为null
            if(this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.addNode(node);
            }
        } else { //添加的结点的值大于 当前结点的值
            if(this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.addNode(node);
            }

        }

    }


    //查找要删除的结点
    /**
     *
     * @param node 希望删除的结点
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(Node node) {
        if(node.getData().equals(this.getData())) { //找到就是该结点
            return this;
        } else if(node.getData() < this.getData()) {//如果查找的值小于当前结点，向左子树递归查找
            //如果左子结点为空
            if(this.left  == null) {
                return null;
            }
            return this.left.search(node);
        } else { //如果查找的值不小于当前结点，向右子树递归查找
            if(this.right == null) {
                return null;
            }
            return this.right.search(node);
        }

    }
    //查找要删除结点的父结点
    /**
     *
     * @param node 要找到的结点
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(Node node) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if((this.left != null && this.left.getData().equals(node.getData()) ) ||
                (this.right != null && this.right.getData().equals(node.getData()))) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if(node.getData() < this.getData() && this.left != null) {
                return this.left.searchParent(node); //向左子树递归查找
            } else if (node.getData() >= this.getData() && this.right != null) {
                return this.right.searchParent(node); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }

    }




    /**
     * 中序遍历
     */
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
















    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
