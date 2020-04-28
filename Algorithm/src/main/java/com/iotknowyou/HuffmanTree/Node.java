package com.iotknowyou.HuffmanTree;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/28 11:21
 * @updateDate 2020/4/28 11:21
 **/
public class Node<T> implements Comparable<Node<T>> {
    private Integer value ; // 节点的权值
    private  T data ;   // 数据域
    private Node<T> left;
    private Node<T> right;


    // 构造器
    public Node(Integer v ){
        this.value = v ;
    }

    public Node(Integer v , T d){
        this.value = v ;
        this.data = d ;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", data=" + data +
                '}';
    }


    //写一个前序遍历
    protected void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(Node<T> o) {
        // 表示从小到大排序
        return this.value - o.value;
    }
}
