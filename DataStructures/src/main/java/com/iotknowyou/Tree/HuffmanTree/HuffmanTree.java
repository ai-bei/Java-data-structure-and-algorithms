package com.iotknowyou.Tree.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/28 14:07
 * @updateDate 2020/4/28 14:07
 **/
public class HuffmanTree<E> {


    /**
     *  Integer[] arr
     * @param  arr
     * @return
     */
    public  Node<Integer> createHuffmanTree(Integer[] arr) {
        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中
        List<Node<Integer>> nodes = new ArrayList<>();
        for (Integer value : arr) {
            nodes.add(new Node( value , value));
        }

        //我们处理的过程是一个循环的过程


        while(nodes.size() > 1) {

            //排序 从小到大
            Collections.sort(nodes);

            System.out.println("nodes =" + nodes);

            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            Node<Integer> leftNode = nodes.get(0);
            //(2) 取出权值第二小的结点（二叉树）
            Node<Integer> rightNode = nodes.get(1);

            //(3)构建一颗新的二叉树
            Node<Integer> parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.setLeft(leftNode) ;
            parent.setRight(rightNode);

            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);
        }

        //返回哈夫曼树的root结点
        return nodes.get(0);

    }


    //编写一个前序遍历的方法
    public  void preOrder(Node<E> root) {
        if(root != null) {
            root.preOrder();
        }else{
            System.out.println("是空树，不能遍历~~");
        }
    }
}
